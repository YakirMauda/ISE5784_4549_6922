package renderer;

import geometries.Intersectable;
import geometries.Plane;
import geometries.Sphere;
import geometries.Triangle;
import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Vector;
import scene.Scene;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Integration tests for constructing rays from camera and checking
 * intersections with various geometries.
 */
public class CameraRayIntersectionsIntegrationTests {

    /** Camera builder for the tests */
    private final Camera.Builder cameraBuilder = Camera.getBuilder()
            .setDirection(new Vector(0, 0, -1), new Vector(0, -1, 0))
            .setVpSize(3,3)
            .setRayTracer(new SimpleRayTracer(new Scene("Test")))
            .setImageWriter(new ImageWriter("Test", 1, 1))
            .setVpDistance(1);

    // Define the camera parameters
    private final Camera camera0 = cameraBuilder.setLocation(Point.ZERO).build();
    private final Camera camera05 = cameraBuilder.setLocation(new Point(0,0,0.5)).build();

    /**
     * Integration test method for constructing rays from camera and checking
     * intersections with spheres.
     */
    @Test
    void testCameraRaySphereIntegration() {
        // TC01: Small Sphere - 2 points
        Sphere sp = new Sphere(new Point(0,0,-3),1);
        assertCountIntersections(camera0, sp, 2);

        // TC02: Big Sphere - 18 points
        sp = new Sphere(new Point(0,0,-2.5),2.5);
        assertCountIntersections(camera05, sp, 18);

        // TC03: Medium Sphere - 10 points
        sp = new Sphere(new Point(0,0,-2),2);
        assertCountIntersections(camera05, sp, 10);

        // TC04: Inside Sphere - 9 points
        sp = new Sphere(new Point(0,0,-1),4);
        assertCountIntersections(camera05, sp, 9);

        // TC05: Beyond Sphere - 0 points
        sp = new Sphere(new Point(0,0,1),0.5);
        assertCountIntersections(camera0, sp, 0);
    }

    /**
     * Integration test method for constructing rays from camera and checking
     * intersections with planes.
     */
    @Test
    public void cameraRayPlaneIntegration() {
        // TC01: Plane parallel to camera - 9 points
        Plane pl = new Plane(new Point(0, 0, -5), new Vector(0, 0, 1));
        assertCountIntersections(camera0, pl, 9);

        // TC02: Plane with little angle - 9 points
        pl = new Plane(new Point(0, 0, -5), new Vector(0, 1, 2));
        assertCountIntersections(camera0, pl, 9);

        // TC03: Plane with big angle - 6 points
        pl = new Plane(new Point(0, 0, -5), new Vector(0, 1, 1));
        assertCountIntersections(camera0, pl, 6);

        // TC04: Plane parallel to camera and beyond it - 0 points
        pl = new Plane(new Point(0, 0, 1), new Vector(0, 1, 1));
        assertCountIntersections(camera0, pl, 0);
    }

    /**
     * Integration test method for constructing rays from camera and checking
     * intersections with triangles.
     */
    @Test
    public void cameraRayTriangleIntegration() {
        // TC01: Small triangle - 1 point
        Triangle tr = new Triangle(new Point(0,1,-2), new Point(1,-1,-2), new Point(-1,-1,-2));
        assertCountIntersections(camera0, tr, 1);

        // TC02: Medium triangle - 2 points
        tr = new Triangle(new Point(0,20,-2), new Point(1,-1,-2), new Point(-1,-1,-2));
        assertCountIntersections(camera0, tr, 2);

        // TC03: Beyond triangle - 0 points
        tr = new Triangle(new Point(0,1,1), new Point(1,-1,1), new Point(-1,-1,1));
        assertCountIntersections(camera0, tr, 0);
    }

    /**
     * Helper method to assert the number of intersection points between rays constructed
     * from the camera and a given geometry.
     *
     * @param camera the camera from which rays are constructed
     * @param geometry the geometry to check intersections with
     * @param expectedIntersections the expected number of intersection points
     */
    private void assertCountIntersections(Camera camera, Intersectable geometry, int expectedIntersections) {
        int count = 0;

        // Iterate through the 3x3 view plane grid
        for (int i = 0; i < 3; ++i)
            for (int j = 0; j < 3; ++j) {
                var intersections = geometry.findIntersections(camera.constructRay(3, 3, j, i));
                if (intersections != null)
                    count += intersections.size();
            }

        // Assert the expected number of intersections
        assertEquals(expectedIntersections, count, "Wrong amount of intersections in the CameraRayIntersectionsIntegrationTests");
    }
}