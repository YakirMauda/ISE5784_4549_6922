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

    /** Delta value for accuracy when comparing the numbers of type 'double' in assertEquals */
    private final double DELTA = 0.000001;

    /** Points for testing */
    private final Point p001 = new Point(0, 0, 1);
    private final Point p010 = new Point(0, 1, 0);
    private final Point p100 = new Point(1, 0, 0);

    /** A triangle used in some tests */
    private final Triangle tr    = new Triangle(p001, p100, p010);

    /** Triangle instance for testing */
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

    /** Test method for
     * {@link geometries.Triangle#findIntersections(primitives.Ray)}. */
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

        // TC04: Outside triangle - against edge
        ray = new Ray(new Point(0, 0, -1), new Vector(1, 1, 0));
        assertEquals(List.of(new Point(1, 1, -1)), plg.findIntersections(ray), "Wrong intersection with plane - against edge");
        assertNull(tr.findIntersections(ray), "Bad intersection");

        // TC05: Outside triangle - against vertex
        ray = new Ray(new Point(0, 0, 2), new Vector(-1, -1, 0));
        assertEquals(List.of(new Point(-0.5, -0.5, 2)), plg.findIntersections(ray), "Wrong intersection with plane - against vertex");
        assertNull(tr.findIntersections(ray), "Bad intersection");

        //בניהההההההההההההההההההההההה
        assertEquals(List.of(new Point(5.53, 1.68, 0)), new Triangle(new Point(8, -1, 0), new Point(8, 1.5, 1), new Point(2, 3, -1)).findIntersections(new Ray(new Point(0.5, 0, 0), new Vector(7, 2, 0))), "Bad intersection");
    }
}
