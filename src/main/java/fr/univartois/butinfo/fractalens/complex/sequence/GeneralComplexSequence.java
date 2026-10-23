package fr.univartois.butinfo.fractalens.complex.sequence;

import fr.univartois.butinfo.fractalens.complex.IComplex;

import java.util.Iterator;
import java.util.function.BinaryOperator;

public class GeneralComplexSequence implements IComplexSequence {

    private final BinaryOperator<IComplex> function;
    private final IComplex z0;
    private final int max;


    public GeneralComplexSequence(BinaryOperator<IComplex> function, IComplex z0, int max) {
        this.function = function;
        this.z0 = z0;
        this.max = max;
    }

    @Override
    public IComplex computeNext(IComplex previous) {
        return function.apply(previous, z0);
    }

    @Override
    public Iterator<IComplex> iterator() {
        return new ComplexSequence(this, z0, max);
    }

}
