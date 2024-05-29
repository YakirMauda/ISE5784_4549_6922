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

        List<Point> lst = super.findIntersections(ray);
        if (lst == null) return null;

        Point p0 = ray.getHead();
        Point p1 = this.vertices.getFirst();
        Point p2 = this.vertices.get(1);
        Point p3 = this.vertices.getLast();

        Vector v1 = p0.subtract(p1);
        Vector v2 = p0.subtract(p2);
        Vector v3 = p0.subtract(p3);

        Vector n1 = v1.crossProduct(v2).normalize();
        Vector n2 = v2.crossProduct(v3).normalize();
        Vector n3 = v3.crossProduct(v1).normalize();

        double num1 = ray.getDirection().dotProduct(n1);
        double num2 = ray.getDirection().dotProduct(n2);
        double num3 = ray.getDirection().dotProduct(n3);

        if(num1 > 0 && num2 > 0 && num3 > 0 || num1 < 0 && num2 < 0 && num3 < 0) return lst;


        return null;
    }
}
