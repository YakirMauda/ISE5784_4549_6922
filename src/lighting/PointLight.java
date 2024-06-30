package lighting;

import primitives.*;

public class PointLight extends Light implements LightSource {

    protected Point position;

    private double kC = 1;
    private double kL = 0;
    private double kQ = 0;

    /**
     * Constructs a Light object with the specified color intensity.
     *
     * @param intensity the color intensity of the light
     */
    protected PointLight(Color intensity, Point position) {
        super(intensity);
        this.position = position;
    }

    public PointLight setKC(double kC) {
        this.kC = kC;
        return this;
    }

    public PointLight setKL(double kL) {
        this.kL = kL;
        return this;
    }

    public PointLight setKQ(double kQ) {
        this.kQ = kQ;
        return this;
    }

    @Override
    public Color getIntensity(Point p) {
        double distance = position.distance(p);
        return intensity.scale(1/(kC + kL * distance + kQ * distance * distance));
    }

    @Override
    public Vector getL(Point p) {
        return p.subtract(position).normalize();
    }
}
