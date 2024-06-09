package renderer;


import primitives.*;

import java.util.MissingResourceException;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

public class Camera implements Cloneable {

    private Point position;
    private Vector vTo;
    private Vector vUp;
    private Vector vRight;
    private double viewPlaneHigh = 0.0;
    private double viewPlaneWidth = 0.0;
    private double viewPlaneDistance = 0.0;

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
        return viewPlaneDistance;
    }

    public double getViewPlaneHigh() {
        return viewPlaneHigh;
    }

    public double getViewPlaneWidth() {
        return viewPlaneWidth;
    }


    public Ray constructRay(int nX, int nY, int j, int i) {
        Point pCenter = position.add(vTo.scale(viewPlaneDistance));

        double rX = viewPlaneWidth / nX;
        double rY = viewPlaneHigh / nY;

        double xj = (j - ((nX - 1) / 2d)) * rX;
        double yi = (((nY - 1) / 2d) - i) * rY;

        Point pIJ = pCenter;
        if (!isZero(xj))
            pIJ = pIJ.add(vRight.scale(xj));
        if (!isZero(yi))
            pIJ = pIJ.add(vUp.scale(yi));

        return new Ray(position, pIJ.subtract(position).normalize());
    }


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
            camera.vRight = camera.vTo.crossProduct(camera.vUp);
            return this;
        }


        public Builder setVpSize(double width, double height) {
            if (alignZero(width) <= 0 || alignZero(height) <= 0)
                throw new IllegalArgumentException("width and height must be positive");
            camera.viewPlaneWidth = width;
            camera.viewPlaneHigh = height;
            return this;
        }

        public Builder setVpDistance(double distance) {
            if (alignZero(distance) <= 0)
                throw new IllegalArgumentException("distance must be positive");
            camera.viewPlaneDistance = distance;
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


            if (alignZero(camera.viewPlaneWidth) == 0)
                throw new MissingResourceException(DATA_MISS, NAME, "Camera view plane width");
            if (alignZero(camera.viewPlaneHigh) == 0)
                throw new MissingResourceException(DATA_MISS, NAME, "Camera view plane height");
            if (alignZero(camera.viewPlaneDistance) == 0)
                throw new MissingResourceException(DATA_MISS, NAME, "Camera view plane distance");

            // Calculate the right vector
            camera.vRight = camera.vTo.crossProduct(camera.vUp).normalize();

            return (Camera) camera.clone();

        }


    }

    /**
     * Provide builder object for creating Camera
     *
     * @return the camera builder object
     */
    public static Builder getBuilder() {
        return new Builder();
    }
}
