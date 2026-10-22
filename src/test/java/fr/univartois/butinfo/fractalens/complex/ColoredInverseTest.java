package fr.univartois.butinfo.fractalens.complex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.awt.Color;

import fr.univartois.butinfo.fractalens.image.color.IColor;
import fr.univartois.butinfo.fractalens.image.color.ColoredInverse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ColoredInverseTest {

    private IColor invertedPalette;

    private static class MockPalette implements IColor {
        private final Color colorToReturn;

        public MockPalette(Color colorToReturn) {
            this.colorToReturn = colorToReturn;
        }

        @Override
        public Color coloredDot(int iteration, int max) {
            return colorToReturn;
        }
    }

    @BeforeEach
    void initPalette() {
        IColor mockPalette = new MockPalette(new Color(100, 150, 200));
        invertedPalette = new ColoredInverse(mockPalette);
    }

    @Test
    void testStandardInversion() {
        Color result = invertedPalette.coloredDot(10, 100);

        assertEquals(255 - 100, result.getRed());
        assertEquals(255 - 150, result.getGreen());
        assertEquals(255 - 200, result.getBlue());
        assertNotEquals(new Color(100, 150, 200), result);
    }

    @Test
    void testBlackInversionToWhite() {
        IColor blackPalette = new MockPalette(Color.BLACK);
        IColor invertedBlack = new ColoredInverse(blackPalette);

        Color result = invertedBlack.coloredDot(0, 100);

        assertEquals(255, result.getRed());
        assertEquals(255, result.getGreen());
        assertEquals(255, result.getBlue());
        assertNotEquals(Color.BLACK, result);
    }

    @Test
    void testWhiteInversionToBlack() {
        IColor whitePalette = new MockPalette(Color.WHITE);
        IColor invertedWhite = new ColoredInverse(whitePalette);

        Color result = invertedWhite.coloredDot(100, 100);

        assertEquals(0, result.getRed());
        assertEquals(0, result.getGreen());
        assertEquals(0, result.getBlue());
        assertNotEquals(Color.WHITE, result);
    }
}
