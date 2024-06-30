package lighting;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

import static primitives.Util.alignZero;

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


    public SpotLight setKc(double kC) {
        return (SpotLight) super.setKc(kC);
    }

    public SpotLight setKl(double kL) {
        return (SpotLight) super.setKl(kL);
    }

    public SpotLight setKq(double kQ) {
        return (SpotLight) super.setKq(kQ);
    }
}
