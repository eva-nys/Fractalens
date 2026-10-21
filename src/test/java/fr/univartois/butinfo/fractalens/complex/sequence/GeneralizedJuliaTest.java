package fr.univartois.butinfo.fractalens.complex.sequence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import fr.univartois.butinfo.fractalens.complex.Complex;
import org.junit.jupiter.api.Test;

import fr.univartois.butinfo.fractalens.complex.IComplex;

class GeneralizedJuliaTest {

    /**
     * Creates a new complex number.
     *
     * @param realPart The real part of the complex number.
     * @param imaginaryPart The imaginary part of the complex number.
     * @return The created complex number.
     */
    private static IComplex createComplex(double realPart, double imaginaryPart) {
        return new Complex(realPart, imaginaryPart);
    }

    /**
     * Creates a new sequence implementing Generalized Julia's sequence.
     *
     * @param constant The constant number in the definition of the Generalized Julia's sequence.
     * @param first The first term of the sequence.
     * @param nbTerms The maximum number of terms to compute.
     * @return The created Generalized Julia's sequence.
     */
    private static IComplexSequence createGeneralizedJuliaSequence(IComplex constant, IComplex first, int nbTerms) {
        return new GeneralizedJulia(constant, first, nbTerms);
    }


    @Test
    void testComputeNext() {
        IComplex c = createComplex(0, 0);
        IComplex z0 = createComplex(0.5, 0);
        IComplexSequence julia = createGeneralizedJuliaSequence(c, z0, 50);

        IComplex z1 = createComplex(0.25, 0);
        assertEquals(z1, julia.computeNext(z0));

        IComplex z2 = createComplex(0.0625, 0);
        assertEquals(z2, julia.computeNext(z1));
    }

    /**
     * Test method for
     * {@link fr.univartois.butinfo.fractalens.complex.sequence.IComplexSequence#iterator()}
     * when the sequence converges.
     */
    @Test
    void testIteratorOnConvergence() {
        IComplex c = createComplex(0, 0);
        IComplex z0 = createComplex(0.5, 0); // Converge vers 0
        int nbTerms = 50;

        IComplexSequence julia = createGeneralizedJuliaSequence(c, z0, nbTerms);
        int nbIterations = 0;

        for (var _ : julia) {
            nbIterations++;
        }

        assertEquals(nbTerms, nbIterations);
    }

    /**
     * Test method for
     * {@link fr.univartois.butinfo.fractalens.complex.sequence.IComplexSequence#iterator()}
     * when the sequence diverges.
     */
    @Test
    void testIteratorOnDivergence() {
        IComplex c = createComplex(0, 0);
        IComplex z0 = createComplex(2, 0); // Diverge (2 -> 4 -> 16...)
        int nbTerms = 50;

        IComplexSequence julia = createGeneralizedJuliaSequence(c, z0, nbTerms);
        int nbIterations = 0;

        for (var _ : julia) {
            nbIterations++;
        }

        assertTrue(nbIterations < nbTerms);
    }

}