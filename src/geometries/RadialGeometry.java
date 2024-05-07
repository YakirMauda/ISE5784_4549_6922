package geometries;

public abstract class RadialGeometry implements Geometry {
    protected final double radius;

    public RadialGeometry(double myRadius) {
        radius = myRadius;
    }
}
