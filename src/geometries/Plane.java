package geometries;

import primitives.Point;
import primitives.Vector;

public class Plane implements Geometry {
    private final Point q;
    private final Vector normal;

    public Plane(Point a, Point b, Point c) {
        normal = null;
        q = a;
    }
}
