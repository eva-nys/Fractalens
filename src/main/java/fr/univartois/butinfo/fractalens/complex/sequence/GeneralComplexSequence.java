package fr.univartois.butinfo.fractalens.complex.sequence;

import fr.univartois.butinfo.fractalens.complex.IComplex;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

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

/*    @Override
    public void forEach(Consumer<? super IComplex> action) {
        IComplexSequence.super.forEach(action);
    }

    @Override
    public Spliterator<IComplex> spliterator() {
        return IComplexSequence.super.spliterator();
    }*/
}
