package fr.univartois.butinfo.fractalens.complex.sequence;

import fr.univartois.butinfo.fractalens.complex.IComplex;

import java.util.Iterator;

public class GeneralizedJulia implements IComplexSequence {

    private final IComplex c;
    private final IComplex z0;
    private final int maxIterations;

    //z^p + c

    public GeneralizedJulia(IComplex c, IComplex z0, int maxIterations) {
        this.c = c;
        this.z0 = z0;
        this.maxIterations = maxIterations;
    }

    @Override
    public IComplex computeNext(IComplex previous) {
        return previous.multiply(previous).add(c);
    }

    @Override
    public Iterator<IComplex> iterator() {
        return new ComplexSequence(this, z0, maxIterations);
    }
}
