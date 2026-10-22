package fr.univartois.butinfo.fractalens.complex.plane;

import fr.univartois.butinfo.fractalens.complex.Complex;
import fr.univartois.butinfo.fractalens.complex.IComplex;

/**
 * La classe {@code ComplexPlane} fournit une implémentation de base de l'interface {@link IComplexPlane},
 * permettant d'associer les coordonnées des pixels d'une image à des points dans le plan complexe.
 *
 * @author Halipré Hugo
 *
 * @version 0.1.0
 */
public class ComplexPlane implements IComplexPlane {

    /**
     * La largeur de l'image en pixels.
     */
    private final int width;

    /**
     * La hauteur de l'image en pixels.
     */
    private final int height;

    /**
     * Construit un nouveau plan complexe avec les dimensions spécifiées.
     *
     * @param width La largeur de l'image en pixels.
     * @param height La hauteur de l'image en pixels.
     */
    public ComplexPlane(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Détermine le nombre complexe correspondant à la position d'un pixel dans l'image.
     *
     * @param row La ligne du pixel dans l'image (ordonnée, du haut vers le bas).
     * @param column La colonne du pixel dans l'image (abscisse, de la gauche vers la droite).
     *
     * @return Le nombre complexe correspondant à la position donnée.
     */
    @Override
    public IComplex asComplex(int row, int column) {
        double realPart = column - (width / 2.0);
        double imaginaryPart = (height / 2.0) - row;
        return new Complex(realPart, imaginaryPart);
    }
}
