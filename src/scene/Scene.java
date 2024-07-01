package scene;

import geometries.Geometries;
import lighting.AmbientLight;
import lighting.LightSource;
import primitives.*;

import java.util.LinkedList;
import java.util.List;

import static java.awt.Color.*;

/**
 * Represents a scene containing geometries, background color, and ambient light.
 */
public class Scene {

    /** The name of the scene */
    public String name;

    /** The background color of the scene, default is black */
    public Color background = new Color(BLACK);

    /** The ambient light of the scene, default is none */
    public AmbientLight ambientLight = AmbientLight.NONE;

    /** The geometries present in the scene */
    public Geometries geometries = new Geometries();

    /** The lights present in the scene */
    public List<LightSource> lights = new LinkedList<>();

    /**
     * Constructs a scene with a specified name.
     *
     * @param name the name of the scene
     */
    public Scene(String name) {
        this.name = name;
    }

    /**
     * Sets the background color of the scene.
     *
     * @param background the background color to set
     * @return the current Scene instance
     */
    public Scene setBackground(Color background) {
        this.background = background;
        return this;
    }

    /**
     * Sets the ambient light of the scene.
     *
     * @param ambientLight the ambient light to set
     * @return the current Scene instance
     */
    public Scene setAmbientLight(AmbientLight ambientLight) {
        this.ambientLight = ambientLight;
        return this;
    }

    /**
     * Sets the geometries in the scene.
     *
     * @param geometries the geometries to set
     * @return the current Scene instance
     */
    public Scene setGeometries(Geometries geometries) {
        this.geometries = geometries;
        return this;
    }

    /**
     * Sets the lights in the scene.
     *
     * @param lights the lights to set
     * @return the current Scene instance
     */
    public Scene setLights(List<LightSource> lights) {
        this.lights = lights;
        return this;
    }
}
