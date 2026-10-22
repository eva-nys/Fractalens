package fr.univartois.butinfo.fractalens;

import fr.univartois.butinfo.fractalens.complex.*;
import fr.univartois.butinfo.fractalens.complex.sequence.JuliaSequence;
import fr.univartois.butinfo.fractalens.generator.FractalGenerator;
import fr.univartois.butinfo.fractalens.generator.FractalGeneratorBuilder;
import fr.univartois.butinfo.fractalens.image.color.ColorPalette;
import fr.univartois.butinfo.fractalens.image.color.ColoredGrey;
import fr.univartois.butinfo.fractalens.image.color.ColoredFixe;
import fr.univartois.butinfo.fractalens.image.color.IColor;

public class Main {

    public static void juliaSprint2() {
        int width = 800;
        int height = 600;
        int maxIterations = 100;
        double zoomFactor = 0.004;
        String outputPath = "julia_fractal.png";


        IComplex c = new Complex(-0.4, 0.6);
        FractalGenerator generator = new FractalGeneratorBuilder()
                .withSize(width, height)
                .withZoom(zoomFactor)
                .usingPalette(new ColoredGrey())
                .usingSequence((z0, max) -> new JuliaSequence(c, z0, max))
                .withMaxIterations(maxIterations)
                .outputToFile(outputPath)
                .build();
        generator.generateImage();
        generator.saveImage();
    }

    public static void juliaSprint3Image1() {
        int width = 800;
        int height = 800;
        int maxIterations = 250;
        double zoomFactor = 0.001;
        String outputPath = "julia_sprint3_1.png";
        IComplex c = new Complex(-0.4, 0.6);
        IColor palette = new ColoredFixe(ColorPalette.FIRE);
        FractalGenerator generator=new FractalGeneratorBuilder()
                .withSize(width,height)
                .withZoom(zoomFactor)
                .withTranslation(new Complex(0.1, 0.6))
                .usingPalette(palette)
                .usingSequence((z0, max) -> new JuliaSequence(c, z0, max))
                .withMaxIterations(maxIterations)
                .outputToFile(outputPath)
                .build();
        generator.generateImage();
        generator.saveImage();

    }

