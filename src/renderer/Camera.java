package renderer;


import primitives.*;

import java.util.BitSet;
import java.util.MissingResourceException;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

public class Camera implements Cloneable{

    private Point position;
    private Vector vTo;
    private Vector vUp;
    private Vector vRight;
    private double ViewPlaneHigh = 0.0;
    private double ViewPlaneWidth = 0.0;
    private double ViewPlaneDistance = 0.0;

    private Camera() {
    }

    @Override
    public Camera clone() {
        try {
            return (Camera) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    public Point getPosition() {
        return position;
    }

    public Vector getvTo() {
        return vTo;
    }

    public Vector getvUp() {
        return vUp;
    }

    public Vector getvRight() {
        return vRight;
    }

    public double getViewPlaneDistance() {
        return ViewPlaneDistance;
    }

    public double getViewPlaneHigh() {
        return ViewPlaneHigh;
    }

    public double getViewPlaneWidth() {
        return ViewPlaneWidth;
    }

    public Ray constructRay(int nX, int nY, int j, int i) {return null;};

    public static class Builder {
        final private Camera camera = new Camera();


        public Builder setLocation(Point position) {
            if (position == null)
                throw new IllegalArgumentException("Camera position cannot be null");
            camera.position = position;
            return this;
        }

        public Builder setDirection(Vector vTo, Vector vUp) {
            if (!isZero(vTo.dotProduct(vUp)))
                throw new IllegalArgumentException("vTo and vUp are not orthogonal each other");
            camera.vTo = vTo.normalize();
            camera.vUp = vUp.normalize();
            return this;
        }


        public Builder setVpSize(double width, double height) {
            if (alignZero(width) <= 0 || alignZero(height) <= 0)
                throw new IllegalArgumentException("width and height must be positive");
            camera.ViewPlaneWidth = width;
            camera.ViewPlaneHigh = height;
            return this;
        }

        public Builder setVpDistance(double distance) {
            if (alignZero(distance) <= 0)
                throw new IllegalArgumentException("distance must be positive");
            camera.ViewPlaneDistance = distance;
            return this;
        }



        public Camera build() {
            final String DATA_MISS = "Missing rendering data";
            final String NAME = "Camera";

            if (camera.position == null)
                throw new MissingResourceException(DATA_MISS, NAME, "Camera position");
            if (camera.vTo == null)
                throw new MissingResourceException(DATA_MISS, NAME, "Camera vTo direction");
            if (camera.vUp == null)
                throw new MissingResourceException(DATA_MISS, NAME, "Camera vUp direction");
            if (camera.vRight == null)
                throw new MissingResourceException(DATA_MISS, NAME, "Camera vRight direction");


            if (alignZero(camera.ViewPlaneWidth) == 0)
                throw new MissingResourceException(DATA_MISS, NAME, "Camera view plane width");
            if (alignZero(camera.ViewPlaneHigh) == 0)
                throw new MissingResourceException(DATA_MISS, NAME, "Camera view plane height");
            if (alignZero(camera.ViewPlaneDistance) == 0)
                throw new MissingResourceException(DATA_MISS, NAME, "Camera view plane distance");

            // Calculate the right vector
            camera.vRight = camera.vTo.crossProduct(camera.vUp).normalize();

            return (Camera) camera.clone();

        }

    }
}
