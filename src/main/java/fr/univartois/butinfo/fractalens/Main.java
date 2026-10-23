package fr.univartois.butinfo.fractalens;

import java.util.concurrent.Callable;

import fr.univartois.butinfo.fractalens.complex.Complex;
import fr.univartois.butinfo.fractalens.complex.IComplex;
import fr.univartois.butinfo.fractalens.complex.sequence.EnumSequence;
import fr.univartois.butinfo.fractalens.generator.FractalGeneratorBuilder;
import fr.univartois.butinfo.fractalens.generator.IFractalGenerator;
import fr.univartois.butinfo.fractalens.image.color.EnumPalette;
import fr.univartois.butinfo.fractalens.image.color.IColor;
import picocli.CommandLine;

/**
 * The Interface class is the command-line entry point of FractaLens.
 * It reads the options given by the user and configures a
 * {@link FractalGeneratorBuilder} accordingly.
 */
@CommandLine.Command(
        name = "fractale",
        description = "Generate a fractal",
        mixinStandardHelpOptions = true,
        version = "1.0.0"
)
public class Main implements Callable<Integer> {

    /**
     * The kinds of animation that can be generated.
     */
    public enum Animation {

        /** No animation: a static image is generated. */
        NONE,

        /** A zoom on the center of the fractal. */
        ZOOM,

        /** A rotation of the constant of a Julia sequence. */
        ROTATION
    }

    @CommandLine.Option(
            names = {"-W", "--width"},
            description = "width of the fractal (default = ${DEFAULT-VALUE})"
    )
    private int width = 400;

    @CommandLine.Option(
            names = {"-H", "--height"},
            description = "height of the fractal (default = ${DEFAULT-VALUE})"
    )
    private int height = 400;

    @CommandLine.Option(
            names = {"-Z", "--zoom"},
            description = "zoom of the fractal: size of one pixel in the complex plane "
                    + "(default = ${DEFAULT-VALUE})"
    )
    private double zoomFactor = 0.005;

    @CommandLine.Option(
            names = {"-P", "--palette"},
            description = "colour palette of the fractal (default = ${DEFAULT-VALUE}, "
                    + "values = ${COMPLETION-CANDIDATES})"
    )
    private EnumPalette palette = EnumPalette.GRAYSCALE;

    @CommandLine.Option(
            names = {"-S", "--sequence"},
            description = "sequence used to build the fractal (default = ${DEFAULT-VALUE}, "
                    + "values = ${COMPLETION-CANDIDATES}); ignored for the rotation animation"
    )
    private EnumSequence sequence = EnumSequence.MANDELBROT;

    @CommandLine.Option(
            names = {"-M", "--maxIterations"},
            description = "the maximum of iterations (default = ${DEFAULT-VALUE})"
    )
    private int maxIterations = 100;

    @CommandLine.Option(
            names = {"-N", "--name"},
            description = "the name of the output file (default = ${DEFAULT-VALUE}); "
                    + "use a .gif extension for animations"
    )
    private String outputPath = "fractal.png";

    @CommandLine.Option(
            names = {"-A", "--animated"},
            description = "the kind of animation (default = ${DEFAULT-VALUE}, "
                    + "values = ${COMPLETION-CANDIDATES})"
    )
    private Animation animation = Animation.NONE;

    @CommandLine.Option(
            names = {"-F", "--frames"},
            description = "the number of frames of the animation (default = ${DEFAULT-VALUE})"
    )
    private int frames = 40;

    @CommandLine.Option(
            names = {"--zoom-step"},
            description = "the factor applied to the zoom between two frames "
                    + "of a zoom animation (default = ${DEFAULT-VALUE})"
    )
    private double zoomStep = 0.80;

    @CommandLine.Option(
            names = {"--center-real"},
            description = "real part of the center of the fractal (default = ${DEFAULT-VALUE})"
    )
    private double centerReal = 0.0;

    @CommandLine.Option(
            names = {"--center-imaginary"},
            description = "imaginary part of the center of the fractal (default = ${DEFAULT-VALUE})"
    )
    private double centerImaginary = 0.0;

    /**
     * Launches the command-line interface.
     *
     * @param args The arguments given on the command line.
     */
    public static void main(String[] args) {
        int exitCode = new CommandLine(new Main())
                .setCaseInsensitiveEnumValuesAllowed(true)
                .execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() {
        if (!areOptionsValid()) {
            return 2;
        }

        System.out.println("Generating the fractal...");
        System.out.println(" -- width : " + width);
        System.out.println(" -- height : " + height);
        System.out.println(" -- zoom : " + zoomFactor);
        System.out.println(" -- palette : " + palette);
        System.out.println(" -- sequence : " + sequence);
        System.out.println(" -- maxIterations : " + maxIterations);
        System.out.println(" -- animation : " + animation);

        IColor colors = palette.create(maxIterations);
        IComplex center = new Complex(centerReal, centerImaginary);

        FractalGeneratorBuilder builder = new FractalGeneratorBuilder()
                .withSize(width, height)
                .withZoom(zoomFactor)
                .centeredAt(center)
                .withMaxIterations(maxIterations)
                .usingSequence(sequence)
                .usingPalette(colors)
                .outputToFile(outputPath);

        switch (animation) {
            case ZOOM -> {
                // Saving the GIF is done by the composite generator itself.
                builder.buildZoomAnimation(frames, zoomStep).generateImage();
            }
            case ROTATION -> {
                IComplex initialC = new Complex(-0.8, 0.156);
                builder.buildJuliaRotationAnimation(initialC, frames).generateImage();
            }
            case NONE -> {
                IFractalGenerator generator = builder.build();
                generator.generateImage();
                generator.saveImage();
            }
        }

        System.out.println("fractal successfully generated in " + outputPath);
        return 0;
    }

    /**
     * Checks that the values given by the user can be used to generate a fractal.
     *
     * @return Whether all the options are valid.
     */
    private boolean areOptionsValid() {
        if (width <= 0 || height <= 0) {
            System.err.println("The width and the height must be strictly positive.");
            return false;
        }
        if (maxIterations <= 0) {
            System.err.println("The maximum number of iterations must be strictly positive.");
            return false;
        }
        if (zoomFactor <= 0) {
            System.err.println("The zoom must be strictly positive.");
            return false;
        }
        if (animation != Animation.NONE) {
            if (frames <= 0) {
                System.err.println("The number of frames must be strictly positive.");
                return false;
            }
            if (!outputPath.toLowerCase().endsWith(".gif")) {
                System.err.println("An animation must be saved in a .gif file.");
                return false;
            }
        }
        return true;
    }
}