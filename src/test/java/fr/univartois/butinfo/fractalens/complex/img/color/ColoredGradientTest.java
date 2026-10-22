package fr.univartois.butinfo.fractalens.complex.img.color;

import fr.univartois.butinfo.fractalens.image.color.ColoredGradient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ColoredGradientTest {

    private ColoredGradient gradient;
    private Color startColor;
    private Color endColor;

    @BeforeEach
    void setUp() {
        startColor = Color.BLACK;
        endColor = Color.WHITE;
        gradient = new ColoredGradient(startColor, endColor);
    }

    @Test
    void testColoredDotAtZeroIteration() {
        Color result = gradient.coloredDot(0, 100);

        assertEquals(startColor.getRed(), result.getRed());
        assertEquals(startColor.getGreen(), result.getGreen());
        assertEquals(startColor.getBlue(), result.getBlue());
    }

    @Test
    void testColoredDotAtMaxIteration() {
        Color result = gradient.coloredDot(100, 100);

        assertEquals(endColor.getRed(), result.getRed());
        assertEquals(endColor.getGreen(), result.getGreen());
        assertEquals(endColor.getBlue(), result.getBlue());
    }

    @Test
    void testColoredDotAtHalfIteration() {
        Color result = gradient.coloredDot(50, 100);

        assertEquals(127, result.getRed());
        assertEquals(127, result.getGreen());
        assertEquals(127, result.getBlue());
    }
}
