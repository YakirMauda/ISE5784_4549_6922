package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link Triangle} class.
 */
class TriangleTests {

    /** Delta value for accuracy when comparing the numbers of type 'double' in assertEquals */
    private final double DELTA = 0.000001;

    /** Triangle instance for testing */
    private final Triangle tr = new Triangle(new Point(0, 0, 1), new Point(1, 0, 0), new Point(0, 1, 0));

    /** Points for testing */
    private final Point p001 = new Point(0, 0, 1);
    private final Point p010 = new Point(0, 1, 0);
    private final Point p100 = new Point(1, 0, 0);

    /**
     * Test method for {@link geometries.Triangle#getNormal(Point)}.
     * Tests the getNormal method of the Triangle class.
     */
    @Test
    void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: There is a simple single test here
        Vector n = tr.getNormal(p001);
        assertEquals(1, n.length(), DELTA, "Bad normal length");
        assertEquals(0, p001.subtract(p010).dotProduct(n), DELTA, "Normal isn't orthogonal to triangle");
        assertEquals(0, p001.subtract(p100).dotProduct(n), DELTA, "Normal isn't orthogonal to triangle");
    }
}
