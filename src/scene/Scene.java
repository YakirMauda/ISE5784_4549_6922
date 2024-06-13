package scene;

import geometries.Geometries;
import lighting.AmbientLight;
import primitives.*;
import static java.awt.Color.*;


public class Scene {
    public String name;
    public Color background = new Color(BLACK);
    public AmbientLight ambientLight = AmbientLight.NONE;
    public Geometries geometries = new Geometries();

    Scene(String name) { this.name = name; }

    public Scene setBackground(Color background) {
        this.background = background;
        return this;
    }

    public Scene setAmbientLight(AmbientLight ambientLight) {
        this.ambientLight = ambientLight;
        return this;
    }

    public Scene setGeometries(Geometries geometries) {
        this.geometries = geometries;
        return this;
    }
}
