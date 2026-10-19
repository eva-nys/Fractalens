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
public class ComplexSequence implements Iterator<IComplex> {

    /**
     * The sequence used to calculate the terms.
     */
    private final IComplexSequence sequence;

    /**
     * The maximum number of iterations to perform.
     */
    private final int maxIterations;

    /**
     * The current complex term in the sequence.
     */
    private IComplex current;

    /**
     * The number of iterations already performed.
     */
    private int nbIterations;

    /**
     * Constructs a new iterator for a complex sequence.
     *
     * @param sequence      The complex sequence to navigate.
     * @param initialValue  The initial complex number (z0).
     * @param maxIterations The maximum number of permitted iterations.
     */
    public ComplexSequence(IComplexSequence sequence, IComplex initialValue, int maxIterations) {
        this.sequence = sequence;
        this.current = initialValue;
        this.maxIterations = maxIterations;
        this.nbIterations = 0;
    }

    @Override
    public boolean hasNext() {
        return (nbIterations < maxIterations) && (current.abs() <= 2.0);
    }

    @Override
    public IComplex next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Iteration limit reached or divergent sequence.");
        }

        current = sequence.computeNext(current);
        nbIterations++;

        return current;
    }
}