package fr.univartois.butinfo.fractalens.complex;

import java.awt.Color;
import java.util.List;

public class ColoredFixe implements IColor {

    private final List<Color> colors;

    public ColoredFixe(ColorPalette palette) {
        this.colors = palette.getColors();
    }

    public ColoredFixe(List<Color> colors) {
        this.colors = colors;
    }

    @Override
    public Color coloredDot(int iteration, int max) {
        int index = (int) ((double) iteration / max * colors.size());// Conversion en double pour éviter la division entière
        index = Math.min(index, colors.size() - 1);
        return colors.get(index);
    }
}
