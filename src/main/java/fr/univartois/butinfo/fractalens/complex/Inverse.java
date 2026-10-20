package fr.univartois.butinfo.fractalens.complex;

import java.awt.*;

public class Inverse {

    public Color inversePalette(Color palette){
            int r = palette.getRed();
            int g = palette.getGreen();
            int b = palette.getBlue();

            int complementaryR = 255 - r;
            int complementaryG = 255 - g;
            int complementaryB = 255 - b;

            return new Color(complementaryR, complementaryG, complementaryB);

    }



}
