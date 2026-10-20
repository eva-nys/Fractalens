package fr.univartois.butinfo.fractalens.complex;

import java.awt.*;

public class ColoredRVB implements IColor {
    private final IColor decor;
    private final double redFactor;
    private final double greenFactor;
    private final double blueFactor;

    public ColoredRVB(IColor decor, double redFactor, double greenFactor,double blueFactor) {
        this.decor = decor;
        this.redFactor = redFactor;
        this.greenFactor = greenFactor;
        this.blueFactor = blueFactor;
    }

    @Override
    public Color coloredDot(int iteration, int max) {
        Color baseColor = decor.coloredDot(iteration, max);
        int r = (int) (baseColor.getRed() * redFactor);
        int v = (int) (baseColor.getGreen() * greenFactor);
        int b = (int) (baseColor.getBlue() * blueFactor);
        return new Color(r, v, b);
    }

}
