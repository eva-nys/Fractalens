package fr.univartois.butinfo.fractalens.complex;

import java.awt.*;
import java.awt.Color;
import java.util.List;

public class ColoredFixe implements IColor{
    private final List<Color> colors;

    public ColoredFixe(ColorPalette palette) {
        this.colors = palette.getColors();
    }

    public ColoredFixe(List<Color> colors) {
        this.colors = colors;
    }
    @Override
    public Color coloredDot(int iteration, int max) {

        if (iteration >= max) {
            return Color.BLACK; // Couleur pour les points qui convergent
        }
        int index =  iteration / max * colors.size();
        index = Math.min(index, colors.size() - 1);
        return colors.get(index);
    }

}
