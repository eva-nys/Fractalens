package fr.univartois.butinfo.fractalens.complex.plane;

import fr.univartois.butinfo.fractalens.complex.IComplex;

public class ZoomComplexPlane implements IComplexPlane{

    private IComplexPlane decorated;

    private double zoom;

    public ZoomComplexPlane(IComplexPlane decorator, double zoom) {
        this.decorated = decorator;
        this.zoom = zoom;
    }

    @Override
    public IComplex asComplex(int row, int column) {
        IComplex beforeZoom = decorated.asComplex(row, column);
        return beforeZoom.multiply(zoom);
    }



}
