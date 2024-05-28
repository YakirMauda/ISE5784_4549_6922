package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link Sphere} class.
 */
class SphereTests {
    private final Point p001 = new Point(0, 0, 1);
    private final Point p100 = new Point(1, 0, 0);
    private final Vector v001 = new Vector(0, 0, 1);

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


    /**
     * Test method for {@link geometries.Plane#findIntersections(Ray)}.
     * Tests the findIntersections method of the Plane class.
     */
    @Test
    void testFindIntersections(){

        Sphere sphere = new Sphere(p100, 1d);


        final Point p110 = new Point(1, 1, 0);
        /**
        final Point gp1 = new Point(0.0651530771650466, 0.355051025721682, 0);
        final Point gp2 = new Point(1.53484692283495, 0.844948974278318, 0);
        final var exp = List.of(gp1, gp2);
        final Vector v310 = new Vector(3, 1, 0);
        final Vector v110 = new Vector(1, 1, 0);
        final Point p01 = new Point(-1, 0, 0);
        // ============ Equivalence Partitions Tests ==============
        // TC01: Ray's line is outside the sphere (0 points)
        assertNull(sphere.findIntersections(new Ray(p01, v110)), "Ray's line out of sphere");
        // TC02: Ray starts before and crosses the sphere (2 points)
        var result1 = sphere.findIntersections(new Ray(p01, v310))
                .stream()
                .sorted(Comparator.comparingDouble(p -> p.distance(p01)))
                .toList();

        assertEquals(2, result1.size(), "Wrong number of points");
        assertEquals(exp, result1, "Ray crosses sphere");
*/




        // ============ Boundary Values Tests ==============
        //Group: Special cases
        // TC01: Ray's line is outside the sphere (0 points)
        assertNull(sphere.findIntersections(new Ray(new Point(-1, 0, 0), new Vector(0, 0, 1))), "Ray is orthogonal to the line from the ray's head to the sphere's center");


        //Group: Ray's line crosses the sphere (but not the center)
        // TC02: Ray starts at sphere and goes inside (1 point)
        assertEquals(List.of(new Point(2, 0, 0)), sphere.findIntersections(new Ray(new Point(1, -1, 0), new Vector(1, 1, 0))),"Ray starts from sphere inside)");
        // TC03: Ray starts at sphere and goes outside (0 points)
        assertNull(sphere.findIntersections(new Ray(new Point(2, 0, 0), new Vector(1, 1, 0))),"Ray starts from sphere outside");


        //Group: Ray's line goes through the center
        final var l110 = List.of(p110);


        // TC13: Ray starts before the sphere (2 points)
        final var result2 = sphere.findIntersections(new Ray(new Point(1, -2, 0), new Vector(0, 1, 0)))
                // Sorting the intersection points by their distance from the ray's starting point
                .stream().sorted(Comparator.comparingDouble(p -> p.distance(new Point(1, -2, 0)))).toList();

        assertEquals(2, result2.size(), "Wrong number of points");

        // Checking that the intersection points are (1, -1, 0) and (1, 1, 0)
        assertEquals(List.of(new Point(1, -1, 0), new Point(1, 1, 0)), result2, "Line through O, ray crosses sphere");

        // TC14: Ray starts at sphere and goes inside (1 points)
        assertEquals(l110, sphere.findIntersections(new Ray(new Point(1, -1, 0), new Vector(0, 1, 0))),
                "Ray originates at sphere's edge, passing through the center");
        // TC15: Ray starts inside (1 points)
        // TC16: Ray starts at the center (1 points)
        // TC17: Ray starts at sphere and goes outside (0 points)
        // TC18: Ray starts after sphere (0 points)




        // **** Group: Ray's line is tangent to the sphere (all tests 0 points)
        // TC19: Ray starts before the tangent point
        // TC20: Ray starts at the tangent point
        // TC21: Ray starts after the tangent point







    }
}
