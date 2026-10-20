package fr.univartois.butinfo.fractalens;

import fr.univartois.butinfo.fractalens.complex.*;
import fr.univartois.butinfo.fractalens.complex.sequence.JuliaSequence;
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
        IComplex center = new Complex(-0.47, -0.211);
        plane = new TranslateComplexPlane(plane, center);
        IComplex c = new Complex(0.285, 0.01);
        IColor fixedPalette = new ColoredFixe(ColorPalette.OCEAN);
        IColor palette = new ColoredRVB(fixedPalette, 0.0, 1.0, 1.0);
        FractalGenerator generator = new FractalGenerator(image, plane, (z0, max) -> new JuliaSequence(c, z0, max), maxIterations, nbIter -> palette.coloredDot(nbIter, maxIterations), outputPath);
        generator.generateImage();
    }

    public static void main(String[] args) {
        juliaSprint2();
        juliaSprint3Image1();
        juliaSprint3Image2();
    }
}