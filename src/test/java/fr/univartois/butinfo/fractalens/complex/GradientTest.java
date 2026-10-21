package fr.univartois.butinfo.fractalens.complex;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * test class for gradient
 */
public class GradientTest {

    @Test
    void testColoredDot() {
        Colored colored = new Colored();
        Color color = colored.coloredDot(0, 100);
        assertEquals(255, color.getRed());
    }
}
