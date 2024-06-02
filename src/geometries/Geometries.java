package geometries;

import primitives.Point;
import primitives.Ray;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * The Geometries class represents a collection of geometric shapes that can be intersected by a ray.
 * It implements the Intersectable interface.
 */
public class Geometries implements Intersectable {

    private final List<Intersectable> geometries = new LinkedList<>();

    /**
     * Default constructor for an empty Geometries collection.
     */
    public Geometries() {}

    /**
     * Constructor that initializes the Geometries collection with given Intersectable objects.
     *
     * @param geometries Varargs of Intersectable objects to be added to the collection.
     */
    public Geometries(Intersectable... geometries) {
        add(geometries);
    }

    /**
     * Adds one or more Intersectable objects to the Geometries collection.
     *
     * @param geometries Varargs of Intersectable objects to be added.
     */
    public void add(Intersectable... geometries) {
        this.geometries.addAll(Arrays.asList(geometries));
    }

    /**
     * Finds all intersection points of the given ray with the geometric shapes in the collection.
     *
     * @param ray The ray for which intersections need to be found.
     * @return A list of Points where the ray intersects with the geometric shapes,
     *         or null if there are no intersections.
     */
    public List<Point> findIntersections(Ray ray) {
        List<Point> intersections = null;
        for (Intersectable geometry : geometries) {
            List<Point> geometryIntersections = geometry.findIntersections(ray);
            if (geometryIntersections != null) {
                if (intersections == null) {
                    intersections = new LinkedList<>();
                }
                intersections.addAll(geometryIntersections);
            }
        }
        return intersections;
    }
}
