package primitives;

import static primitives.Util.isZero;

/**
 * Represents a ray in three-dimensional (3D) space.
 * A ray is defined by a starting point and a direction vector.
 * This class encapsulates the starting point and direction of a ray.
 * Instances of this class are immutable.
 */
public class Ray {

    /** The starting point of the ray. */
    final private Point head;

    /** The direction vector of the ray. */
    final private Vector direction;

    /**
     * Constructs a new Ray with the specified starting point and direction vector.
     * The direction vector is normalized.
     *
     * @param point   The starting point of the ray.
     * @param vector  The direction vector of the ray.
     * @throws NullPointerException if {@code point} or {@code vector} is null.
     */
    public Ray(Point point, Vector vector) {
        if (point == null || vector == null) {
            throw new NullPointerException("Point and vector must not be null");
        }
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

    /**
     * Returns the starting point of the ray.
     *
     * @return The starting point of the ray.
     */
    public Point getHead() {
        return head;
    }

    /**
     * Returns the direction vector of the ray.
     *
     * @return The direction vector of the ray.
     */
    public Vector getDirection() {
        return direction;
    }

    /**
     * Returns a point on the ray at a distance {@code t} from the starting point.
     * The point is calculated as {@code head + t * direction}.
     *
     * @param t  The distance from the starting point along the ray.
     * @return The point on the ray at distance {@code t}.
     * @throws IllegalArgumentException if {@code t} is zero.
     */
    public Point getPoint(double t) {
        if (isZero(t))
            throw new IllegalArgumentException("Distance t must not be zero");

        return head.add(direction.scale(t));
    }
}
