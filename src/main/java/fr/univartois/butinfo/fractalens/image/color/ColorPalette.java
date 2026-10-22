package fr.univartois.butinfo.fractalens.image.color;

import java.awt.Color;
import java.util.List;

/**
 * Ensemble de palettes de couleurs prédéfinies pour la palette fixe.
 */
public enum ColorPalette {

    // ===================== PALETTES D'ORIGINE =====================

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

    CYAN(List.of(
            new Color(0, 15, 25),     // Bleu nuit profond (fond)
            new Color(0, 80, 120),    // Cyan sombre
            new Color(0, 180, 210),   // Cyan électrique
            new Color(80, 240, 240),  // Aquamarine clair
            new Color(220, 255, 255)  // Blanc glacé
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
    )),

    // ============ PALETTES SPÉCIALES (conçues pour ColoredRVB(0.0, 1.0, 1.0)) ============
    // Le rouge est supprimé : seuls le vert et le bleu portent le contraste.

    JULIA_SPRINT3(List.of(
            new Color(0, 0, 10),      // Quasi noir bleuté (fond)
            new Color(0, 20, 70),     // Bleu nuit
            new Color(0, 60, 140),    // Bleu profond
            new Color(0, 110, 200),   // Bleu vif
            new Color(0, 170, 220),   // Bleu ciel
            new Color(0, 220, 200),   // Turquoise
            new Color(0, 255, 160),   // Vert menthe électrique
            new Color(0, 200, 120),   // Vert émeraude
            new Color(0, 255, 255)    // Cyan pur
    )),

    ABYSS(List.of(
            new Color(0, 0, 0),       // Noir abyssal
            new Color(0, 10, 40),     // Bleu encre
            new Color(0, 40, 90),     // Bleu des profondeurs
            new Color(0, 90, 130),    // Bleu-vert sombre
            new Color(0, 150, 150),   // Sarcelle
            new Color(0, 220, 180),   // Vert lagon
            new Color(0, 255, 230)    // Cyan lumineux
    )),

    AURORA(List.of(
            new Color(0, 5, 20),      // Ciel polaire
            new Color(0, 60, 80),     // Vert-bleu sombre
            new Color(0, 160, 110),   // Vert aurore
            new Color(0, 255, 140),   // Vert fluo
            new Color(0, 200, 255),   // Bleu glacier
            new Color(0, 80, 220),    // Bleu électrique
            new Color(0, 255, 200)    // Turquoise vif
    )),

    EMERALD(List.of(
            new Color(0, 10, 5),      // Vert presque noir
            new Color(0, 60, 30),     // Vert forêt
            new Color(0, 130, 70),    // Vert émeraude
            new Color(0, 200, 110),   // Vert jade
            new Color(0, 255, 160),   // Vert menthe
            new Color(0, 255, 230)    // Aqua
    )),

    BIOLUMINESCENCE(List.of(
            new Color(0, 0, 15),      // Noir bleuté
            new Color(0, 30, 120),    // Bleu profond
            new Color(0, 120, 255),   // Bleu néon
            new Color(0, 255, 220),   // Cyan fluo
            new Color(0, 255, 100),   // Vert fluo
            new Color(0, 90, 160),    // Bleu océan
            new Color(0, 255, 255)    // Cyan éclatant
    )),

    GLACIER(List.of(
            new Color(0, 15, 40),     // Bleu glace sombre
            new Color(0, 70, 120),    // Bleu glacier
            new Color(0, 140, 190),   // Bleu clair
            new Color(0, 200, 230),   // Bleu givré
            new Color(0, 245, 255),   // Cyan glacé
            new Color(0, 255, 255)    // Cyan lumineux
    )),

    // ===================== CHAUDES =====================

    LAVA(List.of(
            new Color(10, 0, 0),
            new Color(90, 0, 0),
            new Color(200, 30, 0),
            new Color(255, 90, 0),
            new Color(255, 170, 20),
            new Color(255, 240, 120)
    )),

    SUNSET(List.of(
            new Color(20, 0, 40),     // Violet nuit
            new Color(90, 0, 100),    // Pourpre
            new Color(200, 30, 90),   // Rose vif
            new Color(255, 100, 50),  // Orange corail
            new Color(255, 180, 40),  // Or
            new Color(255, 240, 180)  // Crème
    )),

    SUNRISE(List.of(
            new Color(25, 10, 60),
            new Color(110, 40, 130),
            new Color(230, 80, 110),
            new Color(255, 150, 80),
            new Color(255, 210, 110),
            new Color(255, 250, 220)
    )),

