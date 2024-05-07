package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

public class Cylinder extends Tube{

    final private double height;

    public Cylinder(double radius, Ray a, double h) {
        super(radius, a);
        height = h;
    }

    @Override
    public Vector getNormal(Point point) {
        return super.getNormal(point);
    }
}