    /**public static void juliaSprint3Image2() {
        int width = 800;
        int height = 800;
        int maxIterations = 250;
        double zoomFactor = 0.001;
        String outputPath = "julia_sprint3_2.png";
        BufferedImage bufferedImage = new BufferedImage(width, height, 1);
        FractalImage image = new FractalImage(bufferedImage);
        IComplexPlane plane = new ComplexPlane(width, height);
        plane = new ZoomComplexPlane(plane, zoomFactor);
        IComplex center = new Complex(-0.47, -0.21);
        plane = new TranslateComplexPlane(plane, center);
        IComplex c = new Complex(0.285, 0.01);
        IColor fixedPalette = new ColoredFixe(ColorPalette.JULIA_SPRINT3);
        IColor palette = new ColoredRVB(fixedPalette, 0.0, 1.0, 1.0);
//        FractalGenerator generator = new FractalGenerator(image, plane, (z0, max) -> new JuliaSequence(c, z0, max), maxIterations, nbIter -> palette.coloredDot(nbIter, maxIterations), outputPath);
//        generator.generateImage();
    }
    public static void mandelbrotSprint3Image() {
        int width = 800;
        int height = 600;
        int maxIterations = 250;
        double zoomFactor = 0.003;
        String outputPath = "mandelbrot_sprint3.png";
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        FractalImage image = new FractalImage(bufferedImage);
        IComplexPlane plane = new ComplexPlane(width, height);
        plane = new ZoomComplexPlane(plane, zoomFactor);
        IComplex center = new Complex(-0.75, 0.0);
        plane = new TranslateComplexPlane(plane, center);
        IColor palette = new ColoredFixe(ColorPalette.FIRE);
//        FractalGenerator generator = new FractalGenerator(image, plane, (z0, max) -> new Mandelbrot(z0, z0, max,2), maxIterations, nbIter -> palette.coloredDot(nbIter, maxIterations), outputPath);
//        generator.generateImage();
    }

    public static void burningShipSprint3Image() {
        int width = 800;
        int height = 800;
        int maxIterations = 64;


        double zoomFactor = 0.00015;
        String outputPath = "burningship_sprint3.png";

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        FractalImage image = new FractalImage(bufferedImage);
        IComplexPlane plane = new ComplexPlane(width, height);
        plane = new ZoomComplexPlane(plane, zoomFactor);
        IComplex center = new Complex(-1.755, -0.03);
        plane = new TranslateComplexPlane(plane, center);
        IColor palette = new ColoredFixe(ColorPalette.FIRE);
//        FractalGenerator generator = new FractalGenerator(image, plane, (pixel, max) -> new BurningShipSequence(pixel, new Complex(0, 0), max), maxIterations, nbIter -> palette.coloredDot(nbIter, maxIterations), outputPath);
//        generator.generateImage();
    }
    public static void sprint4Image3(){
        int width = 800;
        int height = 800;
        int maxIterations = 300;
        double zoomFactor = 0.004;
        String outputPath = "fractal_lambda.png";
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        FractalImage image = new FractalImage(bufferedImage);
        IComplexPlane plane = new ComplexPlane(width, height);
        plane = new ZoomComplexPlane(plane, zoomFactor);
        IComplex c = new Complex(-0.8, 0.156);
        IColor palette = new ColoredFixe(ColorPalette.GALAXY);
//        FractalGenerator generator = new FractalGenerator(image, plane, (z0, max) -> new GeneralComplexSequence((zn, initial) -> zn.multiply(zn).add(c), z0, max), maxIterations, nbIter -> palette.coloredDot(nbIter, maxIterations), outputPath);
//        generator.generateImage();
    }
     */

    /**
     * Teste l'animation de zoom sur la fractale de Mandelbrot (Vallée des Hippocampes).
     */
    public static void testMandelbrotZoomAnimation() {

        int width = 400;
        int height = 400;
        int maxIterations = 250;
        double startZoom = 0.01;
        String outputPath = "mandelbrot_zoom_anim.gif";

        IColor palette = new ColoredFixe(ColorPalette.FIRE);

        IComplex coolCenter = new Complex(-0.743643887, 0.131825904);

        var animationGenerator = new FractalGeneratorBuilder()
                .withSize(width, height)
                .withZoom(startZoom)
                .centeredAt(coolCenter) // Utilisation du nouveau point de mire
                .withMaxIterations(maxIterations)
                .usingSequence(fr.univartois.butinfo.fractalens.complex.sequence.EnumSequence.MANDELBROT)
                .usingPalette(palette)
                .outputToFile(outputPath)
                .buildZoomAnimation(40, 0.80);

        animationGenerator.generateImage();
    }

    public static void testJuliaRotationAnimation() {

        int width = 400;
        int height = 400;
        int maxIterations = 150;
        double zoomFactor = 0.01;
        String outputPath = "julia_rotation_anim.gif";

        IComplex initialC = new Complex(-0.8, 0.156);

        IColor palette = new ColoredFixe(ColorPalette.CYBERPUNK);

        var animationGenerator = new FractalGeneratorBuilder()
                .withSize(width, height)
                .withZoom(zoomFactor)
                .centeredAt(new Complex(0, 0)) // Il faut toujours centrer Julia sur 0 pour bien la voir
                .withMaxIterations(maxIterations)
                .usingPalette(palette)
                .outputToFile(outputPath)
                .buildJuliaRotationAnimation(initialC, 60);

        animationGenerator.generateImage();
    }
    public static void main(String[] args) {
        //testMandelbrotZoomAnimation();
        testJuliaRotationAnimation();
    }
}
