package fr.univartois.butinfo.fractalens.complex;

import fr.univartois.butinfo.fractalens.image.color.ColoredGrey;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * test class for gradient
 */
public class ColoredGradientTest {

    @Test
    void testColoredDot() {
        ColoredGrey coloredGrey = new ColoredGrey();
        Color color = coloredGrey.coloredDot(0, 100);
        assertEquals(255, color.getRed());
    }
}
