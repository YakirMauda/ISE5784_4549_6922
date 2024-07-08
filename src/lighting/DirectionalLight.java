package lighting;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

/**
 * Represents a directional light source that illuminates uniformly in a given direction.
 */
public class DirectionalLight extends Light implements LightSource {

    private final Vector direction;

    /**
     * Constructs a DirectionalLight object with the specified color intensity and direction.
     *
     * @param intensity the color intensity of the light
     * @param direction the direction vector of the light
     */
    protected DirectionalLight(Color intensity, Vector direction) {
        super(intensity);
        this.direction = direction.normalize();
    }


    @Override
    public double getDistance(Point point) {
        return Double.POSITIVE_INFINITY;
    }

    @Override
    public Color getIntensity(Point p) {
        return intensity;
    }


    @Override
    public Vector getL(Point p) {
        return direction;
    }
}
