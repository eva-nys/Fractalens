package fr.univartois.butinfo.fractalens.complex;

import  java.awt.Color;

public class Colored implements IColor {



    public Color coloredDot(int iteration, int max){
        if(max > iteration){
            return Color.BLACK;
        }
        float r = iteration / max;
        float rgb = 1 - r;
        return new Color((int)rgb);
    }




}
