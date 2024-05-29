package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

/**
 * Represents a triangle in three-dimensional space.
 */
public class Triangle extends Polygon {

    /**
     * Constructs a triangle from three specified points.
     *
     * @param p1 The first point.
     * @param p2 The second point.
     * @param p3 The third point.
     */
    public Triangle(Point p1, Point p2, Point p3) {
        super(p1, p2, p3);
    }

    @Override
    public List<Point> findIntersections(Ray ray) {

        double EPSILON = 0.00001;

        Point p0 = ray.getHead();
        Vector dir = ray.getDirection();

        Point v0 = vertices.get(0);
        Point v1 = vertices.get(1);
        Point v2 = vertices.get(2);

        Vector v0v1 = v1.subtract(v0);
        Vector v0v2 = v2.subtract(v0);
        Vector pvec = dir.crossProduct(v0v2);
        double det = v0v1.dotProduct(pvec);

        if (Math.abs(det) < EPSILON) return null; // Parallel ray

        double invDet = 1 / det;

        Vector tvec = p0.subtract(v0);
        double u = tvec.dotProduct(pvec) * invDet;
        if (u < 0 || u > 1) return null;

        Vector qvec = tvec.crossProduct(v0v1);
        double v = dir.dotProduct(qvec) * invDet;
        if (v < 0 || u + v > 1) return null;

        double t = v0v2.dotProduct(qvec) * invDet;

        if (t > EPSILON) {
            return List.of(ray.getPoint(t));
        }

        return null;
    }
}
