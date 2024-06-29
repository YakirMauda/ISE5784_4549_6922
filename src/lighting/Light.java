package lighting;

import primitives.Color;

/**
 * The Light class represents a light source with a specific color intensity.
 * It is an abstract class that other specific types of lights can extend.
 */
abstract class Light {

    /** The color intensity of the light */
    protected final Color intensity;

    /**
     * Constructs a Light object with the specified color intensity.
     *
     * @param intensity the color intensity of the light
     */
    protected Light(Color intensity) {
        this.intensity = intensity;
    }

    /**
     * Gets the color intensity of the light.
     *
     * @return the color intensity of the light
     */
    Color getIntensity() {
        return intensity;
    }
}
