package renderer;

import org.junit.jupiter.api.Test;
import primitives.Color;

import static java.awt.Color.RED;
import static java.awt.Color.YELLOW;
import static org.junit.jupiter.api.Assertions.*;

class ImageWriterTests {


    @Test
    public void test() {
        //create a new image writer
        ImageWriter imageWriter = new ImageWriter("test_image", 800, 500);

        Color color = new Color(YELLOW);
        Color backgroundColor = new Color(RED);


        // Calculate grid int imageWidth = 800; // Image width
		int imageHeight = 500; // Image height
		String imageName = "test_image"; // Image file name

        //???????????????????????????????????????

        /**
        int nX = imageWriter.getNx();
        int nY = imageWriter.getNy();

        for (int i = 0; i < nY; ++i)
            for (int j = 0; j < nX; ++j)
                imageWriter.writePixel(j, i,
                        j % 50 == 0 || i % 50 == 0 ? new Color(RED) : new Color(YELLOW));

        imageWriter.writeToImage();
         */
    }


    @Test
    void testWriteToImage() {
    }


    @Test
    void testWritePixel() {
    }
}