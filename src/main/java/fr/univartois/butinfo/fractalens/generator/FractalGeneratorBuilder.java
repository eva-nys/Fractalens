package fr.univartois.butinfo.fractalens.generator;

import fr.univartois.butinfo.fractalens.complex.*;
import fr.univartois.butinfo.fractalens.complex.plane.ComplexPlane;
import fr.univartois.butinfo.fractalens.complex.plane.IComplexPlane;
import fr.univartois.butinfo.fractalens.complex.plane.TranslateComplexPlane;
import fr.univartois.butinfo.fractalens.complex.plane.ZoomComplexPlane;
import fr.univartois.butinfo.fractalens.complex.sequence.EnumSequence;
import fr.univartois.butinfo.fractalens.complex.sequence.IComplexSequence;
import fr.univartois.butinfo.fractalens.image.FractalImage;
import fr.univartois.butinfo.fractalens.image.IFractalImage;
import fr.univartois.butinfo.fractalens.image.color.EnumPalette;
import fr.univartois.butinfo.fractalens.image.color.IColor;

import java.awt.image.BufferedImage;
import java.util.function.BiFunction;

public class FractalGeneratorBuilder {
    private IFractalImage image;
    private int width;
    private int height;
    private IComplexPlane plane;
    private double zoomFactor;
    private IComplex center;
    private int maxIterations;
    private String fileName;
    private BiFunction<IComplex, Integer, IComplexSequence> function;
    private IColor palette;

    public FractalGeneratorBuilder withSize(int width, int height) {
        this.width = width;
        this.height = height;
        this.plane = new ComplexPlane(width, height);
        this.image = new FractalImage(new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB));
        return this;
    }

    public FractalGeneratorBuilder withZoom(double zoomFactor) {
        this.zoomFactor = zoomFactor;
        this.plane = new ZoomComplexPlane(plane, zoomFactor);
        return this;
    }

    public FractalGeneratorBuilder withTranslation(IComplex translationFactor){
        this.plane=new TranslateComplexPlane(plane,translationFactor);
        return this;
    }

    public FractalGeneratorBuilder centeredAt(IComplex center) {
        this.center = center;
        this.plane = new TranslateComplexPlane(plane, center);
        return this;
    }

    public FractalGeneratorBuilder withMaxIterations(int maxIterations) {
        this.maxIterations = maxIterations;
        return this;
    }

    public FractalGeneratorBuilder usingSequence(EnumSequence sequence) {
        this.function=sequence::create;
        return this;
    }

    public FractalGeneratorBuilder usingSequence(BiFunction<IComplex, Integer, IComplexSequence> function) {
        this.function = function;
        return this;
    }

    public FractalGeneratorBuilder usingPalette(EnumPalette paletteEnum) {
        this.palette=paletteEnum.create(maxIterations);
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

    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public double getZoomFactor() { return zoomFactor; }
    public IComplex getCenter() { return center; }
    public int getMaxIterations() { return maxIterations; }
    public String getFileName() { return fileName; }
    public BiFunction<IComplex, Integer, IComplexSequence> getFunction() { return function; }
    public IColor getPalette() { return palette; }

    public IComplexPlane getPlane() {

        return plane;
    }

    public IFractalImage getImage() {

        return image;
    }

}
