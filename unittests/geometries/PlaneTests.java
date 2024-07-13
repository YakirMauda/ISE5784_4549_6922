package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Vector;
import primitives.Ray;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link Plane} class.
 */
class PlaneTests {

    /** Delta value for accuracy when comparing the numbers of type 'double' in
     * assertEquals */
    private final double DELTA = 0.000001;
    private final Point p000 = new Point(0, 0, 0);
    private final Point p100 = new Point(1, 0, 0);
    private final Point p010 = new Point(0, 1, 0);
    private final Point p001 = new Point(0, 0, 1);

    /**
     * Test method for {@link geometries.Plane#Plane(Point, Point, Point)}.
     * Tests the constructor of the Plane class.
     */
    @Test
    public void testConstructor() {
        // =============== Boundary Values Tests ==================
        // TC01: Creating a plane with 2 points that are the same
        assertThrows(IllegalArgumentException.class, () -> {
            new Plane(p000, p000, p010);
        }, "Constructed a plane with 2 points that are the same");

        // TC02: Creating a plane with 3 points that are on the same line
        assertThrows(IllegalArgumentException.class, () -> {
            new Plane(p000, p100, new Point(2, 0, 0));
        }, "Constructed a plane with 3 points that are on the same line");
    }

    /**
     * Test method for {@link geometries.Plane#getNormal(Point)}.
     * Tests the getNormal method of the Plane class.
     */
    @Test
    void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: There is a simple single test here
        Vector n = new Plane(p001, p100, p010).getNormal(null);
        assertEquals(1, n.length(), DELTA, "Bad normal length");
        assertEquals(0, p001.subtract(p010).dotProduct(n), DELTA, "Normal isn't orthogonal to plane");
        assertEquals(0, p001.subtract(p100).dotProduct(n), DELTA, "Normal isn't orthogonal to plane");
    }


    /**
     * Test method for {@link geometries.Plane#findIntersections(Ray)}.
     * Tests the findIntersections method of the Plane class.
     */
    @Test
    void testFindIntersections(){
        Plane pl = new Plane(p100, new Point(2, 0, 0), new Point(1, 1, 0));

        // =============== Boundary Values Tests ==================
        // TC01: The ray on the plane (and parallel of course)
        Ray ray = new Ray(p100, new Vector(1, 0, 0));
        assertNull(pl.findIntersections(ray), "Ray is on the plane");

        // TC02: The ray is parallel to the plane but not on the plane
        ray = new Ray(p001, new Vector(1, 0, 0));
        assertNull(pl.findIntersections(ray), "Ray is parallel to the plane but not on the plane");

        // TC03: The ray is orthogonal to the plane and starts before the plane
        ray = new Ray(new Point(1,0,-1), new Vector(0, 0, 1));
        assertEquals(List.of(p100), pl.findIntersections(ray), "Ray is orthogonal to the plane and starts before the plane");

        // TC04: The ray is orthogonal to the plane and starts in the plane
        ray = new Ray(p000, new Vector(0, 0, 1));
        assertNull(pl.findIntersections(ray), "Ray is orthogonal to the plane and starts in the plane");

        // TC05: The ray is orthogonal to the plane and starts after the plane
        ray = new Ray(p001, new Vector(0, 0, 1));
        assertNull(pl.findIntersections(ray), "Ray is orthogonal to the plane and starts after the plane");

        // TC06: The ray is neither orthogonal nor parallel to the plane and starts on the plane at the represent point
        ray = new Ray(p100, new Vector(1, 1, 0));
        assertNull(pl.findIntersections(ray), "Ray is neither orthogonal nor parallel to the plane and starts on the plane at the represent point");

        // TC07: The ray is neither orthogonal nor parallel to the plane and starts on the plane but not at the represent point
        ray = new Ray(p010, new Vector(1, 1, 0));
        assertNull(pl.findIntersections(ray), "Ray is neither orthogonal nor parallel to the plane and starts on the plane but not at the represent point");


        // =============== Equivalence Partitions Tests ==============
        // TC08: The ray is neither orthogonal nor parallel to the plane and starts before the plane
        ray = new Ray(new Point(0,0,-1), new Vector(1, 1, 1));
        assertEquals(List.of(new Point(1,1,0)), pl.findIntersections(ray), "Ray is neither orthogonal nor parallel to the plane and starts before the plane");

        // TC09: The ray is neither orthogonal nor parallel to the plane and starts after the plane
        ray = new Ray(p001, new Vector(1, 1, 1));
        assertNull(pl.findIntersections(ray), "Ray is neither orthogonal nor parallel to the plane and starts after the plane");
    }

    @Test
    public void testMaxDistance() {
        Plane pl = new Plane(p100, new Point(2, 0, 0), new Point(1, 1, 0));

        // =============== Equivalence Partitions Tests ==============
        // TC01: The distance is 0
        Ray ray = new Ray(new Point(0,0,-1), new Vector(1, 1, 1));
        assertNull(pl.findGeoIntersections(ray, 0), "The max distance is wrong");

        // TC02: The distance is greater than 0
        assertEquals(1, pl.findGeoIntersections(ray, 10).size(), "The max distance is wrong");
    }
}
