package fr.univartois.butinfo.fractalens.complex.sequence;

import fr.univartois.butinfo.fractalens.complex.IComplex;

import java.util.Iterator;

public class GeneralizedJulia implements IComplexSequence {

    private final IComplex c;
    private final IComplex z0;
    private final int maxIterations;
    private final int p;

    //z^p + c

    public GeneralizedJulia(IComplex c, IComplex z0, int maxIterations, int p) {
        this.c = c;
        this.z0 = z0;
        this.maxIterations = maxIterations;
        this.p = p;
    }

    @Override
    public IComplex computeNext(IComplex previous) {
        return previous.power(p).add(c);
    }

    @Override
    public Iterator<IComplex> iterator() {
        return new ComplexSequence(this, z0, maxIterations);
    }
}
