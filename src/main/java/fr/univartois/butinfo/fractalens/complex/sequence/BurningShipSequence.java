package fr.univartois.butinfo.fractalens.complex.sequence;

import fr.univartois.butinfo.fractalens.complex.Complex;
import fr.univartois.butinfo.fractalens.complex.IComplex;

import java.util.Iterator;
public class BurningShipSequence implements IComplexSequence {

    private final IComplex c;
    private final IComplex z0;
    private final int maxIterations;

    public BurningShipSequence(IComplex c, IComplex z0, int maxIterations){
        this.c = c;
        this.z0 = z0;
        this.maxIterations = maxIterations;
    }

    @Override
    public IComplex computeNext(IComplex previous) {
        double absReal = Math.abs(previous.getRealPart());
        double absImag = Math.abs(previous.getImaginaryPart());
        IComplex absComplex = new Complex(absReal, absImag);
        return absComplex.multiply(absComplex).add(c);
    }



    @Override
    public Iterator<IComplex> iterator() {
        return new ComplexSequence(this, z0, maxIterations);
    }

}
