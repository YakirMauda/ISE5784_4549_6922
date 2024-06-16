package primitives;

import java.util.List;

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
     * Returns the direction vector of the ray.
     *
     * @return The direction vector of the ray.
     */
    public Vector getDirection() {
        return direction;
    }

    /**
     * Returns a point on the ray at a given distance from the starting point.
     * The point is computed as the starting point plus the direction vector
     * scaled by the distance.
     *
     * @param t The distance from the starting point along the direction vector.
     * @return The point on the ray at the given distance.
     */
    public Point getPoint(double t) {
        if (isZero(t))
            return head;

        return head.add(direction.scale(t));
    }



    /**
     * Finds the closest point to the ray's head from a list of points.
     * If the list is empty or null, returns null.
     *
     * @param lst The list of points to search through.
     * @return The closest point to the ray's head, or null if the list is empty or null.
     */
    public Point findClosestPoint(List<Point> lst) {
        if (lst == null)
            return null;

        Point closestPoint = null;
        double closestDistance = Double.POSITIVE_INFINITY;

        for (Point point : lst) {
            double distance = head.distanceSquared(point); //מקווה שעובד
            if (distance < closestDistance) {
                closestPoint = point;
                closestDistance = distance;
            }
        }

        return closestPoint;
    }
}
