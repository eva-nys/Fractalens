package fr.univartois.butinfo.fractalens.complex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import java.awt.Color;

/**
 * The {@code ColoredTest} class tests the implementation of {@link Colored}.
 *
 * @author Eva Nys
 * @version 0.1.0
 */
class ColoredTest {

    /**
     * Tests the color generation at zero iterations.
     */
    @Test
    void testColoredDot() {
        Colored colored = new Colored();
        Color color = colored.coloredDot(0, 100);
        assertEquals(255, color.getRed());
    }
}