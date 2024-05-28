package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static java.lang.Math.sqrt;
import static primitives.Util.alignZero;

/**
 * Represents a sphere in three-dimensional space.
 */
public class Sphere extends RadialGeometry {

    final private Point center;

    /**
     * Constructs a sphere with a specified radius and center point.
     *
     * @param radius The radius of the sphere.
     * @param point The center point of the sphere.
     */
    public Sphere(Point point, double radius) {
        super(radius);
        center = point;
    }

    @Override
    public Vector getNormal(Point point) {
        return point.subtract(center).normalize();
    }

    @Override
    public List<Point> findIntersections(Ray ray) {
       /** Vector u = center.subtract(ray.getHead());
        double tm = alignZero(ray.getDirection().dotProduct(u));
        double d = alignZero(sqrt(u.lengthSquared() - tm*tm));
        if (d >= radius)
            return null;

        double th = alignZero(sqrt(radius*radius - d*d));
        double t1 = tm + th;
        double t2 = tm - th;

        if (t1 > 0 & t2 > 0)
            return List.of(ray.getPoint(t1), ray.getPoint(t2));

        if (t1 > 0)
            return List.of(ray.getPoint(t1));

        if (t2 > 0)
            return List.of(ray.getPoint(t2));

        return null;
        */
        return null;
    }
}