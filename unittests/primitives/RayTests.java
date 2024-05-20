package primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class RayTests {
    Ray r0 = new Ray(new Point(1, 2, 3), new Vector(1, 0, 0));

    @Test
    void testEquals() {

        // =============== Boundary Values Tests =================
        // TC01: Ray with the same head and direction vectors
        Ray r1 = new Ray(new Point(1, 2, 3), new Vector(1, 0, 0));
        assertEquals(r0, r1, "ERROR: Ray with the same head and direction vectors does not equal to the original");

        // ============ Equivalence Partitions Tests ==============
        // TC02: Ray with same head and different direction vectors
        Ray r2 = new Ray(new Point(1, 2, 3), new Vector(1, 0, 0));
        assertNotEquals(r1.equals(r2), "ERROR: Ray with same head and different direction vectors equals to the original");
        // TC03: Ray with different head and same direction vectors
        Ray r3 = new Ray(new Point(1, 2, 3), new Vector(1, 0, 0));
        assertNotEquals(r1.equals(r3), "ERROR: Ray with different head and same direction vectors equals to the original");
        // TC04: Ray with negative head and direction vectors
        Ray r4 = new Ray(new Point(-1, -2, -3), new Vector(-1, 0, 0));
        assertNotEquals(r1.equals(r4), "ERROR: Ray with negative head and direction vectors equals to the original");

    }
}