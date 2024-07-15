package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link Triangle} class.
 */
class TriangleTests {

    private final double DELTA = 0.000001;
    private final Point p001 = new Point(0, 0, 1);
    private final Point p010 = new Point(0, 1, 0);
    private final Point p100 = new Point(1, 0, 0);
    private final Triangle tr    = new Triangle(p001, p100, p010);
    private final Plane plg = new Plane(p001, p100, p010);

    /**
     * Test method for {@link geometries.Triangle#getNormal(Point)}.
     * Tests the getNormal method of the Triangle class.
     */
    @Test
    void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: There is a simple single test here
        Vector n = plg.getNormal(p001);
        assertEquals(1, n.length(), DELTA, "Bad normal length");
        assertEquals(0, p001.subtract(p010).dotProduct(n), DELTA, "Normal isn't orthogonal to triangle");
        assertEquals(0, p001.subtract(p100).dotProduct(n), DELTA, "Normal isn't orthogonal to triangle");
    }

    /**
     * Test method for {@link geometries.Triangle#findIntersections(Ray)}.
     * Tests the findIntersections method of the Triangle class.
     */
    @Test
    public void testFindIntersectionsRay() {
        // =============== Boundary Values Tests ==================
        // TC01: In vertex
        Ray ray = new Ray(new Point(-1, 0, 0), new Vector(1, 1, 0));
        assertEquals(List.of(new Point(0, 1, 0)), plg.findIntersections(ray), "Wrong intersection with plane - in vertex");
        assertNull(tr.findIntersections(ray), "Bad intersection");

        // TC02: On edge
        ray = new Ray(new Point(0, 0, 0), new Vector(1, 1, 0));
        assertEquals(List.of(new Point(0.5, 0.5, 0)), plg.findIntersections(ray), "Wrong intersection with plane - on edge");
        assertNull(tr.findIntersections(ray), "Bad intersection");

        // TC03: On edge continuation
        ray = new Ray(new Point(-1, -1.5, 0), new Vector(1, 0, 0));
        assertEquals(List.of(new Point(2.5, -1.5, 0)), plg.findIntersections(ray), "Wrong intersection with plane - on edge continuation");
        assertNull(tr.findIntersections(ray), "Bad intersection");

        // ============ Equivalence Partitions Tests ==============
        // TC04: Inside triangle
        ray = new Ray(new Point(0, 0, 0.5), new Vector(1, 1, 0));
        assertEquals(List.of(new Point(0.25, 0.25, 0.5)), plg.findIntersections(ray), "Wrong intersection with plane - inside triangle");

        // TC05: Outside triangle - against edge
        ray = new Ray(new Point(0, 0, -1), new Vector(1, 1, 0));
        assertEquals(List.of(new Point(1, 1, -1)), plg.findIntersections(ray), "Wrong intersection with plane - against edge");
        assertNull(tr.findIntersections(ray), "Bad intersection");

        // TC06: Outside triangle - against vertex
        ray = new Ray(new Point(0, 0, 2), new Vector(-1, -1, 0));
        assertEquals(List.of(new Point(-0.5, -0.5, 2)), plg.findIntersections(ray), "Wrong intersection with plane - against vertex");
        assertNull(tr.findIntersections(ray), "Bad intersection");
    }


    /**
     * Test method for {@link geometries.Triangle#findGeoIntersections(Ray, double)}.
     * Tests the findGeoIntersections method of the Triangle class with maximum distance.
     */
    @Test
    public void testMaxDistance() {
        Polygon pol = new Polygon(new Point(0, 0, 1), new Point(2, 0, 1), new Point(2, 2, 1), new Point(0, 2, 1));
        Plane pl = new Plane(new Point(0, 0, 1), new Point(1, 0, 1), new Point(0, 1, 1));
        Ray ray;

        // =============== Equivalence Partitions Tests ==============
        // TC01: The distance is 0
        ray = new Ray(new Point(0, 0, 0.5), new Vector(1, 1, 0));
        assertNull(plg.findGeoIntersections(ray, 0), "The max distance is wrong");

        // TC02: The distance is greater than 0
        assertEquals(1, plg.findGeoIntersections(ray, 10).size(), "The max distance is wrong");
    }
}
