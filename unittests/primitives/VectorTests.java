package primitives;

import geometries.Polygon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorTests {
    Vector v1 = new Vector(1,2,3);
    private final double DELTA = 0.000001;


    /**
     *  // Test Vector operations ===============================================
     *
     *     try {
     *      *          v1.add(v1Opposite);
     *      *          out.println("ERROR: Vector + -itself does not throw an exception");
     *      *       } catch (IllegalArgumentException ignore) {} catch (Exception ignore) {
     *      *          out.println("ERROR: Vector + itself throws wrong exception");
     *      *       }
     *
     *
     *
     *
     *
     *
     *       // test length
     *       if (!isZero(v4.lengthSquared() - 9))
     *          out.println("ERROR: lengthSquared() wrong value");  //מאור
     *       if (!isZero(v4.length() - 3))
     *          out.println("ERROR: length() wrong value");      //מאור
     *
     *
     *       // Test add & subtract
     *
     *       try {
     *          v1.subtract(v1);
     *          out.println("ERROR: Vector - itself does not throw an exception");
     *       } catch (IllegalArgumentException ignore) {} catch (Exception ignore) {
     *          out.println("ERROR: Vector + itself throws wrong exception");
     *       }
     *       if (!v1.add(v2).equals(v1Opposite))
     *          out.println("ERROR: Vector + Vector does not work correctly");
     *       if (!v1.subtract(v2).equals(new Vector(3, 6, 9)))
     *          out.println("ERROR: Vector + Vector does not work correctly");
     *
     *       // test Dot-Product
     *       if (!isZero(v1.dotProduct(v3)))
     *          out.println("ERROR: dotProduct() for orthogonal vectors is not zero");
     *       if (!isZero(v1.dotProduct(v2) + 28))
     *          out.println("ERROR: dotProduct() wrong value");
     *
     *
     *       Vector v1         = new Vector(1, 2, 3);
     *       Vector v1Opposite = new Vector(-1, -2, -3);
     *       Vector v2         = new Vector(-2, -4, -6);
     *       Vector v3         = new Vector(0, 3, -2);
     *       Vector v4         = new Vector(1, 2, 2);
     *
     *       // test Cross-Product
     *       try { // test zero vector
     *          v1.crossProduct(v2);
     *          out.println("ERROR: crossProduct() for parallel vectors does not throw an exception");
     *       } catch (Exception e) {}
     *       Vector vr = v1.crossProduct(v3);
     *       if (!isZero(vr.length() - v1.length() * v3.length()))
     *          out.println("ERROR: crossProduct() wrong result length");
     *       if (!isZero(vr.dotProduct(v1)) || !isZero(vr.dotProduct(v3)))
     *          out.println("ERROR: crossProduct() result is not orthogonal to its operands");
     *
     *       // test vector normalization vs vector length and cross-product
     *       Vector v = new Vector(1, 2, 3);
     *       Vector u = v.normalize();
     *       if (!isZero(u.length() - 1))
     *          out.println("ERROR: the normalized vector is not a unit vector");
     *       try { // test that the vectors are co-lined
     *          v.crossProduct(u);
     *          out.println("ERROR: the normalized vector is not parallel to the original one");
     *       } catch (Exception e) {}
     *       if (v.dotProduct(u) < 0)
     *          out.println("ERROR: the normalized vector is opposite to the original one");
     *
     *       out.println("If there were no any other outputs - all tests succeeded!");
     *    }
     * }
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
        assertNotEquals(v1, new Vector(4,4,4), "The vector is equal to a vector with different x, y, and z");
    }


    @Test
    void lengthSquared() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: Simple vector
        assertEquals(v1.lengthSquared(), 14, "The lengthSquared is wrong");
    }

    @Test
    void length() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: Simple vector
        assertEquals(v1.length(), Math.sqrt(14), "The length is wrong");
    }

    @Test
    void add() {
        // =============== Boundary Values Tests =================
        // TC01: Add the same vector
        assertEquals(v1.add(v1), new Vector (2, 4, 6), "The vector is not equal to the expected vector");

        // ============ Equivalence Partitions Tests ==============
        // TC02: Add a vector with negative values
        assertThrows(IllegalArgumentException.class, () -> v1.add(new Vector(-1, -2, -3)),"ERROR: Vector + -itself does not throw an exception");
        // TC03: Add a vector with different values
        assertEquals(v1.add(new Vector(2, 3, 4)), new Vector(3, 5, 7), "The vector is not equal to the expected vector");
    }

    @Test
    void scale() {
        // =============== Boundary Values Tests =================
        // TC01: Scale with 0
        assertThrows(IllegalArgumentException.class, () -> v1.scale(0.0), "ERROR: Vector scale with 0 does not throw an exception");

        // ============ Equivalence Partitions Tests ==============
        // TC02: Scale with ordinary number
        assertEquals(v1.scale(2.0), new Vector(2,4,6), "ERROR: scale function does not good");
    }

    @Test
    void dotProduct() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: dotProduct with ordinary vector
        assertEquals(v1.dotProduct(new Vector(2,0,1)), 5, "ERROR: dotProduct function does not good");
    }

    @Test
    void crossProduct() {
        Vector v2 = new Vector(0,3,-2);
        // =============== Boundary Values Tests =================
        // TC01: crossProduct with parallel vector
        assertThrows(IllegalArgumentException.class, () -> v1.crossProduct(new Vector(-1, -2, -3)), "ERROR: crossProduct() for parallel vectors does not throw an exception");
        // TC02: crossProduct with orthogonal vector
        assertEquals(v1.crossProduct(v2), new Vector(-13, 2, 3), "ERROR: crossProduct() for orthogonal vectors has wrong result");

        // ============ Equivalence Partitions Tests ==============
        // TC03: crossProduct with vectors - checks length
        assertEquals(v1.crossProduct(v2).length(), v1.length() * v2.length(), DELTA,"ERROR: crossProduct() wrong result length");
    }

    @Test
    void normalize() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: normalize with ordinary vector
        assertEquals(v1.normalize(), new Vector(1 / Math.sqrt(14), 2 / Math.sqrt(14), 3 / Math.sqrt(14)), "ERROR: normalize function does not good");
    }
}