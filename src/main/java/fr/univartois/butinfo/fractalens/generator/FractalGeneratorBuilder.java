package fr.univartois.butinfo.fractalens.generator;

import fr.univartois.butinfo.fractalens.complex.ColorPalette;
import fr.univartois.butinfo.fractalens.complex.IColor;
import fr.univartois.butinfo.fractalens.complex.IComplex;

import java.util.function.BinaryOperator;

public class FractalGeneratorBuilder {

    private int width;
    private int height;
    private double zoomFactor;
    private IComplex center;
    private int maxIterations;
    private String fileName;
    private BinaryOperator<IComplex> Function;
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

    public FractalGeneratorBuilder centeredAt(IComplex center) {
        this.center = center;
        return this;
    }

    public FractalGeneratorBuilder withMaxIterations(int maxIterations) {
        this.maxIterations = maxIterations;
        return this;
    }

    public FractalGeneratorBuilder usingSequence(EnumSequence sequence) {
        return this;
    }

    public FractalGeneratorBuilder usingSequence(BinaryOperator<IComplex> function) {
        this.Function = function;
        return this;
    }

    public FractalGeneratorBuilder usingPalette(ColorPalette paletteEnum) {
        return this;
    }

    public FractalGeneratorBuilder usingPalette(IColor palette) {
        this.palette = palette;
        return this;
    }

    public FractalGeneratorBuilder outputToFile(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public FractalGenerator build() {
        return new FractalGenerator(this);
    }
}