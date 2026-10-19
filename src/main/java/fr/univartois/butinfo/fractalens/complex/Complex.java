package fr.univartois.butinfo.fractalens.complex;

public class Complex implements IComplex {
    private final double a;
    private final double b;

    public  Complex(double a, double b){
        this.a=a;
        this.b=b;
    }
    @Override
    public double getRealPart() {

        return a;
    }

    @Override
    public double getImaginaryPart() {

        return b;
    }

    @Override
    public double abs() {

        return 0;
    }

    @Override
    public IComplex negate() {

        return null;
    }

    @Override
    public IComplex conjugate() {

        return null;
    }

    @Override
    public IComplex add(IComplex other) {

        return null;
    }

    @Override
    public IComplex subtract(IComplex other) {
        double a1=this.getRealPart();
        double a2=other.getRealPart();
        double b1=this.getImaginaryPart();
        double b2=other.getImaginaryPart();
        double a = a1 - a2;
        double b = b1 - b2;
        return new Complex(a, b);
    }

    @Override
    public IComplex multiply(double value) {

        return null;
    }

    @Override
    public IComplex multiply(IComplex other) {

        return null;
    }

    @Override
    public IComplex divide(IComplex other) {
        double a1=this.getRealPart();
        double a2=other.getRealPart();
        double b1=this.getImaginaryPart();
        double b2=this.getImaginaryPart();
        double resA= (a1*a2+b1*b2)/a2*a2+b2*b2;
        double resB=(a2*b1-a1*b2)/a2*a2+b2*b2;
        return new Complex(resA,resB);
    }

}
