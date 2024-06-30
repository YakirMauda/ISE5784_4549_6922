package lighting;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

public class SpotLight extends PointLight {

    private Vector direction;

    /**
     * Constructs a Light object with the specified color intensity.
     *
     * @param intensity the color intensity of the light
     * @param position
     */
    protected SpotLight(Color intensity, Point position, Vector direction) {
        super(intensity, position);
        this.direction = direction.normalize();
    }


    public SpotLight setKC(double kC) {
        return (SpotLight) super.setKC(kC);
    }

    public SpotLight setKL(double kL) {
        return (SpotLight) super.setKL(kL);
    }

    public SpotLight setKQ(double kQ) {
        return (SpotLight) super.setKQ(kQ);
    }
}
