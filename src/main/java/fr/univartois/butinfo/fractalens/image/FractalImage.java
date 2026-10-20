package fr.univartois.butinfo.fractalens.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FractalImage implements IFractalImage{

    private BufferedImage img;

    public FractalImage(BufferedImage img){
        this.img=img;
    }

    @Override
    public int getHeight() {

        return img.getHeight();
    }

    @Override
    public int getWidth() {

        return img.getWidth();
    }

    @Override
    public void setColor(int row, int column, Color color) {
        int rgb = color.getRGB();
        img.setRGB(column, row, rgb);
    }

    @Override
    public void saveAs(String path) throws IOException {
        File savePath = new java.io.File(path);
        ImageIO.write(img, "png", savePath);

    }

}
