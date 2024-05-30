package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link Tube} class.
 */
class TubeTests {

    /** Unit vector in the direction of the x-axis */
    private final Vector v100 = new Vector(1, 0, 0);
    /** Unit vector in the direction of the y-axis */
    private final Vector v010 = new Vector(0, 1, 0);
    /** Unit vector in the direction of the z-axis */
    private final Vector v001 = new Vector(0, 0, 1);

    /**
     * Test method for {@link geometries.Tube#getNormal(Point)}.
     * Tests the getNormal method of the Tube class.
     */
    @Test
    void testGetNormal() {
        Tube tube = new Tube(1, new Ray(new Point(0, 0, 1), v010));

        // ============ Equivalence Partitions Tests ==============
        // TC01: There is a simple single test here
        assertEquals(v001, tube.getNormal(new Point(0, 0.5, 2)), "Bad normal to tube");

        // =============== Boundary Values Tests =================
        // TC02: The point is on the tube's surface in line with the axis start point
        assertEquals(v100, tube.getNormal(new Point(1,0,1)),
                "Bad normal to tube - point on tube's surface in line with the axis start point");
    }


    /**
     * Test method for {@link geometries.Plane#findIntersections(Ray)}.
     * Tests the findIntersections method of the Plane class.
     */
    @Test
    void findIntersections(){}
}
