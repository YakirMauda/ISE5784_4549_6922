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
public class Geometries extends Intersectable {

    /**
     * A list of intersectable geometric shapes.
     */
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
     * Constructor that initializes the Geometries collection with a list of Intersectable objects.
     *
     * @param geometries A list of Intersectable objects to be added to the collection.
     */
    public Geometries(List<Intersectable> geometries) {
        add(geometries);
    }

    /**
     * Adds a list of Intersectable objects to the Geometries collection.
     *
     * @param geometries A list of Intersectable objects to be added.
     */
    public void add(List<Intersectable> geometries) {
        this.geometries.addAll(geometries);
    }

    /**
     * Adds one or more Intersectable objects to the Geometries collection.
     *
     * @param geometries Varargs of Intersectable objects to be added.
     */
    public void add(Intersectable... geometries) {
        this.geometries.addAll(Arrays.asList(geometries));
    }

    @Override
    protected List<GeoPoint> findGeoIntersectionsHelper(Ray ray, double maxDistance) {
        // Initialize a list to hold the intersection points
        List<GeoPoint> intersections = null;

        // Iterate through each geometry in the collection
        for (Intersectable geometry : geometries) {
            // Find intersections of the ray with the current geometry within the maximum distance
            List<GeoPoint> geometryIntersections = geometry.findGeoIntersections(ray, maxDistance);

            // If intersections are found, add them to the main intersections list
            if (geometryIntersections != null) {
                // Lazy initialization of the intersections list
                if (intersections == null) {
                    intersections = new LinkedList<>();
                }
                // Add all intersections of the current geometry to the main list
                intersections.addAll(geometryIntersections);
            }
        }
        // Return the list of all intersection points, or null if no intersections are found
        return intersections;
    }

    /**
     * Creates a bounding volume hierarchy (BVH) for the geometries in the collection.
     * This method optimizes the intersection tests by organizing the geometries into a hierarchical structure.
     */
    public void makeBVH() {
        List<Intersectable> intersectables = BoundingBox.buildBVH(geometries);
        geometries.clear();
        geometries.addAll(intersectables);
    }
}