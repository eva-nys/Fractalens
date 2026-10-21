package fr.univartois.butinfo.fractalens.complex;

import java.awt.*;

public class Gradient {

    // first color of gradiant
    private final Color firstColor;

    // second color of gradiant
    private final Color secondColor;

    /**
     * builder of the Gradient class
     * @param firstColor initialization of the first color
     * @param secondColor initialization of the second color
     */
    public Gradient(Color firstColor, Color secondColor) {
        this.firstColor = firstColor;
        this.secondColor = secondColor;
    }

    public Color colorDot(int iteration, int max) {
        float ratio = iteration / (float)max;
        float red = firstColor.getRed() + ratio * (secondColor.getRed() - firstColor.getRed());
        float green = firstColor.getGreen() + ratio * (secondColor.getGreen() - firstColor.getGreen());
        float blue = firstColor.getBlue() + ratio * (secondColor.getBlue() - firstColor.getBlue());
        return new Color(red, green, blue);
    }


}
