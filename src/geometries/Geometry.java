package geometries;

import primitives.Point;
import primitives.Vector;

/**
 * Represents a geometric shape in three-dimensional space.
 */
public interface Geometry extends Intersectable{

    /**
     * Computes the normal vector to the geometry at a given point.
     *
     * @param point The point at which to compute the normal vector.
     * @return The normal vector to the geometry at the specified point.
     */
    public Vector getNormal(Point point);
}