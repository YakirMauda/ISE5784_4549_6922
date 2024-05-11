package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

/**
 * Represents a cylinder in three-dimensional space.
 */
public class Cylinder extends Tube {

    final private double height;

    /**
     * Constructs a cylinder with a specified radius, axis, and height.
     *
     * @param radius The radius of the cylinder.
     * @param axis   The axis of the cylinder.
     * @param h      The height of the cylinder.
     */
    public Cylinder(double radius, Ray axis, double h) {
        super(radius, axis);
        height = h;
    }

    @Override
    public Vector getNormal(Point point) {
        return super.getNormal(point);
    }
}
