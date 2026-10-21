package fr.univartois.butinfo.fractalens.complex.sequence;

import fr.univartois.butinfo.fractalens.complex.Complex;
import fr.univartois.butinfo.fractalens.complex.IComplex;

import java.util.Iterator;
import java.util.function.BiFunction;


public enum EnumSequence {


    MANDELBROT((pixel, max) -> {
        return new Mandelbrot(pixel, pixel, max, 2);
    }),


    GENERALIZED_JULIA((pixel, max) -> {
        IComplex c = new Complex(0.285, 0.01); // Constante de Julia (modifiable)
        int power = 3;
        return new GeneralizedJulia(c, pixel, max, power);
    }),


    GENERALIZED_MANDELBROT((pixel, max) -> {
        int power = 3;
        return new Mandelbrot(pixel, pixel, max, power);
    }),


    BURNING_SHIP((pixel, max) -> {
        IComplex z0 = new Complex(0, 0);
        return new BurningShipSequence(pixel, z0, max);
    }),


    GENERALIZED_BURNING_SHIP((pixel, max) -> new IComplexSequence() {
        private final int power = 3;

        @Override
        public IComplex computeNext(IComplex previous) {
            double absReal = Math.abs(previous.getRealPart());
            double absImag = Math.abs(previous.getImaginaryPart());
            return new Complex(absReal, absImag).power(power).add(pixel);
        }

        @Override
        public Iterator<IComplex> iterator() {
            return new ComplexSequence(this, new Complex(0, 0), max);
        }
    }),

    TRICORN((pixel, max) -> new IComplexSequence() {
        @Override
        public IComplex computeNext(IComplex previous) {
            return previous.conjugate().multiply(previous.conjugate()).add(pixel);
        }

        @Override
        public Iterator<IComplex> iterator() {
            return new ComplexSequence(this, new Complex(0, 0), max);
        }
    }),


    GENERALIZED_TRICORN((pixel, max) -> new IComplexSequence() {
        private final int power = 3;

        @Override
        public IComplex computeNext(IComplex previous) {
            return previous.conjugate().power(power).add(pixel);
        }

        @Override
        public Iterator<IComplex> iterator() {
            return new ComplexSequence(this, new Complex(0, 0), max);
        }
    });




    private final BiFunction<IComplex, Integer, IComplexSequence> factory;


    EnumSequence(BiFunction<IComplex, Integer, IComplexSequence> factory) {
        this.factory = factory;
    }


    public IComplexSequence create(IComplex pixel, int maxIterations) {
        return factory.apply(pixel, maxIterations);
    }
}
