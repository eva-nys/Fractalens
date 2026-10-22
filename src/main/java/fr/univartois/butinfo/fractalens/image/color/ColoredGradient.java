package fr.univartois.butinfo.fractalens.image.color;

import java.awt.*;

public class ColoredGradient implements IColor {

    // first color of gradiant
    private final Color firstColor;

    // second color of gradiant
    private final Color secondColor;

    /**
     * builder of the Gradient class
     * @param firstColor initialization of the first color
     * @param secondColor initialization of the second color
     */
    public ColoredGradient(Color firstColor, Color secondColor) {
        this.firstColor = firstColor;
        this.secondColor = secondColor;
    }

    @Override
    public Color coloredDot(int iteration, int max) {

        float ratio = iteration / (float)max;
        float red = firstColor.getRed() + ratio * (secondColor.getRed() - firstColor.getRed());
        float green = firstColor.getGreen() + ratio * (secondColor.getGreen() - firstColor.getGreen());
        float blue = firstColor.getBlue() + ratio * (secondColor.getBlue() - firstColor.getBlue());
        return new Color((int) red, (int) green, (int) blue);
    }

}
