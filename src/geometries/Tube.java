package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

public class Tube extends RadialGeometry{

    final protected Ray axis;

    public Tube(double radius, Ray a) {
        super(radius);
        axis = a;
    }

    @Override
    public Vector getNormal(Point point) {
        return null;
    }
}
