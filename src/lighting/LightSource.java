package lighting;

import primitives.*;

/**
 * The LightSource interface represents a source of light in the scene.
 * It defines methods to get the intensity of the light at a given point
 * and to get the direction of the light from a given point.
 */
public interface LightSource {

    /**
     * Gets the color intensity of the light at the specified point.
     *
     * @param p the point at which the light intensity is to be calculated
     * @return the color intensity of the light at the specified point
     */
    public Color getIntensity(Point p);

    /**
     * Gets the direction of the light from the specified point.
     *
     * @param p the point from which the light direction is to be calculated
     * @return the direction of the light from the specified point
     */
    public Vector getL(Point p);
}
