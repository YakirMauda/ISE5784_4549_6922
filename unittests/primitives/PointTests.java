package primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTests {
    Point p1 = new Point(1, 2, 3);

    @Test
    void testEquals() {
        // =============== Boundary Values Tests =================
        // TC01: The same point
        assertTrue(p1.equals(p1), "The same point is not equal to itself");
        // TC02: Zero point
        assertNotEquals(p1, new Point(0, 0, 0), "Different points are equal");

        // ============ Equivalence Partitions Tests ==============
        // TC03: null
        assertNotEquals(p1, null, "The point is equal to null");
        // TC04: Different type
        assertEquals(p1, new Vector(1, 2, 3), "The point is equal to a vector");
        // TC05: Different x
        assertNotEquals(p1, new Point(2, 2, 3), "The point is equal to a point with different x");
        // TC06: Different y
        assertNotEquals(p1, new Point(1, 1, 3), "The point is equal to a point with different y");
        // TC07: Different z
        assertNotEquals(p1, new Point(1, 2, 4), "The point is equal to a point with different z");
        // TC08: Different x, y, and z
        assertNotEquals(p1, Point.ZERO, "The point is equal to a point with different x, y, and z");
    }

    @Test
    void add() {
        // =============== Boundary Values Tests =================
        // TC01: Add the same vector
        assertEquals(p1.add(new Vector(1, 2, 3)), new Point (2, 4, 6), "The point is not equal to the expected point");

        // ============ Equivalence Partitions Tests ==============
        // TC02: Add a vector with negative values
        assertEquals(p1.add(new Vector(-1, -2, -3)), Point.ZERO, "The point is not equal to the expected point");
        // TC03: Add a vector with different values
        assertEquals(p1.add(new Vector(2, 3, 4)), new Point(3, 5, 7), "The point is not equal to the expected point");
    }


    @Test
    void subtract() {
        // =============== Boundary Values Tests =================
        // TC01: Subtract the zero point
        assertEquals(p1.subtract(Point.ZERO), new Vector(1, 2, 3), "The vector is not equal to the expected vector");
        // TC02: Subtract the same point
        assertThrows(IllegalArgumentException.class, () -> p1.subtract(p1),"ERROR: (point - itself) does not throw an exception (can't create zero vector)");

        // ============ Equivalence Partitions Tests ==============
        // TC03: Subtract different point
        assertEquals(p1.subtract(new Point(2, 3, 4)), new Vector(-1, -1, -1), "The vector is not equal to the expected vector");
    }

    @Test
    void distance() {
        // =============== Boundary Values Tests =================
        // TC01: The same point
        assertEquals(p1.distance(p1), 0, "The distance is not equal to 0");

        // ============ Equivalence Partitions Tests ==============
        // TC02: Different points
        assertEquals(p1.distance(new Point(1, 1, 1)), Math.sqrt(5), "The distance is not equal to the expected distance");
    }

    @Test
    void distanceSquared() {
        // =============== Boundary Values Tests =================
        // TC01: The same point
        assertEquals(p1.distanceSquared(p1), 0, "The distance squared is not equal to 0");

        // ============ Equivalence Partitions Tests ==============
        // TC02: Different points
        assertEquals(p1.distanceSquared(new Point(1, 1, 1)), 5, "The distance squared is not equal to the expected distance squared");
    }
}