package fr.univartois.butinfo.fractalens.complex.sequence;

import fr.univartois.butinfo.fractalens.complex.Complex;
import fr.univartois.butinfo.fractalens.complex.IComplex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;


class EnumSequenceTest {

    private static final double EPSILON = 1e-5;
    private IComplex pixel;
    private int maxIterations;

    @BeforeEach
    void setUp() {
        pixel = new Complex(1.0, 1.0);
        maxIterations = 100;
    }

    @Test
    void testMandelbrot() {
        IComplexSequence sequence = EnumSequence.MANDELBROT.create(pixel, maxIterations);
        assertNotNull(sequence);

        IComplex previous = new Complex(2.0, 3.0);
        IComplex next = sequence.computeNext(previous);

        assertEquals(-4.0, next.getRealPart(), EPSILON);
        assertEquals(13.0, next.getImaginaryPart(), EPSILON);
    }

    @Test
    void testGeneralizedJulia() {
        IComplexSequence sequence = EnumSequence.GENERALIZED_JULIA.create(pixel, maxIterations);
        assertNotNull(sequence);

        IComplex previous = new Complex(1.0, 1.0);
        IComplex next = sequence.computeNext(previous);

        assertEquals(-1.715, next.getRealPart(), EPSILON);
        assertEquals(2.01, next.getImaginaryPart(), EPSILON);
    }

    @Test
    void testGeneralizedMandelbrot() {
        IComplexSequence sequence = EnumSequence.GENERALIZED_MANDELBROT.create(pixel, maxIterations);
        assertNotNull(sequence);

        IComplex previous = new Complex(1.0, 1.0);
        IComplex next = sequence.computeNext(previous);

        assertEquals(-1.0, next.getRealPart(), EPSILON);
        assertEquals(3.0, next.getImaginaryPart(), EPSILON);
    }

    @Test
    void testBurningShip() {
        IComplexSequence sequence = EnumSequence.BURNING_SHIP.create(pixel, maxIterations);
        assertNotNull(sequence);

        IComplex previous = new Complex(-2.0, 3.0);
        IComplex next = sequence.computeNext(previous);

        assertEquals(-4.0, next.getRealPart(), EPSILON);
        assertEquals(13.0, next.getImaginaryPart(), EPSILON);
    }

    @Test
    void testGeneralizedBurningShip() {
        IComplexSequence sequence = EnumSequence.GENERALIZED_BURNING_SHIP.create(pixel, maxIterations);
        assertNotNull(sequence);

        IComplex previous = new Complex(-1.0, -1.0);
        IComplex next = sequence.computeNext(previous);

        assertEquals(-1.0, next.getRealPart(), EPSILON);
        assertEquals(3.0, next.getImaginaryPart(), EPSILON);
    }

    @Test
    void testTricorn() {
        IComplexSequence sequence = EnumSequence.TRICORN.create(pixel, maxIterations);
        assertNotNull(sequence);

        IComplex previous = new Complex(2.0, 3.0);
        IComplex next = sequence.computeNext(previous);

        assertEquals(-4.0, next.getRealPart(), EPSILON);
        assertEquals(-11.0, next.getImaginaryPart(), EPSILON);
    }

    @Test
    void testGeneralizedTricorn() {
        IComplexSequence sequence = EnumSequence.GENERALIZED_TRICORN.create(pixel, maxIterations);
        assertNotNull(sequence);

        IComplex previous = new Complex(1.0, 1.0);
        IComplex next = sequence.computeNext(previous);

        assertEquals(-1.0, next.getRealPart(), EPSILON);
        assertEquals(-1.0, next.getImaginaryPart(), EPSILON);
    }

    @Test
    void testIteratorCreation() {
        for (EnumSequence enumSeq : EnumSequence.values()) {
            IComplexSequence sequence = enumSeq.create(pixel, maxIterations);
            Iterator<IComplex> iterator = sequence.iterator();
            assertNotNull(iterator);
        }
    }
}
