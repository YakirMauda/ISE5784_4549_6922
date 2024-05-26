package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link Sphere} class.
 */
class SphereTests {

    /**
     * Test method for {@link geometries.Sphere#getNormal(Point)}.
     * Tests the getNormal method of the Sphere class.
     */
    @Test
    void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: There is a simple single test here
        Sphere sphere = new Sphere(new Point(0, 0, 1), 1d);
        assertEquals(new Vector(0, 0, 1), sphere.getNormal(new Point(0, 0, 2)), "Bad normal to sphere");
    }
}
