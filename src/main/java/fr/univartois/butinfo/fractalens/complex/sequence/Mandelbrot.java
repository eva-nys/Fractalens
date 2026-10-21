package fr.univartois.butinfo.fractalens.complex.sequence;

import fr.univartois.butinfo.fractalens.complex.IComplex;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Independent iterator for traversing the terms of a complex sequence.
 *
 * @author UnivArtois
 * @version 1.0
 */
public class Mandelbrot implements IComplexSequence {

    private final IComplex c;
    private final IComplex z0;
    private final int maxIterations;

    public Mandelbrot(IComplex c, IComplex z0, int maxIterations) {
        this.c = c;
        this.z0 = z0;
        this.maxIterations = maxIterations;
    }

    @Override
    public IComplex computeNext(IComplex previous) {
        return previous.multiply(previous).add(z0);
    }

    /**
     * Returns an iterator over the elements of this complex sequence
     *
     * @return An {@link Iterator} of {@link IComplex} representing the sequence values
     */
    @Override
    public Iterator<IComplex> iterator() {
        return new ComplexSequence(this, z0, maxIterations);
    }
}