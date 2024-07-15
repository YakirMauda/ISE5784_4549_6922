package renderer;

import static java.awt.Color.*;

import org.junit.jupiter.api.Test;

import geometries.*;
import lighting.*;
import primitives.*;
import scene.Scene;

/**
 * Test rendering a basic image
 * @author Dan
 */
public class RenderTests {
    /**
     * Scene of the tests
     */
    private final Scene scene = new Scene("Test scene");
    /**
     * Camera builder of the tests
     */
    private final Camera.Builder camera = Camera.getBuilder()
            .setRayTracer(new SimpleRayTracer(scene))
            .setLocation(Point.ZERO).setDirection(new Vector(0, 0, -1), new Vector(0, 1, 0))
            .setVpDistance(100)
            .setVpSize(500, 500);

    /**
     * Produce a scene with basic 3D model and render it into a png image with a
     * grid
     */
    @Test
    public void renderTwoColorTest() {
        scene.geometries.add(new Sphere(new Point(0, 0, -100), 50d),
                new Triangle(new Point(-100, 0, -100), new Point(0, 100, -100), new Point(-100, 100, -100)), // up
                // left
                new Triangle(new Point(-100, 0, -100), new Point(0, -100, -100),
                        new Point(-100, -100, -100)), // down
                // left
                new Triangle(new Point(100, 0, -100), new Point(0, -100, -100), new Point(100, -100, -100))); // down
        scene.setAmbientLight(new AmbientLight(new Color(255, 191, 191), Double3.ONE))
                .setBackground(new Color(75, 127, 90));

        // right
        camera
                .setImageWriter(new ImageWriter("base render test", 1000, 1000))
                .build()
                .renderImage()
                .printGrid(100, new Color(YELLOW))
                .writeToImage();
    }

    // For stage 6 - please disregard in stage 5

    /**
     * Produce a scene with basic 3D model - including individual lights of the
     * bodies and render it into a png image with a grid
     */
    @Test
    public void renderMultiColorTest() {
        scene.geometries.add( // center
                new Sphere(new Point(0, 0, -100), 50),
                // up left
                new Triangle(new Point(-100, 0, -100), new Point(0, 100, -100), new Point(-100, 100, -100))
                        .setEmission(new Color(GREEN)),
                // down left
                new Triangle(new Point(-100, 0, -100), new Point(0, -100, -100), new Point(-100, -100, -100))
                        .setEmission(new Color(RED)),
                // down right
                new Triangle(new Point(100, 0, -100), new Point(0, -100, -100), new Point(100, -100, -100))
                        .setEmission(new Color(BLUE)));
        scene.setAmbientLight(new AmbientLight(new Color(WHITE), new Double3(0.2, 0.2, 0.2))); //

        camera
                .setImageWriter(new ImageWriter("color render test", 1000, 1000))
                .build()
                .renderImage()
                .printGrid(100, new Color(WHITE))
                .writeToImage();
    }

    /**
     * Test for XML based scene - for bonus
     */
    @Test
    public void basicRenderXml() {
        // enter XML file name and parse from XML file into scene object
        // using the code you added in appropriate packages
        // ...
        // NB: unit tests is not the correct place to put XML parsing code

        camera
                .setImageWriter(new ImageWriter("xml render test", 1000, 1000))
                .build()
                .renderImage()
                .printGrid(100, new Color(YELLOW))
                .writeToImage();
    }

    /**
     * Test for multiple images from XML - for bonus
     */
    @Test
    public void tenImagesTest() {
        Geometry polygon = new Polygon(
                new Point(328.19696, 188.54953, 85.362366),
                new Point(310.241852, 206.504669, 85.362366),
                new Point(-310.241852, 206.504669, 85.362366),
                new Point(-328.19696, 188.54953, 85.362366)
        ).setMaterial(new Material().setKd(0.588235).setKs(0.0).setShininess(141421378).setkT(0.0).setkR(1.0)
        ).setEmission(new Color(0, 0, 0));

        Geometry triangle = new Polygon(
                new Point(-317.676971, -224.454666, 0.0),
                new Point(317.676971, -224.454666, 0.0),
                new Point(317.676971, -224.454666, 102.76236),
                new Point(-317.676971, -224.454666, 102.76236)
        ).setMaterial(new Material().setKd(0.588235).setKs(0.0).setShininess(141421378).setkT(0.0).setkR(1.0)
        ).setEmission(new Color(0, 0, 0));

        Geometry sphere = new Polygon(
                new Point(346.146973, -195.984665, 0.0),
                new Point(346.146973, 195.984665, 0.0),
                new Point(346.146973, 195.984665, 102.76236),
                new Point(346.146973, -195.984665, 102.76236)
        ).setMaterial(new Material().setKd(0.588235).setKs(0.0).setShininess(141421378).setkT(0.0).setkR(1.0)
        ).setEmission(new Color(0, 0, 0));

        Geometry plane = new Polygon(
                new Point(317.676971, 224.454666, 0.0),
                new Point(-317.676971, 224.454666, 0.0),
                new Point(-317.676971, 224.454666, 102.76236),
                new Point(317.676971, 224.454666, 102.76236)
        ).setMaterial(new Material().setKd(0.588235).setKs(0.0).setShininess(141421378).setkT(0.0).setkR(1.0)
        ).setEmission(new Color(0, 0, 0));
    }
}