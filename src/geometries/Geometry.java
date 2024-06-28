package geometries;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

/**
 * Represents a geometric shape in three-dimensional space.
 */
public  abstract class Geometry extends Intersectable{

    /**
     * The emission color of the geometry.
     */
    private Color emission = Color.BLACK;

    /**
     * Computes the normal vector to the geometry at a given point.
     *
     * @param point The point at which to compute the normal vector.
     * @return The normal vector to the geometry at the specified point.
     */
    public abstract Vector getNormal(Point point);

   public Color getEmission() {
        return emission;
    }

    public Geometry setEmission(Color emission) {
        this.emission = emission;
        return this;
    }
}