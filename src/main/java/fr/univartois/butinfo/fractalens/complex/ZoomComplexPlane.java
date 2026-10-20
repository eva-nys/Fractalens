package fr.univartois.butinfo.fractalens.complex;

public class ZoomComplexPlane implements IComplexPlane{

    private IComplexPlane decorator;

    double zoom;

    public ZoomComplexPlane(IComplexPlane decorateur, double zoom) {
        this.decorator = decorateur;
        this.zoom = zoom;
    }

    @Override
    public IComplex asComplex(int row, int column) {
        IComplex beforeZoom = decorator.asComplex(row, column);
        return beforeZoom.multiply(zoom);
    }



}
