package fr.univartois.butinfo.fractalens.generator;

import fr.univartois.butinfo.fractalens.complex.*;
import fr.univartois.butinfo.fractalens.complex.plane.ComplexPlane;
import fr.univartois.butinfo.fractalens.complex.plane.IComplexPlane;
import fr.univartois.butinfo.fractalens.complex.plane.TranslateComplexPlane;
import fr.univartois.butinfo.fractalens.complex.plane.ZoomComplexPlane;
import fr.univartois.butinfo.fractalens.complex.sequence.EnumSequence;
import fr.univartois.butinfo.fractalens.complex.sequence.IComplexSequence;
import fr.univartois.butinfo.fractalens.complex.sequence.JuliaSequence;
import fr.univartois.butinfo.fractalens.image.FractalImage;
import fr.univartois.butinfo.fractalens.image.FractalImageComposite;
import fr.univartois.butinfo.fractalens.image.IFractalImage;
import fr.univartois.butinfo.fractalens.image.color.EnumPalette;
import fr.univartois.butinfo.fractalens.image.color.IColor;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class FractalGeneratorBuilder {

    private int width = 800;
    private int height = 600;
    private double zoomFactor = 1.0;
    private IComplex translation;
    private IComplex center;
    private int maxIterations = 100;
    private String fileName;
    private BiFunction<IComplex, Integer, IComplexSequence> function;
    private EnumPalette paletteEnum;
    private IColor palette;

    public FractalGeneratorBuilder withSize(int width, int height) {
        this.width = width;
        this.height = height;
        return this;
    }

    public FractalGeneratorBuilder withZoom(double zoomFactor) {
        this.zoomFactor = zoomFactor;
        return this;
    }

    public FractalGeneratorBuilder withTranslation(IComplex translationFactor) {
        this.translation = translationFactor;
        return this;
    }

    public FractalGeneratorBuilder centeredAt(IComplex center) {
        this.center = center;
        return this;
    }

    public FractalGeneratorBuilder withMaxIterations(int maxIterations) {
        this.maxIterations = maxIterations;
        return this;
    }

    public FractalGeneratorBuilder usingSequence(EnumSequence sequence) {
        if (sequence != null) {
            this.function = sequence::create;
        }
        return this;
    }

    public FractalGeneratorBuilder usingSequence(BiFunction<IComplex, Integer, IComplexSequence> function) {
        this.function = function;
        return this;
    }

    public FractalGeneratorBuilder usingPalette(EnumPalette paletteEnum) {
        this.paletteEnum = paletteEnum;
        this.palette = null;
        return this;
    }

    public FractalGeneratorBuilder usingPalette(IColor palette) {
        this.palette = palette;
        this.paletteEnum = null;
        return this;
    }

    public FractalGeneratorBuilder outputToFile(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public FractalGenerator build() {
        if (function == null) {
            throw new IllegalStateException("Une séquence doit être définie avant de construire le générateur");
        }
        if (palette == null && paletteEnum != null) {
            palette = paletteEnum.create(maxIterations);
        }
        return new FractalGenerator(this);
    }

    public IFractalGenerator buildZoomAnimation(int nbFrames, double zoomFactorStep) {
        List<IFractalGenerator> generators = new ArrayList<>();
        double currentZoom = this.zoomFactor;

        for (int i = 0; i < nbFrames; i++) {
            IFractalGenerator generator = new FractalGeneratorBuilder()
                    .withSize(this.width, this.height)
                    .withZoom(currentZoom)
                    .centeredAt(this.center)
                    .withMaxIterations(this.maxIterations)
                    .usingSequence(this.function)
                    .usingPalette(this.palette)
                    .build();

            generators.add(generator);
            currentZoom *= zoomFactorStep;
        }

        return new FractalImageComposite(generators, this.fileName);
    }

    public IFractalGenerator buildJuliaRotationAnimation(IComplex initialC, int nbFrames) {
        List<IFractalGenerator> generators = new ArrayList<>();
        List<BufferedImage> frames = new ArrayList<>();
        double angleStep = (2.0 * Math.PI) / nbFrames;

        for (int i = 0; i < nbFrames; i++) {
            double theta = i * angleStep;
            IComplex rotation = new Complex(Math.cos(theta), Math.sin(theta));
            IComplex rotatedC = initialC.multiply(rotation);

            IFractalGenerator generator = new FractalGeneratorBuilder()
                    .withSize(this.width, this.height)
                    .withZoom(this.zoomFactor)
                    .centeredAt(this.center)
                    .withMaxIterations(this.maxIterations)
                    .usingSequence((z0, max) -> new JuliaSequence(rotatedC, z0, max))
                    .usingPalette(this.palette)
                    .build();

            generators.add(generator);
        }

        return new FractalImageComposite(generators, this.fileName);
    }

    public IFractalImage getImage() {
        return new FractalImage(new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB));
    }

    public IComplexPlane getPlane() {
        IComplexPlane plane = new ComplexPlane(width, height);
        if (zoomFactor != 0.0 && zoomFactor != 1.0) {
            plane = new ZoomComplexPlane(plane, zoomFactor);
        }
        if (translation != null) {
            plane = new TranslateComplexPlane(plane, translation);
        } else if (center != null) {
            plane = new TranslateComplexPlane(plane, center);
        }
        return plane;
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public double getZoomFactor() { return zoomFactor; }
    public IComplex getCenter() { return center; }
    public int getMaxIterations() { return maxIterations; }
    public String getFileName() { return fileName; }
    public BiFunction<IComplex, Integer, IComplexSequence> getFunction() { return function; }
    public IColor getPalette() { return palette; }
}