    EMBER(List.of(
            new Color(5, 0, 0),
            new Color(60, 10, 0),
            new Color(130, 30, 0),
            new Color(220, 70, 0),
            new Color(255, 140, 20)
    )),

    VOLCANO(List.of(
            new Color(0, 0, 0),
            new Color(50, 0, 0),
            new Color(150, 0, 0),
            new Color(255, 60, 0),
            new Color(255, 160, 0),
            new Color(255, 255, 80),
            new Color(255, 255, 255)
    )),

    DESERT(List.of(
            new Color(40, 20, 10),
            new Color(120, 60, 20),
            new Color(190, 120, 50),
            new Color(230, 180, 100),
            new Color(250, 220, 160),
            new Color(255, 245, 220)
    )),

    AUTUMN(List.of(
            new Color(30, 10, 0),
            new Color(110, 30, 0),
            new Color(190, 70, 10),
            new Color(230, 130, 20),
            new Color(210, 180, 40),
            new Color(120, 90, 20)
    )),

    GOLD(List.of(
            new Color(10, 5, 0),
            new Color(80, 50, 0),
            new Color(170, 120, 0),
            new Color(230, 180, 20),
            new Color(255, 215, 60),
            new Color(255, 250, 200)
    )),

    COPPER(List.of(
            new Color(15, 5, 0),
            new Color(80, 35, 15),
            new Color(150, 80, 40),
            new Color(200, 120, 70),
            new Color(235, 170, 120),
            new Color(255, 225, 190)
    )),

    // ===================== FROIDES =====================

    ICE(List.of(
            new Color(0, 10, 30),
            new Color(30, 80, 140),
            new Color(100, 160, 220),
            new Color(190, 225, 255),
            new Color(245, 252, 255)
    )),

    MIDNIGHT(List.of(
            new Color(0, 0, 10),
            new Color(10, 10, 50),
            new Color(25, 25, 110),
            new Color(60, 60, 170),
            new Color(130, 130, 220)
    )),

    DEEP_SPACE(List.of(
            new Color(0, 0, 0),
            new Color(15, 0, 40),
            new Color(40, 10, 100),
            new Color(90, 40, 170),
            new Color(160, 110, 230),
            new Color(230, 220, 255)
    )),

    GALAXY(List.of(
            new Color(0, 0, 15),
            new Color(40, 0, 90),
            new Color(110, 20, 160),
            new Color(200, 60, 180),
            new Color(60, 100, 220),
            new Color(200, 230, 255)
    )),

    NEBULA(List.of(
            new Color(5, 0, 20),
            new Color(70, 0, 110),
            new Color(160, 30, 140),
            new Color(230, 90, 150),
            new Color(60, 120, 200),
            new Color(160, 220, 255)
    )),

    ARCTIC(List.of(
            new Color(10, 25, 45),
            new Color(40, 90, 130),
            new Color(110, 170, 200),
            new Color(190, 225, 240),
            new Color(250, 255, 255)
    )),

    LAGOON(List.of(
            new Color(0, 25, 35),
            new Color(0, 90, 100),
            new Color(0, 160, 160),
            new Color(80, 215, 200),
            new Color(190, 250, 235)
    )),

    // ===================== NATURE =====================

    FOREST(List.of(
            new Color(0, 15, 5),
            new Color(10, 60, 20),
            new Color(30, 110, 40),
            new Color(90, 160, 60),
            new Color(170, 210, 100),
            new Color(230, 245, 180)
    )),

    JUNGLE(List.of(
            new Color(0, 10, 0),
            new Color(0, 70, 20),
            new Color(20, 140, 40),
            new Color(120, 200, 30),
            new Color(220, 230, 40),
            new Color(255, 120, 0)
    )),

    SPRING(List.of(
            new Color(30, 60, 30),
            new Color(100, 170, 80),
            new Color(180, 220, 110),
            new Color(250, 200, 220),
            new Color(255, 245, 250)
    )),

    TROPICAL(List.of(
            new Color(0, 40, 50),
            new Color(0, 150, 130),
            new Color(250, 220, 60),
            new Color(255, 120, 60),
            new Color(230, 40, 100)
    )),

    MOSS(List.of(
            new Color(15, 20, 5),
            new Color(50, 70, 20),
            new Color(100, 120, 40),
            new Color(150, 165, 80),
            new Color(205, 210, 150)
    )),

    SAKURA(List.of(
            new Color(50, 20, 40),
            new Color(160, 70, 110),
            new Color(240, 140, 170),
            new Color(255, 200, 215),
            new Color(255, 240, 245)
    )),

    // ===================== VIVES / ARTIFICIELLES =====================

