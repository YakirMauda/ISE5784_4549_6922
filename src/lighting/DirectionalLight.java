package lighting;

import primitives.Color;

public class DirectionalLight extends Light{
    /**
     * Constructs a Light object with the specified color intensity.
     *
     * @param intensity the color intensity of the light
     */
    protected DirectionalLight(Color intensity) {
        super(intensity);
    }
}
