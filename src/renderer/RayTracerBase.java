package renderer;

import primitives.*;
import scene.*;

/**
 * RayTracerBase serves as an abstract base class for ray tracers.
 */
public abstract class RayTracerBase {

    // The scene to be rendered by the ray tracer
    protected Scene scene;

    /**
     * Constructs a RayTracerBase with the specified scene.
     *
     * @param scene the scene to be rendered
     */
    RayTracerBase(Scene scene) {
        this.scene = scene;
    }

    /**
     * Traces a ray and calculates the color at the intersection point.
     *
     * @param ray the ray to trace
     * @return the color at the intersection point
     */
    public abstract Color traceRay(Ray ray);
}