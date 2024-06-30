package geometries;

import primitives.Color;
import primitives.Material;
import primitives.Point;
import primitives.Vector;

/**
 * Represents a geometric shape in three-dimensional space.
 */
public abstract class Geometry extends Intersectable{

    /**
     * The emission color of the geometry.
     */
    private Color emission = Color.BLACK;

    private Material material = new Material();

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

    public Material getMaterial() {
        return material;
    }

    public Geometry setMaterial(Material material) {
        this.material = material;
        return this;
    }
}