package geometries;

import primitives.Point;
import primitives.Vector;

/**
 * Represents a sphere in three-dimensional space.
 */
public class Sphere extends RadialGeometry {

    final private Point center;

    /**
     * Constructs a sphere with a specified radius and center point.
     *
     * @param radius The radius of the sphere.
     * @param point The center point of the sphere.
     */
    public Sphere(Point point, double radius) {
        super(radius);
        center = point;
    }

    @Override
    public Vector getNormal(Point point) {
        return point.subtract(center).normalize();
    }
}