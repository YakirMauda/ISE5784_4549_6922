package renderer;

import geometries.Intersectable;
import geometries.Intersectable.GeoPoint;
import primitives.Color;
import primitives.Point;
import primitives.Ray;
import scene.*;

/**
 * SimpleRayTracer is a basic implementation of a ray tracer for rendering a scene.
 */
public class SimpleRayTracer extends RayTracerBase {

    /**
     * Constructs a SimpleRayTracer with the specified scene.
     *
     * @param scene the scene to be rendered
     */
    public SimpleRayTracer(Scene scene) {
        super(scene);
    }

    @Override
    public Color traceRay(Ray ray) {
        // Find the closest intersection point of the ray with the scene's geometries
        GeoPoint geoPoint = ray.findClosestGeoPoint(scene.geometries.findGeoIntersections(ray));

        // If no intersection point is found, return the background color.
        // Otherwise, calculate the color at the intersection point.
        return geoPoint == null ? scene.background : calcColor(geoPoint);
    }

    // Calculates the color at a given point.
    private Color calcColor(GeoPoint geoPoint) {
        Color result = scene.ambientLight.getIntensity();
        result = result.add(geoPoint.geometry.getEmission());
        return result;
    }
}