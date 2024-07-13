package renderer;

import static java.awt.Color.*;

import org.junit.jupiter.api.Test;
import geometries.*;
import lighting.*;
import primitives.*;
import scene.Scene;

/**
 * Test rendering a basic image
 */
public class snookerTest {
    /** Scene of the tests */
    private final Scene scene = new Scene("Test scene");
    /** Camera builder of the tests */
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
    public void snookerrrTest() {
        scene.geometries.add(
                new Polygon(
                        new Point(-328.19696, -188.54953, 85.362366),
                        new Point(-310.241852, -206.504669, 85.362366),
                        new Point(310.241852, -206.504669, 85.362366),
                        new Point(328.19696, -188.54953, 85.362366),
                        new Point(328.19696, 188.54953, 85.362366),
                        new Point(310.241852, 206.504669, 85.362366),
                        new Point(-310.241852, 206.504669, 85.362366),
                        new Point(-328.19696, 188.54953, 85.362366)
                ).setMaterial(new Material().setKd(0.588235).setKs(0.0).setShininess(141421378).setkT(0.0).setkR(1.0))
                        .setEmission(new Color(0, 0, 0)),
                new Polygon(
                        new Point(-317.676971, -224.454666, 0.0),
                        new Point(317.676971, -224.454666, 0.0),
                        new Point(317.676971, -224.454666, 102.76236),
                        new Point(-317.676971, -224.454666, 102.76236)
                ).setMaterial(new Material().setKd(0.588235).setKs(0.0).setShininess(141421378).setkT(0.0).setkR(1.0))
                        .setEmission(new Color(0, 0, 0)),
                new Polygon(
                        new Point(346.146973, -195.984665, 0.0),
                        new Point(346.146973, 195.984665, 0.0),
                        new Point(346.146973, 195.984665, 102.76236),
                        new Point(346.146973, -195.984665, 102.76236)
                ).setMaterial(new Material().setKd(0.588235).setKs(0.0).setShininess(141421378).setkT(0.0).setkR(1.0))
                        .setEmission(new Color(0, 0, 0)),
                new Polygon(
                        new Point(317.676971, 224.454666, 0.0),
                        new Point(-317.676971, 224.454666, 0.0),
                        new Point(-317.676971, 224.454666, 102.76236),
                        new Point(317.676971, 224.454666, 102.76236)
                ).setMaterial(new Material().setKd(0.588235).setKs(0.0).setShininess(141421378).setkT(0.0).setkR(1.0))
                        .setEmission(new Color(0, 0, 0)),
                new Polygon(
                        new Point(-346.146973, 195.984665, 0.0),
                        new Point(-346.146973, -195.984665, 0.0),
                        new Point(-346.146973, -195.984665, 102.76236),
                        new Point(-346.146973, 195.984665, 102.76236)
                ).setMaterial(new Material().setKd(0.588235).setKs(0.0).setShininess(141421378).setkT(0.0).setkR(1.0))
                        .setEmission(new Color(0, 0, 0)),
                new Polygon(
                        new Point(317.676971, -224.454666, 0.0),
                        new Point(346.146973, -195.984665, 0.0),
                        new Point(346.146973, -195.984665, 102.76236),
                        new Point(317.676971, -224.454666, 102.76236)
                ).setMaterial(new Material().setKd(0.588235).setKs(0.0).setShininess(141421378).setkT(0.0).setkR(1.0))
                        .setEmission(new Color(0, 0, 0)),
                new Polygon(
                        new Point(-317.676971, -224.454666, 102.76236),
                        new Point(-346.146973, -195.984665, 102.76236),
                        new Point(-346.146973, -195.984665, 0.0),
                        new Point(-317.676971, -224.454666, 0.0)
                ).setMaterial(new Material().setKd(0.588235).setKs(0.0).setShininess(141421378).setkT(0.0).setkR(1.0))
                        .setEmission(new Color(0, 0, 0))
        );
        scene.setAmbientLight(new AmbientLight(new Color(255, 191, 191), Double3.ONE))
                .setBackground(new Color(75, 127, 90));

        camera.setImageWriter(new ImageWriter("snooker test", 1000, 1000))
                .build()
                .renderImage()
                .printGrid(100, new Color(YELLOW))
                .writeToImage();
    }

    // Other test methods would go here, including `renderMultiColorTest`, `basicRenderXml`, and `tenImagesTest`
}
