package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Vector;
import primitives.Ray;


import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link Plane} class.
 */
class PlaneTests {

    /** Delta value for accuracy when comparing the numbers of type 'double' in
     * assertEquals */
    private final double DELTA = 0.000001;

    /**
     * Test method for {@link geometries.Plane#Plane(Point, Point, Point)}.
     * Tests the constructor of the Plane class.
     */
    @Test
    public void testConstructor() {
        // =============== Boundary Values Tests ==================
        // TC01: Creating a plane with 2 points that are the same
        assertThrows(IllegalArgumentException.class, () -> {
            new Plane(new Point(0, 0, 0), new Point(0, 0, 0), new Point(0, 1, 0));
        }, "Constructed a plane with 2 points that are the same");

        // TC02: Creating a plane with 3 points that are on the same line
        assertThrows(IllegalArgumentException.class, () -> {
            new Plane(new Point(0, 0, 0), new Point(1, 0, 0), new Point(2, 0, 0));
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
        Vector n = new Plane(new Point(0, 0, 1), new Point(1, 0, 0), new Point(0, 1, 0)).getNormal(null);
        assertEquals(1, n.length(), DELTA, "Bad normal length");
        assertEquals(0, new Point(0, 0, 1).subtract(new Point(0, 1, 0)).dotProduct(n), DELTA, "Normal isn't orthogonal to plane");
        assertEquals(0, new Point(0, 0, 1).subtract(new Point(1, 0, 0)).dotProduct(n), DELTA, "Normal isn't orthogonal to plane");
    }


    /**
     * Test method for {@link geometries.Plane#findIntersections(Ray)}.
     * Tests the findIntersections method of the Plane class.
     */
    @Test
    void testFindIntersections(){
        // =============== Boundary Values Tests ==================
        // TC01: The ray on the plane (and paralle
        Ray ray = new Ray(new Point(0, 0, 1), new Vector(0, 0, -1));

        //
    }
}
