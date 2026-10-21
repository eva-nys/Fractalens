package fr.univartois.butinfo.fractalens;

import fr.univartois.butinfo.fractalens.complex.*;
import fr.univartois.butinfo.fractalens.complex.sequence.BurningShipSequence;
import fr.univartois.butinfo.fractalens.complex.sequence.GeneralComplexSequence;
import fr.univartois.butinfo.fractalens.complex.sequence.JuliaSequence;
import fr.univartois.butinfo.fractalens.complex.sequence.Mandelbrot;
import fr.univartois.butinfo.fractalens.generator.FractalGenerator;
import fr.univartois.butinfo.fractalens.image.FractalImage;

import java.awt.image.BufferedImage;

public class Main {

    public static void juliaSprint2() {
        int width = 800;
        int height = 600;
        int maxIterations = 100;
        double zoomFactor = 0.004;
        String outputPath = "julia_fractal.png";

        BufferedImage bufferedImage = new BufferedImage(width, height, 1);
        FractalImage image = new FractalImage(bufferedImage);
        ComplexPlane basePlane = new ComplexPlane(width, height);
        ZoomComplexPlane zoomedPlane = new ZoomComplexPlane(basePlane, zoomFactor);
        IComplex c = new Complex(-0.4, 0.6);
        Colored colored = new Colored();
        FractalGenerator generator = new FractalGenerator(image, zoomedPlane, (z0, max) -> new JuliaSequence(c, z0, max), maxIterations, nbIter -> colored.coloredDot(nbIter, maxIterations), outputPath);
        generator.generateImage();
    }

    public static void juliaSprint3Image1() {
        int width = 800;
        int height = 800;
        int maxIterations = 250;
        double zoomFactor = 0.001;
        String outputPath = "julia_sprint3_1.png";
        BufferedImage bufferedImage = new BufferedImage(width, height, 1);
        FractalImage image = new FractalImage(bufferedImage);
        IComplexPlane plane = new ComplexPlane(width, height);
        plane = new ZoomComplexPlane(plane, zoomFactor);
        IComplex center = new Complex(0.1, 0.6);
        plane = new TranslateComplexPlane(plane, center);
        IComplex c = new Complex(-0.4, 0.6);
        IColor palette = new ColoredFixe(ColorPalette.FIRE);
        FractalGenerator generator = new FractalGenerator(image, plane, (z0, max) -> new JuliaSequence(c, z0, max), maxIterations, nbIter -> palette.coloredDot(nbIter, maxIterations), outputPath);
        generator.generateImage();
    }

    public static void juliaSprint3Image2() {
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
        FractalGenerator generator = new FractalGenerator(image, plane, (z0, max) -> new JuliaSequence(c, z0, max), maxIterations, nbIter -> palette.coloredDot(nbIter, maxIterations), outputPath);
        generator.generateImage();
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
        FractalGenerator generator = new FractalGenerator(image, plane, (z0, max) -> new Mandelbrot(z0, z0, max), maxIterations, nbIter -> palette.coloredDot(nbIter, maxIterations), outputPath);
        generator.generateImage();
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
        FractalGenerator generator = new FractalGenerator(image, plane, (pixel, max) -> new BurningShipSequence(pixel, new Complex(0, 0), max), maxIterations, nbIter -> palette.coloredDot(nbIter, maxIterations), outputPath);
        generator.generateImage();
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
        FractalGenerator generator = new FractalGenerator(image, plane, (z0, max) -> new GeneralComplexSequence((zn, initial) -> zn.multiply(zn).add(c), z0, max), maxIterations, nbIter -> palette.coloredDot(nbIter, maxIterations), outputPath);
        generator.generateImage();
    }
    public static void main(String[] args) {
        sprint4Image3();
        burningShipSprint3Image();
        mandelbrotSprint3Image();
    }
}
