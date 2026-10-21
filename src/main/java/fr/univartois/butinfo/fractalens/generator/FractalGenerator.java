package fr.univartois.butinfo.fractalens.generator;

import fr.univartois.butinfo.fractalens.complex.IColor;
import fr.univartois.butinfo.fractalens.complex.IComplex;
import java.util.function.BinaryOperator;

public class FractalGenerator {

    private final int width;
    private final int height;
    private final double zoomFactor;
    private final IComplex center;
    private final int maxIterations;
    private final String fileName;
    private final BinaryOperator<IComplex> function;
    private final IColor palette;

    public FractalGenerator(FractalGeneratorBuilder builder) {
        this.width = builder.getWidth();
        this.height = builder.getHeight();
        this.zoomFactor = builder.getZoomFactor();
        this.center = builder.getCenter();
        this.maxIterations = builder.getMaxIterations();
        this.fileName = builder.getFileName();
        this.function = builder.getFunction();
        this.palette = builder.getPalette();
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public double getZoomFactor() { return zoomFactor; }
    public IComplex getCenter() { return center; }
    public int getMaxIterations() { return maxIterations; }
    public String getFileName() { return fileName; }
    public BinaryOperator<IComplex> getFunction() { return function; }
    public IColor getPalette() { return palette; }
}