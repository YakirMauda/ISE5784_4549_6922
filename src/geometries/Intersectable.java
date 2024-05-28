package geometries;

import java.util.List;
import primitives.Point;
import primitives.Ray;

/**
 * Interface for objects that can be intersected by a ray.
 */
public interface Intersectable {

    /**
     * Finds the intersections between a given ray and the object implementing this interface.
     *
     * @param ray the ray to intersect with the object
     * @return a list of points where the ray intersects the object,
     *         or an empty list if there are no intersections
     */
    List<Point> findIntersections(Ray ray);
}
