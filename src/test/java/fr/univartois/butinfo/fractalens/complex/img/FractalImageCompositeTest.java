package fr.univartois.butinfo.fractalens.image;

import fr.univartois.butinfo.fractalens.complex.Complex;
import fr.univartois.butinfo.fractalens.complex.sequence.EnumSequence;
import fr.univartois.butinfo.fractalens.generator.FractalGeneratorBuilder;
import fr.univartois.butinfo.fractalens.generator.IFractalGenerator;
import fr.univartois.butinfo.fractalens.image.color.EnumPalette;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FractalImageCompositeTest {

    private FractalImageComposite composite;
    private final String testGifPath = "test_animation.gif";
    private List<BufferedImage> frames;

    @BeforeEach
    void setUp() {
        List<IFractalGenerator> generators = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            IFractalGenerator frameGenerator = new FractalGeneratorBuilder()
                    .withSize(10, 10)
                    .withMaxIterations(10)
                    .withZoom(0.01 + (i * 0.005))
                    .centeredAt(new Complex(0, 0))
                    .usingSequence(EnumSequence.MANDELBROT)
                    .usingPalette(EnumPalette.FIRE)
                    .outputToFile("temp_frame_" + i + ".png")
                    .build();

            generators.add(frameGenerator);
        }

        frames = new ArrayList<>();
        composite = new FractalImageComposite(generators, testGifPath, frames);
    }

    @AfterEach
    void tearDown() {
        File gifFile = new File(testGifPath);
        if (gifFile.exists()) {
            gifFile.delete();
        }

        for (int i = 0; i < 2; i++) {
            File tempPng = new File("temp_frame_" + i + ".png");
            if (tempPng.exists()) {
                tempPng.delete();
            }
        }
    }

    @Test
    void testGenerateImageCreatesGifFile() {

        composite.generateImage();

        File file = new File(testGifPath);
        assertTrue(file.exists());
        assertEquals(2, frames.size());
    }

    @Test
    void testComputePixelColorReturnsNull() {
        assertNull(composite.computePixelColor(0, 0));
    }
}
