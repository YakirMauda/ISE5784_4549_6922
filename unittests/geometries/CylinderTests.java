package geometries;

import org.junit.jupiter.api.Test;
import primitives.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the {@link Cylinder} class.
 */
class CylinderTests {

    private final Cylinder cyl = new Cylinder(1.0, new Ray(new Point(0, 0, 1), new Vector(0, 1, 0)), 1d);
    private final Vector v010 = new Vector(0, 1, 0);
    private final Vector v001 = new Vector(0, 0, 1);

    /**
     * Test method for {@link geometries.Cylinder#getNormal(Point)}.
     * Tests the getNormal method of the Cylinder class.
     */
    @Test
    void testGetNormal() {
        // =============== Boundary Values Tests ==================
        // TC01: Point at the center of 1st base
        assertEquals(v010, cyl.getNormal(new Point(0, 0, 1)), "Bad normal to center of lower base");
        // TC02: Point at the center of 2nd base
        assertEquals(v010, cyl.getNormal(new Point(0, 1, 1)), "Bad normal to center of upper base");
        // TC03: Point at the edge with 1st base
        assertEquals(v010, cyl.getNormal(new Point(0, 0, 2)), "Bad normal to edge with lower base");
        // TC04: Point at the edge with 2nd base
        assertEquals(v010, cyl.getNormal(new Point(0, 1, 2)), "Bad normal to edge with upper base");

        // ============ Equivalence Partitions Tests ==============
        // TC05: Point at a side of the cylinder
        assertEquals(v001, cyl.getNormal(new Point(0, 0.5, 2)), "Bad normal to cylinder");
        // TC06: Point at a 1st base of the cylinder
        assertEquals(v010, cyl.getNormal(new Point(0, 0, 1.5)), "Bad normal to lower base of cylinder");
        // TC07: Point at a 2nd base of the cylinder
        assertEquals(v010, cyl.getNormal(new Point(0, 1, 0.5)), "Bad normal to upper base of cylinder");
    }


    /**
     * Test method for {@link geometries.Plane#findIntersections(Ray)}.
     * Tests the findIntersections method of the Plane class.
     */
    @Test
    void findIntersections(){}


}
