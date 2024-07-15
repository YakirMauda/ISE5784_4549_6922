package primitives;

import geometries.Intersectable;
import geometries.Intersectable.GeoPoint;

import java.util.List;

import static primitives.Util.isZero;

/**
 * Represents a ray in three-dimensional (3D) space.
 * A ray is defined by a starting point and a direction vector.
 * This class encapsulates the starting point and direction of a ray.
 * Instances of this class are immutable.
 */
public class Ray {

    private static final double DELTA = 0.1;
    final private Point head;
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

    /**
     * Constructs a new Ray with the specified starting point, direction vector, and surface normal.
     * Adjusts the starting point slightly to avoid self-intersection issues.
     *
     * @param point   The starting point of the ray.
     * @param vector  The direction vector of the ray.
     * @param normal  The normal vector of the surface the ray intersects.
     */
    public Ray(Point point, Vector vector, Vector normal) {
        double nv = normal.dotProduct(vector);
        if (!isZero(nv)) {
            head = point.add(normal.scale(nv > 0 ? DELTA : -DELTA));
        } else {
            head = point;
        }
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
     * Returns the starting point of the ray.
     *
     * @return The starting point of the ray.
     */
    public Point getHead() {
        return head;
    }

    /**
     * Computes a point on the ray at a given distance from the starting point.
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
     * Finds the closest Point to the ray's head from a list of points.
     *
     * @param points The list of points to search through.
     * @return The closest point to the ray's head, or null if the list is empty or null.
     */
    public Point findClosestPoint(List<Point> points) {
        return points == null || points.isEmpty() ? null
                : findClosestGeoPoint(points.stream()
                .map(p -> new GeoPoint(null, p))
                .toList()).point;
    }

    /**
     * Finds the closest GeoPoint to the ray's head from a list of GeoPoints.
     *
     * @param geoPoints The list of GeoPoints to search through.
     * @return The closest GeoPoint to the ray's head, or null if the list is empty or null.
     */
    public GeoPoint findClosestGeoPoint(List<GeoPoint> geoPoints) {
        if (geoPoints == null || geoPoints.isEmpty()) {
            return null;
        }

        GeoPoint closestPoint = null;
        double closestDistance = Double.POSITIVE_INFINITY;

        for (GeoPoint geoPoint : geoPoints) {
            double distance = head.distanceSquared(geoPoint.point);
            if (distance < closestDistance) {
                closestPoint = geoPoint;
                closestDistance = distance;
            }
        }
        return closestPoint;
    }
}
