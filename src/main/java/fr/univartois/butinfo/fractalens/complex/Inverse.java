package fr.univartois.butinfo.fractalens.complex;

import java.awt.*;

public class Inverse implements IColor {
    private final IColor decor;

    public Inverse(IColor decor) {
        this.decor = decor;
    }




    @Override
    public Color coloredDot(int iteration, int max) {
        Color palette = decor.coloredDot(iteration, max);
        int r = palette.getRed();
        int g = palette.getGreen();
        int b = palette.getBlue();

        int complementaryR = 255 - r;
        int complementaryG = 255 - g;
        int complementaryB = 255 - b;
        return new Color(complementaryR, complementaryG, complementaryB);
    }
}
