package renderer;

import org.junit.jupiter.api.Test;
import primitives.Color;

import static java.awt.Color.*;
import static org.junit.jupiter.api.Assertions.*;

class ImageWriterTests {


    @Test
    public void ImageWriterTest() {
        //create a new image writer
        ImageWriter imageWriter = new ImageWriter("imageWriterTest", 800, 500);

        Color color = new Color(YELLOW);
        Color backgroundColor = new Color(BLUE);


        // Calculate grid int imageWidth = 800; // Image width
//		int imageHeight = 500; // Image height
//		String imageName = "test_image"; // Image file name

        //???????????????????????????????????????

        int nX = imageWriter.getNx();
        int nY = imageWriter.getNy();

        // 167 ms
//        for (int i = 0; i < nY; ++i)
//            for (int j = 0; j < nX; ++j) {
//                if(i % 50 == 0 || j % 50 == 0)
//                    imageWriter.writePixel(j, i, color);
//                else
//                    imageWriter.writePixel(j, i, backgroundColor);
//            }

        // 169 ms
//        for (int i = 0; i < nY; ++i)
//            for (int j = 0; j < nX; ++j)
//                imageWriter.writePixel(j, i,
//                        j % 50 == 0 || i % 50 == 0 ? color : backgroundColor);


        // 148 ms - we have a winner!!!!!!!!!!!
        for (int i = 0; i < nY; ++i)
            for (int j = 0; j < nX; ++j)
                imageWriter.writePixel(j, i, backgroundColor);

        for (int i = 0; i < nY; i += 50)
            for (int j = 0; j < nX; j += 50)
                imageWriter.writePixel(j, i, color);


        imageWriter.writeToImage();
    }


    @Test
    void testWriteToImage() {
    }


    @Test
    void testWritePixel() {
    }
}