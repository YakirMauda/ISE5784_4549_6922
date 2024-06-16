package renderer;

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
        Point point = ray.findClosestPoint(scene.geometries.findIntersections(ray));

        // If no intersection point is found, return the background color.
        // Otherwise, calculate the color at the intersection point.
        return point == null ? scene.background : calcColor(point);
    }

    // Calculates the color at a given point.
    private Color calcColor(Point point) {
        return scene.ambientLight.getIntensity();
    }
}