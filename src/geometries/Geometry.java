package geometries;

import primitives.Color;
import primitives.Material;
import primitives.Point;
import primitives.Vector;

/**
 * Represents a geometric shape in three-dimensional space.
 */
public abstract class Geometry extends Intersectable {

    /**
     * The emission color of the geometry.
     */
    private Color emission = Color.BLACK;

    /**
     * The material properties of the geometry.
     */
    private Material material = new Material();

    /**
     * Computes the normal vector to the geometry at a given point.
     *
     * @param point The point at which to compute the normal vector.
     * @return The normal vector to the geometry at the specified point.
     */
    public abstract Vector getNormal(Point point);

    /**
     * Gets the emission color of the geometry.
     *
     * @return The emission color.
     */
    public Color getEmission() {
        return emission;
    }

    /**
     * Sets the emission color of the geometry.
     *
     * @param emission The emission color to set.
     * @return The current geometry instance (for chaining).
     */
    public Geometry setEmission(Color emission) {
        this.emission = emission;
        return this;
    }

    /**
     * Gets the material properties of the geometry.
     *
     * @return The material properties.
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * Sets the material properties of the geometry.
     *
     * @param material The material properties to set.
     * @return The current geometry instance (for chaining).
     */
    public Geometry setMaterial(Material material) {
        this.material = material;
        return this;
    }
}