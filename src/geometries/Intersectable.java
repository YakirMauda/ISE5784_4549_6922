package geometries;

import java.util.List;
import java.util.Objects;

import primitives.Point;
import primitives.Ray;

/**
 * Interface for objects that can be intersected by a ray.
 */
public abstract class Intersectable {

    /**
     * Represents a point in three-dimensional space with its related geometry.
     */
    public static class GeoPoint {
        public Geometry geometry;
        public Point point;

        /**
         * Constructs a GeoPoint with the specified geometry and point.
         *
         * @param geometry the geometry associated with this point
         * @param point the point in three-dimensional space
         */
        public GeoPoint(Geometry geometry, Point point) {
            this.geometry = geometry;
            this.point = point;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (!(object instanceof GeoPoint geoPoint)) return false;
            return geometry.equals(geoPoint.geometry) && point.equals(geoPoint.point);
        }

        @Override
        public int hashCode() {
            return Objects.hash(geometry, point);
        }

        @Override
        public String toString() {
            return "GeoPoint{" +
                    "geometry=" + geometry +
                    ", point=" + point +
                    '}';
        }
    }

    /**
     * Finds the intersections between a given ray and the object implementing this interface.
     *
     * @param ray the ray to intersect with the object
     * @return a list of GeoPoints where the ray intersects the object, or null if there are no intersections
     */
    public final List<GeoPoint> findGeoIntersections(Ray ray) {
        return findGeoIntersectionsHelper(ray, Double.POSITIVE_INFINITY);
    }

    /**
     * Finds the intersections between a given ray and the object implementing this interface within a specified distance.
     *
     * @param ray the ray to intersect with the object
     * @param distance the maximum distance for intersections
     * @return a list of GeoPoints where the ray intersects the object within the specified distance, or null if there are no intersections
     */
    public final List<GeoPoint> findGeoIntersections(Ray ray, double distance) {
        return findGeoIntersectionsHelper(ray, distance);
    }

    /**
     * Helper method to find the intersections between a given ray and the object within a specified distance.
     * This method must be implemented by subclasses.
     *
     * @param ray the ray to intersect with the object
     * @param distance the maximum distance for intersections
     * @return a list of GeoPoints where the ray intersects the object within the specified distance, or null if there are no intersections
     */
    protected abstract List<GeoPoint> findGeoIntersectionsHelper(Ray ray, double distance);

    /**
     * Finds the intersection points between a given ray and the object implementing this interface.
     *
     * @param ray the ray to intersect with the object
     * @return a list of Points where the ray intersects the object, or null if there are no intersections
     */
    public List<Point> findIntersections(Ray ray) {
        var geoPoints = findGeoIntersections(ray);
        if (geoPoints == null) {
            return null;
        }
        return geoPoints.stream()
                .map(gp -> gp.point)
                .toList();
    }
}
