package geometries;

/**
 * Abstract class representing a radial geometry in three-dimensional space.
 */
public abstract class RadialGeometry extends Geometry {

    /** The radius of the radial geometry. */
    protected final double radius;

    /**
     * Constructs a radial geometry with a specified radius.
     *
     * @param myRadius The radius of the radial geometry.
     */
    public RadialGeometry(double myRadius) {
        radius = myRadius;
    }
}
