package geometries;

import primitives.Point;
import primitives.Vector;

public class Plane implements Geometry {
    private final Point q;
    private final Vector normal;

    public Plane(Point a, Point b, Point c) {
        normal = null;  //שלב  הבא
        q = a;  //עזריאל
    }

    public Plane(Point a, Vector n) {
        q = a;
        normal = n.normalize();
    }

    public Vector getNormal() {
        return normal;
    }

    @Override
    public Vector getNormal(Point point) {
        return null; //????????
    }
}
