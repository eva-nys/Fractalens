package fr.univartois.butinfo.fractalens.complex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.awt.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the {@link Inverse} class including edge cases.
 *
 * @author Eva Nys
 * @version 1.0
 */
class InverseTest {

    private Inverse inverse;

    @BeforeEach
    void initPalette() {
        inverse = new Inverse();
    }

    @Test
    void testStandardInversion() {
        Color baseColor = new Color(100, 150, 200);
        Color result = inverse.inversePalette(baseColor);

        assertEquals(255 - 100, result.getRed());
        assertEquals(255 - 150, result.getGreen());
        assertEquals(255 - 200, result.getBlue());

        assertNotEquals(baseColor, result);
    }

    @Test
    void testBlackInversionToWhite() {
        Color result = inverse.inversePalette(Color.BLACK);

        assertEquals(255, result.getRed());
        assertEquals(255, result.getGreen());
        assertEquals(255, result.getBlue());
        assertNotEquals(Color.BLACK, result);
    }

    @Test
    void testWhiteInversionToBlack() {
        Color result = inverse.inversePalette(Color.WHITE);

        assertEquals(0, result.getRed());
        assertEquals(0, result.getGreen());
        assertEquals(0, result.getBlue());
        assertNotEquals(Color.WHITE, result);
    }
}