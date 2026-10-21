package fr.univartois.butinfo.fractalens.complex.sequence;

import fr.univartois.butinfo.fractalens.complex.Complex;
import fr.univartois.butinfo.fractalens.complex.IComplex;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for {@link BurningShipSequence}.
 */
public class BurningShipSequenceTest {

    private static final double EPSILON = 1e-9;

    /**
     * Tests computeNext taking absolute values of real and imaginary parts before squaring.
     */
    @Test
    void testComputeNextWithNegativeParts() {
        // c = 0 + 0i
        IComplex c = new Complex(0, 0);
        IComplex z0 = new Complex(0, 0);
        BurningShipSequence sequence = new BurningShipSequence(c, z0, 10);

        IComplex previous = new Complex(-1, 2);
        IComplex next = sequence.computeNext(previous);

        assertEquals(-3.0, next.getRealPart());
        assertEquals(4.0, next.getImaginaryPart());
    }

    /**
     * Tests computeNext with a non-zero constant c.
     */
    @Test
    void testComputeNextWithConstantC() {
        // c = 0.5 + 0.5i
        IComplex c = new Complex(0.5, 0.5);
        IComplex z0 = new Complex(0, 0);
        BurningShipSequence sequence = new BurningShipSequence(c, z0, 10);

        IComplex previous = new Complex(-2, -3);
        IComplex next = sequence.computeNext(previous);

        assertEquals(-4.5, next.getRealPart());
        assertEquals(12.5, next.getImaginaryPart());
    }

    /**
     * Tests sequence iteration.
     */
    @Test
    void testIteratorStep() {
        IComplex c = new Complex(0, 0);
        IComplex z0 = new Complex(-1, 2);
        BurningShipSequence sequence = new BurningShipSequence(c, z0, 2);

        Iterator<IComplex> iterator = sequence.iterator();

        assertTrue(iterator.hasNext());
        IComplex first = iterator.next();
        assertEquals(-1.0, first.getRealPart());
        assertEquals(2.0, first.getImaginaryPart());

        assertTrue(iterator.hasNext());
        IComplex second = iterator.next();
        assertEquals(-3.0, second.getRealPart());
        assertEquals(4.0, second.getImaginaryPart());
    }
}
