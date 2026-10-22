//package fr.univartois.butinfo.fractalens.complex.generator;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertSame;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//import java.awt.Color;
//import java.io.IOException;
//import java.io.UncheckedIOException;
//import java.util.function.BiFunction;
//import java.util.function.IntFunction;
//
//import fr.univartois.butinfo.fractalens.generator.FractalGenerator;
//import fr.univartois.butinfo.fractalens.generator.IFractalGenerator;
//import org.junit.jupiter.api.Test;
//
//import fr.univartois.butinfo.fractalens.complex.Complex;
//import fr.univartois.butinfo.fractalens.complex.plane.ComplexPlane;
//import fr.univartois.butinfo.fractalens.complex.IComplex;
//import fr.univartois.butinfo.fractalens.complex.sequence.IComplexSequence;
//import fr.univartois.butinfo.fractalens.complex.sequence.JuliaSequence;
//import fr.univartois.butinfo.fractalens.image.IFractalImage;
//
//
//class FractalGeneratorTest {
//
//    // The maximum number of iterations used in the tests
//    private static final int MAX_ITERATIONS = 50;
//
//    // The path used to save the images in the tests
//    private static final String PATH = "fractal.png";
//
//    private static class StubImage implements IFractalImage {
//
//        //The colors of the pixels of this image
//        private final Color[][] colors;
//
//        // The number of times a pixel color has been set
//        private int nbSetColor;
//
//        /**
//         * The path in which this image has been saved.
//         */
//        private String savedPath;
//
//        // Whether saving this image must fail
//        private final boolean failOnSave;
//
//        /**
//         * Creates a new StubImage
//         * @param height The height of the image.
//         * @param width The width of the image.
//         * @param failOnSave Whether saving the image must fail.
//         */
//        StubImage(int height, int width, boolean failOnSave) {
//            this.colors = new Color[height][width];
//            this.failOnSave = failOnSave;
//        }
//
//        @Override
//        public int getHeight() {
//            return colors.length;
//        }
//
//        @Override
//        public int getWidth() {
//            return colors[0].length;
//        }
//
//        @Override
//        public void setColor(int row, int column, Color color) {
//            colors[row][column] = color;
//            nbSetColor++;
//        }
//
//        @Override
//        public void saveAs(String path) throws IOException {
//            if (failOnSave) {
//                throw new IOException("Simulated failure");
//            }
//            savedPath = path;
//        }
//    }
//
//    /**
//     * Creates a new complex number
//     * @param realPart The real part of the complex number.
//     * @param imaginaryPart The imaginary part of the complex number.
//     * @return The created complex number.
//     */
//    private static IComplex createComplex(double realPart, double imaginaryPart) {
//        return new Complex(realPart, imaginaryPart);
//    }
//
//    /**
//     * Creates a function building Julia's sequences for a given constant
//     * @param constant The constant number in the definition of Julia's sequence
//     * @return The created function.
//     */
//    private static BiFunction<IComplex, Integer, IComplexSequence> createJuliaFactory(
//            IComplex constant) {
//        return (z0, max) -> new JuliaSequence(constant, z0, max);
//    }
//
//    /**
//     * The color strategy used in the tests: the number of iterations is used as the level of grey
//     */
//    private static final IntFunction<Color> PALETTE = n -> new Color(n, n, n);
//
//    /**
//     * Creates a new generator working on a given image
//     * @param image The image on which to draw the fractal
//     * @return The created generator
//     */
//    private static IFractalGenerator createGenerator(StubImage image) {
//        return new FractalGenerator(image,
//                new ComplexPlane(image.getWidth(), image.getHeight()),
//                createJuliaFactory(createComplex(0, 0)), MAX_ITERATIONS, PALETTE, PATH);
//    }
//
//    /**
//     * Test method for computePixelColor when the sequence converges
//     */
//    @Test
//    void testComputePixelColorOnConvergence() {
//        // The center of the image corresponds to the complex number 0.
//        IFractalGenerator generator = createGenerator(new StubImage(10, 10, false));
//
//        assertEquals(PALETTE.apply(MAX_ITERATIONS), generator.computePixelColor(5, 5));
//    }
//
//    /**
//     * Test method for computePixelColor when the sequence diverges
//     */
//    @Test
//    void testComputePixelColorOnDivergence() {
//        // The pixel (5, 9) corresponds to the complex number 4, which diverges at once.
//        IFractalGenerator generator = createGenerator(new StubImage(10, 10, false));
//
//        assertEquals(PALETTE.apply(0), generator.computePixelColor(5, 9));
//    }
//
//    @Test
//    void testComputePixelColorUsesPixelAsFirstTerm() {
//        IComplex[] received = new IComplex[1];
//        int[] receivedMax = new int[1];
//        StubImage image = new StubImage(10, 10, false);
//        IFractalGenerator generator = new FractalGenerator(image, new ComplexPlane(10, 10),
//                (z0, max) -> {
//                    received[0] = z0;
//                    receivedMax[0] = max;
//                    return new JuliaSequence(createComplex(0, 0), z0, max);
//                }, MAX_ITERATIONS, PALETTE, PATH);
//
//        generator.computePixelColor(2, 7);
//
//        assertEquals(createComplex(2, 3), received[0]);
//        assertEquals(MAX_ITERATIONS, receivedMax[0]);
//    }
//
//    /**
//     * Test method for generateImage
//     */
//    @Test
//    void testGenerateImage() {
//        StubImage image = new StubImage(6, 8, false);
//        IFractalGenerator generator = createGenerator(image);
//
//        IFractalImage result = generator.generateImage();
//
//        assertSame(image, result);
//        assertEquals(6 * 8, image.nbSetColor);
//        for (int row = 0; row < image.getHeight(); row++) {
//            for (int column = 0; column < image.getWidth(); column++) {
//                assertNotNull(image.colors[row][column]);
//                assertEquals(generator.computePixelColor(row, column),
//                        image.colors[row][column]);
//            }
//        }
//    }
//
//    /**
//     * Test method for generateImage, checking that the generated image is saved
//     */
//    @Test
//    void testGenerateImageSavesImage() {
//        StubImage image = new StubImage(4, 4, false);
//
//        createGenerator(image).generateImage();
//
//        assertEquals(PATH, image.savedPath);
//    }
//
//    /**
//     * Test method for saveImage
//     */
//    @Test
//    void testSaveImage() {
//        StubImage image = new StubImage(4, 4, false);
//
//        createGenerator(image).saveImage();
//
//        assertEquals(PATH, image.savedPath);
//    }
//
//    /**
//     * Test method for saveImage when an I/O error occurs
//     */
//    @Test
//    void testSaveImageOnIOError() {
//        IFractalGenerator generator = createGenerator(new StubImage(4, 4, true));
//
//        assertThrows(UncheckedIOException.class, generator::saveImage);
//    }
//
//}
