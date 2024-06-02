package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GeometriesTests {

    @Test
    void testAdd() {
    }

    @Test
    void testFindIntersections() {
        List<Point> testing;
        Geometries geometries = new Geometries(
                new Plane(new Point(1, 0, 0), new Point(1, 1, 0), new Point(2, 0, 1)),
                new Sphere(new Point(7, 0, 0), 2),
                new Triangle(new Point(8, -1, 0), new Point(8, 1.5, 1), new Point(2, 3, -1))
        );


        // ============ Boundary Values Tests ==============
        // TC01: Empty collection
        assertNull(new Geometries().findIntersections(new Ray(new Point(0, 0, 3), new Vector(1, 7, 2))), "Empty collection");

        // TC02: None of the geometries is intersected
        assertNull(geometries.findIntersections(new Ray(new Point(0, 0, 5), new Vector(7, 7, 15))), "None of the geometries is intersected");

        // TC03: Only one of the geometries is intersected
        assertEquals(1, geometries.findIntersections(new Ray(new Point(2, 0, 0), new Vector(0, 0, 1))).size(), "Only one of the geometries is intersected");

        // TC04: All of the geometries are intersected
        assertEquals(3, geometries.findIntersections(new Ray(new Point(0.5, 0, 0), new Vector(6, 1, 0))).size(), "All of the geometries are intersected");

        // ============ Equivalence Partitions Tests ==============
        // TC05: Some of the geometries are intersected
        assertEquals(2, geometries.findIntersections(new Ray(new Point(0.5, 0, 0), new Vector(6, -1, 0))).size(), "Some of the geometries are intersected");
    }
}