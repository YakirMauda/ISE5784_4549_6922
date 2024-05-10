package primitives;

/**
 * Represents a ray in three-dimensional (3D) space.
 * A ray is defined by a starting point and a direction vector.
 * This class encapsulates the starting point and direction of a ray.
 * Instances of this class are immutable.
 *
 * @author Yakir Mauda & Benaya Trabelsi
 */
public class Ray {

    /** The starting point of the ray. */
    final private Point head;

    /** The direction vector of the ray. */
    final private Vector direction;

    /**
     * Constructs a new Ray with the specified starting point and direction vector.
     *
     * @param point   The starting point of the ray.
     * @param vector  The direction vector of the ray.
     */
    public Ray(Point point, Vector vector) {
        head = point;
        direction = vector.normalize();
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        return (object instanceof Ray other)
                && head.equals(other.head)
                && direction.equals(other.direction);
    }


    @Override
    public String toString() {
        return "head: " + head + ", direction: " + direction;
    }
}
