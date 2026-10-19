package fr.univartois.butinfo.fractalens.complex;

/**
 * The type Complex.
 */
public class Complex implements IComplex {
    private final double a;
    private final double b;

    /**
     * Instantiates a new Complex.
     *
     * @param a the a
     * @param b the b
     */
    public  Complex(double a, double b){
        this.a=a;
        this.b=b;
    }
    /**
     * Gives the real part of this complex number.
     *
     * @return The real part of this complex number.
     */
    @Override
    public double getRealPart() {

        return a;
    }
    /**
     * Gives the imaginary part of this complex number.
     *
     * @return The imaginary part of this complex number.
     */
    @Override
    public double getImaginaryPart() {

        return b;
    }
    /**
     * Gives the modulus of this complex number.
     *
     * @return The modulus of this complex number.
     */
    @Override
    public double abs() {
        double a1=this.getRealPart();
        double b1=this.getImaginaryPart();
        return Math.sqrt(a1*a1+b1*b1);
    }
    /**
     * Gives the opposite of this complex number.
     *
     * @return The opposite of this complex number.
     */
    @Override
    public IComplex negate() {
        double a1=this.getRealPart();
        double b1=this.getImaginaryPart();
        return new Complex(-a1,-b1);
    }
    /**
     * Gives the conjugate of this complex number.
     *
     * @return The conjugate of this complex number.
     */
    @Override
    public IComplex conjugate() {
        double a1=this.getRealPart();
        double b1=this.getImaginaryPart();
        return new Complex(a1,-b1);
    }
    /**
     * Adds this complex number to an other one.
     *
     * @param other The complex number to add to this one.
     *
     * @return The result of {@code this + other}.
     */
    @Override
    public IComplex add(IComplex other) {
        double a1 = this.getRealPart();
        double a2 = other.getRealPart();
        double b1 = this.getImaginaryPart();
        double b2 = other.getImaginaryPart();
        double resA = a1 + a2;
        double resB = b1 + b2;
        return new Complex(resA, resB);
    }
    /**
     * Subtracts a complex number from this one.
     *
     * @param other The complex number to subtract from this one.
     *
     * @return The result of {@code this - other}.
     */
    @Override
    public IComplex subtract(IComplex other) {
        double a1=this.getRealPart();
        double a2=other.getRealPart();
        double b1=this.getImaginaryPart();
        double b2=other.getImaginaryPart();
        double resA = a1 - a2;
        double resB = b1 - b2;
        return new Complex(resA, resB);
    }
    /**
     * Multiplies this complex number by a real value.
     *
     * @param value The value by which to multiply this number.
     *
     * @return The result of {@code this * value}.
     */
    @Override
    public IComplex multiply(double value) {
        double a1=this.getRealPart();
        double b1=this.getImaginaryPart();
        double resA=value*a1;
        double resB=value*b1;
        return new Complex(resA,resB);
    }
    /**
     * Multiplies this complex number by an other one.
     *
     * @param other The complex number to multiply this one with.
     *
     * @return The result of {@code this * other}.
     */
    @Override
    public IComplex multiply(IComplex other) {
        double a1=this.getRealPart();
        double a2=other.getRealPart();
        double b1=this.getImaginaryPart();
        double b2=other.getImaginaryPart();
        double resA= (a1*a2-b1*b2);
        double resB=(a2*b1+a1*b2);
        return new Complex(resA,resB);
    }
    /**
     * Divides this complex number by an other one.
     *
     * @param other The complex number to divide this one by.
     *
     * @return The result of {@code this / other}.
     */
    @Override
    public IComplex divide(IComplex other) {
        double a1=this.getRealPart();
        double a2=other.getRealPart();
        double b1=this.getImaginaryPart();
        double b2=other.getImaginaryPart();
        double resA= (a1*a2+b1*b2)/a2*a2+b2*b2;
        double resB=(a2*b1-a1*b2)/a2*a2+b2*b2;
        return new Complex(resA,resB);
    }

}
