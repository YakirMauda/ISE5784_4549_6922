package primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Vector class.
 */
class VectorTests {

    private final Vector v1 = new Vector(1, 2, 3);
    private final Vector v2 = new Vector(0, 3, -2);

    /** Delta value for accuracy when comparing the numbers of type 'double' in assertEquals */
    private final double DELTA = 0.000001;

    /**
     * Test method for {@link primitives.Vector#equals(Object)}.
     */
    @Test
    void testEquals() {
        // =============== Boundary Values Tests =================
        // TC01: The same vector
        assertTrue(v1.equals(v1), "The same vector is not equal to itself");

        // TC02: Different points
        assertNotEquals(v1, new Vector(0, 0, 1), "Different points are equal");

        // ============ Equivalence Partitions Tests ==============
        // TC03: null
        assertNotEquals(v1, null, "The vector is equal to null");

        // TC04: Different x
        assertNotEquals(v1, new Point(0, 2, 3), "The vector is equal to a vector with different x");

        // TC05: Different y
        assertNotEquals(v1, new Point(1, 0, 3), "The vector is equal to a vector with different y");

        // TC06: Different z
        assertNotEquals(v1, new Point(1, 2, 0), "The vector is equal to a vector with different z");

        // TC07: Different x, y, and z
        assertNotEquals(v1, new Vector(4, 4, 4), "The vector is equal to a vector with different x, y, and z");
    }

    /**
     * Test method for {@link primitives.Vector#lengthSquared()}.
     */
    @Test
    void lengthSquared() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: Simple vector
        assertEquals(v1.lengthSquared(), 14, "The lengthSquared is wrong");
    }

    /**
     * Test method for {@link primitives.Vector#length()}.
     */
    @Test
    void length() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: Simple vector
        assertEquals(v1.length(), Math.sqrt(14), "The length is wrong");
    }

    /**
     * Test method for {@link primitives.Vector#add(primitives.Vector)}.
     */
    @Test
    void add() {
        // =============== Boundary Values Tests =================
        // TC01: Add the same vector
        assertEquals(v1.add(v1), new Vector(2, 4, 6), "The vector is not equal to the expected vector");

        // ============ Equivalence Partitions Tests ==============
        // TC02: Add a vector with negative values
        assertThrows(IllegalArgumentException.class, () -> v1.add(new Vector(-1, -2, -3)), "ERROR: Vector + -itself does not throw an exception");

        // TC03: Add a vector with different values
        assertEquals(v1.add(new Vector(2, 3, 4)), new Vector(3, 5, 7), "The vector is not equal to the expected vector");
    }

    /**
     * Test method for {@link primitives.Vector#subtract(primitives.Vector)}.
     */
    @Test
    void testSubtractVector() {
        // =============== Boundary Values Tests =================
        // TC01: Subtracting the same vector
        assertThrows(IllegalArgumentException.class, () -> v1.subtract(v1), "vector - itself needs to throw an exception");

        // ============ Equivalence Partitions Tests ==============
        // TC02: Ordinary vectors
        assertEquals(v1.subtract(v2), new Vector(1, -1, 5), "Wrong subtraction in vectors");
    }

    /**
     * Test method for {@link primitives.Vector#scale(double)}.
     */
    @Test
    void scale() {
        // =============== Boundary Values Tests =================
        // TC01: Scale with 0
        assertThrows(IllegalArgumentException.class, () -> v1.scale(0.0), "ERROR: Vector scale with 0 does not throw an exception");

        // ============ Equivalence Partitions Tests ==============
        // TC02: Scale with ordinary number
        assertEquals(v1.scale(2.0), new Vector(2, 4, 6), "ERROR: scale function does not work properly");
    }

    /**
     * Test method for {@link primitives.Vector#dotProduct(primitives.Vector)}.
     */
    @Test
    void dotProduct() {
        // =============== Boundary Values Tests =================
        // TC01: Dot product with orthogonal vector
        assertEquals(v1.dotProduct(v2), 0, "ERROR: dotProduct function does not work correctly with orthogonal vectors");

        // ============ Equivalence Partitions Tests ==============
        // TC02: Dot product with ordinary vector
        assertEquals(v1.dotProduct(new Vector(2, 0, 1)), 5, "ERROR: dotProduct function does not work properly");
    }

    /**
     * Test method for {@link primitives.Vector#crossProduct(primitives.Vector)}.
     */
    @Test
    void crossProduct() {
        // =============== Boundary Values Tests =================
        // TC01: Cross product with parallel vector
        assertThrows(IllegalArgumentException.class, () -> v1.crossProduct(new Vector(-1, -2, -3)), "ERROR: crossProduct() for parallel vectors does not throw an exception");

        // TC02: Cross product with orthogonal vector
        assertEquals(v1.crossProduct(v2), new Vector(-13, 2, 3), "ERROR: crossProduct() for orthogonal vectors has the wrong result");

        // ============ Equivalence Partitions Tests ==============
        // TC03: Cross product with vectors - checks length
        assertEquals(v1.crossProduct(v2).length(), v1.length() * v2.length(), DELTA, "ERROR: crossProduct() wrong result length");
    }

    /**
     * Test method for {@link primitives.Vector#normalize()}.
     */
    @Test
    void normalize() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: Normalize with ordinary vector
        assertEquals(v1.normalize().length(), 1d, "ERROR: normalize function does not work properly");

        // TC02: Normalize with ordinary vector and then check if parallel
        assertThrows(IllegalArgumentException.class, () -> v1.crossProduct(v1.normalize()), "ERROR: the normalized vector is not parallel to the original one");
    }
}
