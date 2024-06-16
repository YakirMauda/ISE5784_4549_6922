package renderer;

import org.junit.jupiter.api.Test;
import primitives.Color;

import static java.awt.Color.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the ImageWriter class.
 */
class ImageWriterTests {

    /**
     * Test method for creating an image with a specific pattern and writing it to file.
     */
    @Test
    public void ImageWriterTest() {
        // Create a new image writer
        ImageWriter imageWriter = new ImageWriter("imageWriterTest", 800, 500);

        // Define colors
        Color color = new Color(BLUE);
        Color backgroundColor = new Color(RED);

        int nX = imageWriter.getNx();
        int nY = imageWriter.getNy();

        // Fill the entire image with the background color
        for (int i = 0; i < nY; ++i) {
            for (int j = 0; j < nX; ++j) {
                imageWriter.writePixel(j, i, backgroundColor);
            }
        }

        // Draw horizontal lines with the specified color every 50 pixels
        for (int i = 0; i < nY; i += 50) {
            for (int j = 0; j < nX; ++j) {
                imageWriter.writePixel(j, i, color);
            }
        }

        // Draw vertical lines with the specified color every 50 pixels
        for (int i = 0; i < nY; ++i) {
            for (int j = 0; j < nX; j += 50) {
                imageWriter.writePixel(j, i, color);
            }
        }

        // Write the image to file
        imageWriter.writeToImage();
    }

    /**
     * Test method for {@link ImageWriter#writeToImage()}.
     * Currently, this method is not implemented.
     */
    @Test
    void testWriteToImage() {
    }

    /**
     * Test method for {@link ImageWriter#writePixel(int, int, Color)}.
     * Currently, this method is not implemented.
     */
    @Test
    void testWritePixel() {
    }
}
