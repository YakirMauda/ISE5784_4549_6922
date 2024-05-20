package geometries;

import primitives.Point;
import primitives.Vector;

/**
 * Represents a plane in three-dimensional space.
 */
public class Plane implements Geometry {

    private final Point q;
    private final Vector normal;

    /**
     * Constructs a plane from three non-collinear points.
     *
     * @param a The first point.
     * @param b The second point.
     * @param c The third point.
     */
    public Plane(Point a, Point b, Point c) {
        q = a;
        Vector v1 = b.subtract(a);
        Vector v2 = c.subtract(a);
        normal = v1.crossProduct(v2).normalize();
    }

    /**
     * Constructs a plane from a point on the plane and its normal vector.
     *
     * @param a The point on the plane.
     * @param n The normal vector to the plane.
     */
    public Plane(Point a, Vector n) {
        q = a;
        normal = n.normalize();
    }

    /**
     * Retrieves the normal vector of the plane.
     *
     * @return The normal vector of the plane.
     */
    public Vector getNormal() {
        return normal;}

    @Override
    public Vector getNormal(Point point) {
        return normal; }
}
