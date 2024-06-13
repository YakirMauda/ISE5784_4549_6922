package lighting;

import primitives.*;

public class AmbientLight {

    private final Color intensity;

    public static final AmbientLight NONE = new AmbientLight(Color.BLACK, 0d);

    public AmbientLight(Color IA, Double3 KA) {
        intensity = IA.scale(KA);
    }

    public AmbientLight(Color IA, Double KA) {
        intensity = IA.scale(KA);
    }

    public Color getIntensity() {
        return intensity;
    }
}