    CANDY(List.of(
            new Color(60, 0, 80),
            new Color(255, 80, 180),
            new Color(255, 200, 80),
            new Color(100, 230, 220),
            new Color(190, 140, 255),
            new Color(255, 255, 255)
    )),

    CYBERPUNK(List.of(
            new Color(5, 0, 20),
            new Color(60, 0, 130),
            new Color(255, 0, 170),
            new Color(0, 230, 255),
            new Color(255, 240, 0)
    )),

    SYNTHWAVE(List.of(
            new Color(15, 0, 40),
            new Color(90, 0, 150),
            new Color(255, 40, 160),
            new Color(255, 140, 60),
            new Color(255, 230, 100),
            new Color(0, 220, 255)
    )),

    VAPORWAVE(List.of(
            new Color(30, 10, 70),
            new Color(130, 60, 200),
            new Color(255, 110, 200),
            new Color(110, 230, 230),
            new Color(255, 250, 170)
    )),

    TOXIC(List.of(
            new Color(5, 10, 0),
            new Color(40, 80, 0),
            new Color(120, 200, 0),
            new Color(200, 255, 0),
            new Color(120, 0, 160)
    )),

    ELECTRIC(List.of(
            new Color(0, 0, 20),
            new Color(0, 0, 160),
            new Color(0, 120, 255),
            new Color(180, 240, 255),
            new Color(255, 255, 255)
    )),

    PSYCHEDELIC(List.of(
            new Color(255, 0, 0),
            new Color(255, 160, 0),
            new Color(255, 255, 0),
            new Color(0, 255, 0),
            new Color(0, 160, 255),
            new Color(160, 0, 255),
            new Color(255, 0, 160)
    )),

    // ===================== SOBRES / TECHNIQUES =====================

    GRAYSCALE(List.of(
            new Color(0, 0, 0),
            new Color(60, 60, 60),
            new Color(120, 120, 120),
            new Color(190, 190, 190),
            new Color(255, 255, 255)
    )),

    INVERTED_GRAY(List.of(
            new Color(255, 255, 255),
            new Color(190, 190, 190),
            new Color(120, 120, 120),
            new Color(60, 60, 60),
            new Color(0, 0, 0)
    )),

    SEPIA(List.of(
            new Color(20, 10, 0),
            new Color(80, 50, 25),
            new Color(140, 100, 60),
            new Color(200, 160, 110),
            new Color(245, 225, 190)
    )),

    BLUEPRINT(List.of(
            new Color(0, 20, 60),
            new Color(10, 60, 130),
            new Color(40, 110, 190),
            new Color(130, 180, 230),
            new Color(235, 245, 255)
    )),

    NEWSPAPER(List.of(
            new Color(20, 20, 20),
            new Color(90, 90, 85),
            new Color(160, 158, 150),
            new Color(215, 212, 200),
            new Color(245, 242, 230)
    )),

    THERMAL(List.of(
            new Color(0, 0, 40),
            new Color(60, 0, 140),
            new Color(190, 0, 100),
            new Color(255, 100, 0),
            new Color(255, 220, 0),
            new Color(255, 255, 255)
    )),

    VIRIDIS(List.of(
            new Color(68, 1, 84),
            new Color(59, 82, 139),
            new Color(33, 145, 140),
            new Color(94, 201, 98),
            new Color(253, 231, 37)
    )),

    MAGMA(List.of(
            new Color(0, 0, 4),
            new Color(81, 18, 124),
            new Color(183, 55, 121),
            new Color(252, 137, 97),
            new Color(252, 253, 191)
    )),

    PLASMA(List.of(
            new Color(13, 8, 135),
            new Color(126, 3, 168),
            new Color(204, 71, 120),
            new Color(248, 149, 64),
            new Color(240, 249, 33)
    )),

    INFERNO(List.of(
            new Color(0, 0, 4),
            new Color(87, 16, 110),
            new Color(188, 55, 84),
            new Color(249, 142, 9),
            new Color(252, 255, 164)
    )),

    TWILIGHT(List.of(
            new Color(226, 217, 226),
            new Color(131, 156, 190),
            new Color(100, 60, 160),
            new Color(60, 20, 70),
            new Color(160, 70, 90),
            new Color(226, 217, 226)
    )),

    MINT_CHOCOLATE(List.of(
            new Color(25, 15, 10),     // Chocolat noir profond (fond)
            new Color(70, 40, 25),     // Marron chocolat
            new Color(30, 90, 70),     // Menthe sombre
            new Color(75, 180, 145),   // Vert menthe doux
            new Color(150, 240, 210),  // Menthe glacée
            new Color(230, 255, 245)   // Blanc mentholé
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
