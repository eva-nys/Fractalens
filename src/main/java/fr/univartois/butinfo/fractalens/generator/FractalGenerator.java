package fr.univartois.butinfo.fractalens.generator;

import java.awt.Color;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.function.BiFunction;
import java.util.function.IntFunction;

import fr.univartois.butinfo.fractalens.complex.IComplex;
import fr.univartois.butinfo.fractalens.complex.IComplexPlane;
import fr.univartois.butinfo.fractalens.complex.sequence.IComplexSequence;
import fr.univartois.butinfo.fractalens.image.IFractalImage;

/**
 * The FractalGenerator class generates a fractal image based on a complex number sequence
 */
public class FractalGenerator implements IFractalGenerator {

    // The image on which the fractal is drawn
    private final IFractalImage image;

    /**
     * The complex plane linking the pixels of the image to complex numbers
     */
    private final IComplexPlane plane;

    /**
     * The function building the complex sequence from its first term and the maximum of iterations
     */
    private final BiFunction<IComplex, Integer, IComplexSequence> sequenceFactory;

    /**
     * The maximum number of iterations allowed for a sequence
     */
    private final int maxIterations;

    /**
     * The color strategy, associating a number of iterations with a color
     */
    private final IntFunction<Color> palette;

    /**
     * The path of the file in which the generated image is saved
     */
    private final String outputPath;

    /**
     * Creates a new FractalGenerator
     *
     * @param image The image on which the fractal is drawn.
     * @param plane The complex plane linking pixels to complex numbers.
     * @param sequenceFactory The function building the sequence from {@code z0} and
     *        the maximum number of iterations.
     * @param maxIterations The maximum number of iterations allowed for a sequence.
     * @param palette The color strategy, associating a number of iterations with a
     *        color.
     * @param outputPath The path of the file in which the image is saved.
     */
    public FractalGenerator(IFractalImage image, IComplexPlane plane, BiFunction<IComplex, Integer, IComplexSequence> sequenceFactory, int maxIterations, IntFunction<Color> palette, String outputPath) {
        this.image = image;
        this.plane = plane;
        this.sequenceFactory = sequenceFactory;
        this.maxIterations = maxIterations;
        this.palette = palette;
        this.outputPath = outputPath;
    }

    /**
     * Generates the full fractal image
     * @return The generated image.
     */
    @Override
    public IFractalImage generateImage() {
        for (int row = 0; row < image.getHeight(); row++) {
            for (int column = 0; column < image.getWidth(); column++) {
                image.setColor(row, column, computePixelColor(row, column));
            }
        }
        saveImage();
        return image;
    }

    /**
     * Computes the color of a given pixel
     * @param row The row of the pixel.
     * @param column The column of the pixel.
     *
     * @return The color computed for the pixel
     */
    @Override
    public Color computePixelColor(int row, int column) {
        IComplex z0 = plane.asComplex(row, column);
        IComplexSequence sequence = sequenceFactory.apply(z0, maxIterations);

        int nbIterations = 0;
        for (IComplex _ : sequence) {
            nbIterations++;
        }
        return palette.apply(nbIterations);
    }

    /**
     * Saves the generated image in the output file
     */
    @Override
    public void saveImage() {
        try {
            image.saveAs(outputPath);
        } catch (IOException e) {
            throw new UncheckedIOException("Unable to save the image", e);
        }
    }

}