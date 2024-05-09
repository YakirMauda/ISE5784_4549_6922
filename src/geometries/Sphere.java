package geometries;

import primitives.Point;
import primitives.Vector;

public class Sphere extends RadialGeometry{

    final private Point center;

    public Sphere(double radius, Point point) {
        super(radius);
        center = point;
    }

    @Override
    public Vector getNormal(Point point) {
        return null;
    }

}
