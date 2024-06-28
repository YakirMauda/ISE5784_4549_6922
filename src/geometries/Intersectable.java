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
     * Represents a point in three-dimensional space
     * with it's related basic color.
     */
    public static class GeoPoint {
        public Geometry geometry;
        public Point point;

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
     * @return a list of points where the ray intersects the object,
     * or an empty list if there are no intersections
     */
    public final List<GeoPoint> findGeoIntersections(Ray ray) {
        return findGeoIntersectionsHelper(ray, Double.POSITIVE_INFINITY);
    }

    public final List<GeoPoint> findGeoIntersections(Ray ray, double distance) {
        return findGeoIntersectionsHelper(ray, Double.POSITIVE_INFINITY);
    }

    protected abstract List<GeoPoint> findGeoIntersectionsHelper(Ray ray, double positiveInfinity);

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
