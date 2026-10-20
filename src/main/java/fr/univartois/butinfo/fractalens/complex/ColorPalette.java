package fr.univartois.butinfo.fractalens.complex;

import java.awt.Color;
import java.util.List;

/**
 * Ensemble de palettes de couleurs prédéfinies pour la palette fixe.
 */
public enum ColorPalette {

    FIRE(List.of(
            new Color(0, 0, 0),       // Noir (divergence rapide / fond)
            new Color(64, 0, 0),      // Rouge très sombre
            new Color(180, 20, 0),    // Rouge feu
            new Color(255, 100, 0),   // Orange intense
            new Color(255, 200, 0),   // Jaune éclatant
            new Color(255, 255, 200)  // Blanc chaud
    )),

    OCEAN(List.of(
            new Color(0, 5, 20),      // Bleu nuit très sombre
            new Color(0, 40, 95),     // Bleu marine
            new Color(0, 110, 170),   // Bleu océan
            new Color(0, 190, 210),   // Cyan / Turquoise
            new Color(180, 240, 255)  // Blanc écume
    )),

    NEON(List.of(
            new Color(15, 0, 25),     // Violet sombre
            new Color(120, 0, 200),   // Violet néon
            new Color(255, 0, 130),   // Rose fuchsia
            new Color(0, 240, 220),   // Cyan fluo
            new Color(255, 255, 0)    // Jaune fluo
    )),

    RAINBOW(List.of(
            Color.BLACK,
            new Color(75, 0, 130),    // Indigo
            Color.BLUE,
            Color.GREEN,
            Color.YELLOW,
            Color.ORANGE,
            Color.RED,
            Color.WHITE
    )),

    PASTEL(List.of(
            new Color(40, 40, 60),    // Gris bleu sombre
            new Color(180, 160, 200), // Lilas
            new Color(160, 200, 220), // Bleu pastel
            new Color(180, 230, 200), // Vert menthe
            new Color(250, 220, 180), // Pêche
            new Color(255, 255, 255)  // Blanc
    ));

    private final List<Color> colors;

    ColorPalette(List<Color> colors) {
        this.colors = colors;
    }

    public List<Color> getColors() {
        return colors;
    }

    /**
     * Récupère le nombre de couleurs contenues dans la palette.
     */
    public int size() {
        return colors.size();
    }

    /**
     * Récupère directement la i-ème couleur.
     */
    public Color getColor(int index) {
        return colors.get(index % colors.size());
    }
}
