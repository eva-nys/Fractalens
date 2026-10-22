package fr.univartois.butinfo.fractalens.image;
import java.awt.image.BufferedImage;
import java.util.List;
import com.madgag.gif.fmsware.AnimatedGifEncoder;
import fr.univartois.butinfo.fractalens.generator.IFractalGenerator;

import java.awt.*;

public class FractalImageComposite implements IFractalGenerator {
    private final List<IFractalGenerator> generators;
    private final String outputPath;
    private final List<BufferedImage> frames;

    public FractalImageComposite(List<IFractalGenerator> generators,
            String outputPath, List<BufferedImage> frames) {

        this.generators = generators;
        this.outputPath = outputPath;
        this.frames = frames;
    }

    @Override
    public IFractalImage generateImage() {

        for (IFractalGenerator generator : generators) {
            IFractalImage image = generator.generateImage();
            frames.add(image.asBufferedImage());
        }
        saveImage();
        return null;
    }

    @Override
    public Color computePixelColor(int row, int column) {

        return null;
    }

    @Override
    public void saveImage() {
        AnimatedGifEncoder encoder= new AnimatedGifEncoder();
        encoder.start(outputPath);
        encoder.setDelay(100);
        encoder.setRepeat(0);
        for(BufferedImage frame : frames){
            encoder.addFrame(frame);
        }
        encoder.finish();
    }

}
