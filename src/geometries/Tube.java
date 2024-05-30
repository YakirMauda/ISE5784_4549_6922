package geometries;

import primitives.*;

import java.util.List;

import static primitives.Util.*;

/**
 * Represents a tube in a three-dimensional (3D) space.
 * A tube is defined by its radius and an axis - a Ray.
 */
public class Tube extends RadialGeometry {

    /** The axis of the tube. */
    final protected Ray axis;

    /**
     * Constructs a new Tube with the specified radius and axis.
     *
     * @param radius The radius of the tube.
     * @param axis   The axis of the tube.
     */
    public Tube(double radius, Ray axis) {
        super(radius);
        this.axis = axis;
    }

    /**
     * Calculates the normal vector to the tube at a given point.
     *
     * @param point the point on the surface of the tube where the normal is calculated
     * @return the normal vector to the tube at the given point
     */
    @Override
    public Vector getNormal(Point point) {
        double t = point.subtract(axis.getHead()).dotProduct(axis.getDirection());

        if(isZero(t))
            return point.subtract(axis.getHead()).normalize();

        return point.subtract(axis.getPoint(t)).normalize();
    }

    @Override
    public List<Point> findIntersections(Ray ray) {
        return null;
    }
}
