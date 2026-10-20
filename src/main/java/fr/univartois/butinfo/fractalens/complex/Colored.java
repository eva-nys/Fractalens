package fr.univartois.butinfo.fractalens.complex;

import  java.awt.Color;

public class Colored implements IColor {



    public Color coloredDot(int iteration, int max){
        float r = iteration / (float)max;
        float rgb = 1 - r;
        return new Color(rgb, rgb, rgb);
    }




}
