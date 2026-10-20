package fr.univartois.butinfo.fractalens;

import fr.univartois.butinfo.fractalens.complex.*;
import fr.univartois.butinfo.fractalens.complex.sequence.JuliaSequence;
import fr.univartois.butinfo.fractalens.generator.FractalGenerator;
import fr.univartois.butinfo.fractalens.image.FractalImage;

import java.awt.image.BufferedImage;

public class Main {

    public static void juliaSprint2(){
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

    public static void main(String[] args) {
        juliaSprint2();
    }
}
