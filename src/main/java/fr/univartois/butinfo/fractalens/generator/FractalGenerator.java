package fr.univartois.butinfo.fractalens.generator;

import fr.univartois.butinfo.fractalens.complex.IColor;
import fr.univartois.butinfo.fractalens.complex.IComplex;
import fr.univartois.butinfo.fractalens.complex.IComplexPlane;
import fr.univartois.butinfo.fractalens.image.IFractalImage;

import java.awt.Color;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.IntFunction;

public class FractalGenerator implements IFractalGenerator {

    private int width;
    private int height;
    private double zoomFactor;
    private IComplex center;
    private int maxIterations;
    private String fileName;
    private BinaryOperator<IComplex> function;
    private IColor palette;

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

    public FractalGenerator(IFractalImage image, IComplexPlane plane, BiFunction<IComplex, Integer, ?> sequenceFactory, int maxIterations, IntFunction<Color> colorMapper) {
        this(image, plane, sequenceFactory, maxIterations, colorMapper, null);
    }

    public FractalGenerator(IFractalImage image, IComplexPlane plane, BiFunction<IComplex, Integer, ?> sequenceFactory, int maxIterations, IntFunction<Color> colorMapper, String fileName) {
        this.maxIterations = maxIterations;
        this.fileName = fileName;
    }

    @Override
    public IFractalImage generateImage() {
        return null;
    }

    @Override
    public Color computePixelColor(int row, int column) {
        return null;
    }

    @Override
    public void saveImage() {

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