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
}

//   @Test
//   public void tenImagesTest() {
//      Scene scene = new Scene("Test scene");
//      scene.setAmbientLight(new AmbientLight(new Color(255, 255, 255), 0.1));
//
//      // Adding various geometries
//      scene.geometries.add(
//              new Sphere(new Point(0, 0, -100), 50) //
//                      .setEmission(new Color(java.awt.Color.BLUE)) //
//                      .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(100)),
//              new Triangle(new Point(100, 0, -100), new Point(0, 100, -100), new Point(100, 100, -100)) //
//                      .setEmission(new Color(java.awt.Color.GREEN)) //
//                      .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(100)),
//              new Plane(new Point(0, 0, -150), new Point(0, 1, -150), new Point(1, 0, -150)) //
//                      .setEmission(new Color(java.awt.Color.RED)) //
//                      .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(100)),
//              new Cylinder(new Ray(new Point(-50, -50, -100), new Vector(1, 1, 0)), 20, 50) //
//                      .setEmission(new Color(java.awt.Color.YELLOW)) //
//                      .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(100)),
//              new Polygon(new Point(0, 0, -100), new Point(50, 0, -100), new Point(50, 50, -100), new Point(0, 50, -100)) //
//                      .setEmission(new Color(java.awt.Color.ORANGE)) //
//                      .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(100)),
//              new Tube(new Ray(new Point(50, 50, -100), new Vector(0, 1, 0)), 10) //
//                      .setEmission(new Color(java.awt.Color.PINK)) //
//                      .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(100)),
//              new Sphere(new Point(50, 0, -100), 25) //
//                      .setEmission(new Color(java.awt.Color.MAGENTA)) //
//                      .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(100)),
//              new Triangle(new Point(-100, 0, -100), new Point(0, -100, -100), new Point(-100, -100, -100)) //
//                      .setEmission(new Color(java.awt.Color.CYAN)) //
//                      .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(100)),
//              new Plane(new Point(0, -100, -200), new Point(100, -100, -200), new Point(50, -50, -200)) //
//                      .setEmission(new Color(java.awt.Color.LIGHT_GRAY)) //
//                      .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(100)),
//              new Cylinder(new Ray(new Point(100, 100, -100), new Vector(1, 0, 0)), 30, 70) //
//                      .setEmission(new Color(java.awt.Color.DARK_GRAY)) //
//                      .setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(100))
//      );
//
//      // Adding lights
//      scene.lights.add(new SpotLight(new Color(700, 400, 400), new Point(40, 40, 115), new Vector(-1, -1, -4)) //
//              .setKl(0.0004).setKq(0.0000006));
//
//      Camera camera = new Camera(new Point(0, 0, 1000), new Vector(0, 0, -1), new Vector(0, 1, 0)) //
//              .setViewPlaneSize(200, 200).setDistance(1000);
//
//      ImageWriter imageWriter = new ImageWriter("scene", 500, 500);
//      camera.setImageWriter(imageWriter) //
//              .setRayTracer(new SimpleRayTracer(scene)) //
//              .renderImage() //
//              .writeToImage();
//
//   }
//}
