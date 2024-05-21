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
        // Check if the point is exactly at the start of the axis (the base point)
        if (point.equals(axis.getPoint(0))) {
            // If so, return the direction of the axis as the normal vector
            return axis.getDirection().scale(1);
        }

        // Check if the point lies on the plane that includes the base point and is perpendicular to the axis
        if (point.subtract(axis.getPoint(0)).dotProduct(axis.getDirection()) == 0) {
            // If so, return the direction of the axis as the normal vector
            return axis.getDirection().scale(1);
        }

        // Check if the point is exactly at the end of the axis (the top point)
        if (point.equals(axis.getPoint(height))) {
            // If so, return the direction of the axis as the normal vector
            return axis.getDirection().scale(1);
        }

        // Check if the point lies on the plane that includes the top point and is perpendicular to the axis
        if (point.subtract(axis.getPoint(height)).dotProduct(axis.getDirection()) == 0) {
            // If so, return the direction of the axis as the normal vector
            return axis.getDirection().scale(1);
        }

        // For all other points, use the superclass method to calculate the normal
        return super.getNormal(point);
    }
}
