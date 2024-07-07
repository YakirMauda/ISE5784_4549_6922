package renderer;

import geometries.Intersectable.GeoPoint;
import lighting.LightSource;
import primitives.*;
import scene.*;

import static primitives.Util.alignZero;

/**
 * SimpleRayTracer is a basic implementation of a ray tracer for rendering a scene.
 */
public class SimpleRayTracer extends RayTracerBase {

    private static final double DELTA = 0.1;

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
        GeoPoint geoPoint = ray.findClosestGeoPoint(scene.geometries.findGeoIntersections(ray));
        return geoPoint == null ? scene.background : calcColor(geoPoint, ray);
    }

    /**
     * Calculates the color at a given intersection point.
     *
     * @param geoPoint the intersection point
     * @param ray the ray that intersects the point
     * @return the color at the intersection point
     */
    private Color calcColor(GeoPoint geoPoint, Ray ray) {
        return scene.ambientLight.getIntensity()
                .add(calcLocalEffects(geoPoint, ray));
    }

    /**
     * Calculates the local lighting effects at a given intersection point.
     *
     * @param gp the intersection point
     * @param ray the ray that intersects the point
     * @return the color contribution from local lighting effects
     */
    private Color calcLocalEffects(GeoPoint gp, Ray ray) {
        Vector n = gp.geometry.getNormal(gp.point);
        Vector v = ray.getDirection();
        double nv = alignZero(n.dotProduct(v));
        if (nv == 0) return Color.BLACK;
        Material material = gp.geometry.getMaterial();
        Color color = gp.geometry.getEmission();
        for (LightSource lightSource : scene.lights) {
            Vector l = lightSource.getL(gp.point);
            double nl = alignZero(n.dotProduct(l));
            if (nl * nv > 0) { // sign(nl) == sign(nv)
                Color iL = lightSource.getIntensity(gp.point);
                color = color.add(
                        iL.scale(calcDiffusive(material, nl)
                                .add(calcSpecular(material, n, l, nl, v))));
            }
        }
        return color;
    }

    /**
     * Calculates the diffuse reflection component of the lighting.
     *
     * @param mat the material of the intersected geometry
     * @param nl the dot product of the normal and light direction vectors
     * @return the diffuse reflection component
     */
    private Double3 calcDiffusive(Material mat, double nl) {
        return mat.kD.scale(Math.abs(nl));
    }

    /**
     * Calculates the specular reflection component of the lighting.
     *
     * @param mat the material of the intersected geometry
     * @param n the normal vector at the intersection point
     * @param l the light direction vector
     * @param nl the dot product of the normal and light direction vectors
     * @param v the view direction vector
     * @return the specular reflection component
     */
    private Double3 calcSpecular(Material mat, Vector n, Vector l, double nl, Vector v) {
        Vector r = l.subtract(n.scale(2 * nl));
        double vr = alignZero(v.dotProduct(r.scale(-1)));
        return mat.kS.scale(Math.pow(vr, mat.nShininess));
    }


}
