package fr.univartois.butinfo.fractalens.image;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class FractalImage implements IFractalImage{

    private BufferedImage img;

    public FractalImage(BufferedImage img){
        this.img=img;
    }

    @Override
    public int getHeight() {

        return 0;
    }

    @Override
    public int getWidth() {

        return 0;
    }

    @Override
    public void setColor(int row, int column, Color color) {

    }

    @Override
    public void saveAs(String path) throws IOException {

    }

}
