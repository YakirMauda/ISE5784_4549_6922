package renderer;

import primitives.*;

import java.util.MissingResourceException;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

/**
 * Represents a camera in the 3D space, with its position and orientation vectors.
 * Provides methods to construct rays through the view plane and a builder for
 * constructing camera instances.
 */
public class Camera implements Cloneable {

    /** The position of the camera */
    private Point position;

    /** The direction vector towards the view plane */
    private Vector vTo;

    /** The upward direction vector */
    private Vector vUp;

    /** The right direction vector */
    private Vector vRight;

    /** The height of the view plane */
    private double viewPlaneHigh = 0.0;

    /** The width of the view plane */
    private double viewPlaneWidth = 0.0;

    /** The distance from the camera to the view plane */
    private double viewPlaneDistance = 0.0;

    /** The image writer used for writing images */
    private ImageWriter imageWriter;

    /** The ray tracer used for tracing rays */
    private RayTracerBase rayTracer;

    /**
     * Private constructor to prevent direct instantiation.
     */
    private Camera() {
    }

    /**
     * Gets the position of the camera.
     *
     * @return the position of the camera
     */
    public Point getPosition() {
        return position;
    }

    /**
     * Gets the direction vector towards the view plane.
     *
     * @return the direction vector (vTo)
     */
    public Vector getvTo() {
        return vTo;
    }

    /**
     * Gets the upward direction vector of the camera.
     *
     * @return the upward direction vector (vUp)
     */
    public Vector getvUp() {
        return vUp;
    }

    /**
     * Gets the right direction vector of the camera.
     *
     * @return the right direction vector (vRight)
     */
    public Vector getvRight() {
        return vRight;
    }

    /**
     * Gets the distance from the camera to the view plane.
     *
     * @return the view plane distance
     */
    public double getViewPlaneDistance() {
        return viewPlaneDistance;
    }

    /**
     * Gets the height of the view plane.
     *
     * @return the view plane height
     */
    public double getViewPlaneHigh() {
        return viewPlaneHigh;
    }

    /**
     * Gets the width of the view plane.
     *
     * @return the view plane width
     */
    public double getViewPlaneWidth() {
        return viewPlaneWidth;
    }

    /**
     * Constructs a ray through the view plane from the camera's position.
     *
     * @param nX number of pixels in the X direction
     * @param nY number of pixels in the Y direction
     * @param j  pixel column index
     * @param i  pixel row index
     * @return the constructed ray
     */
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

    /**
     * Builder class for constructing Camera instances.
     */
    public static class Builder {
        /** The Camera instance being built */
        final private Camera camera = new Camera();

        /**
         * Sets the location of the camera.
         *
         * @param position the position of the camera
         * @return the builder instance
         */
        public Builder setLocation(Point position) {
            if (position == null)
                throw new IllegalArgumentException("Camera position cannot be null");
            camera.position = position;
            return this;
        }

        /**
         * Sets the direction vectors of the camera.
         *
         * @param vTo the direction vector towards the view plane
         * @param vUp the upward direction vector
         * @return the builder instance
         */
        public Builder setDirection(Vector vTo, Vector vUp) {
            if (!isZero(vTo.dotProduct(vUp)))
                throw new IllegalArgumentException("vTo and vUp are not orthogonal to each other");
            camera.vTo = vTo.normalize();
            camera.vUp = vUp.normalize();
            camera.vRight = camera.vTo.crossProduct(camera.vUp);
            return this;
        }

        /**
         * Sets the size of the view plane.
         *
         * @param width  the width of the view plane
         * @param height the height of the view plane
         * @return the builder instance
         */
        public Builder setVpSize(double width, double height) {
            if (alignZero(width) <= 0 || alignZero(height) <= 0)
                throw new IllegalArgumentException("width and height must be positive");
            camera.viewPlaneWidth = width;
            camera.viewPlaneHigh = height;
            return this;
        }

        /**
         * Sets the distance from the camera to the view plane.
         *
         * @param distance the view plane distance
         * @return the builder instance
         */
        public Builder setVpDistance(double distance) {
            if (alignZero(distance) <= 0)
                throw new IllegalArgumentException("distance must be positive");
            camera.viewPlaneDistance = distance;
            return this;
        }

        /**
         * Sets the image writer for the camera.
         *
         * @param imageWriter the image writer
         * @return the builder instance
         */
        public Builder setImageWriter(ImageWriter imageWriter) {
            camera.imageWriter = imageWriter;
            return this;
        }

        /**
         * Sets the ray tracer for the camera.
         *
         * @param rayTracer the ray tracer
         * @return the builder instance
         */
        public Builder setRayTracer(RayTracerBase rayTracer) {
            camera.rayTracer = rayTracer;
            return this;
        }

        /**
         * Builds and returns the Camera instance.
         *
         * @return the constructed Camera instance
         * @throws MissingResourceException if any required camera parameter is missing
         */
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


            /*
            if (camera.imageWriter == null)
                throw new MissingResourceException(DATA_MISS, DATA_MISS, "image writer");
            if (camera.rayTracer == null) throw new MissingResourceException(DATA_MISS, DATA_MISS, "ray tracer");
            **/
            // Calculate the right vector
            camera.vRight = camera.vTo.crossProduct(camera.vUp).normalize();

            try {
                return (Camera) camera.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Provides a builder object for creating Camera instances.
     *
     * @return the camera builder object
     */
    public static Builder getBuilder() {
        return new Builder();
    }

    /**
     * Renders the image by casting rays through each pixel of the view plane.
     *
     * @return the camera instance
     */
    public Camera renderImage() {
        int nX = imageWriter.getNx();
        int nY = imageWriter.getNy();

        for (int i = 0; i < nY; ++i)
            for (int j = 0; j < nX; ++j)
                castRay(nX, nY, j, i);

        return this;
    }

    /**
     * Prints a grid on the image with a given interval and color.
     *
     * @param interval the interval between grid lines
     * @param color    the color of the grid lines
     * @return the camera instance
     */
    public Camera printGrid(int interval, Color color) {
        int nX = imageWriter.getNx();
        int nY = imageWriter.getNy();

        for (int i = 0; i < nY; ++i)
            for (int j = 0; j < nX; ++j)
                if (j % interval == 0 || i % interval == 0)
                    imageWriter.writePixel(j, i, color);
        return this;
    }

    /**
     * Writes the rendered image to the output file.
     *
     * @return the camera instance
     */
    public Camera writeToImage() {
        imageWriter.writeToImage();
        return this;
    }

    /**
     * Casts a ray through a given pixel and traces its color.
     *
     * @param nX number of pixels in the X direction
     * @param nY number of pixels in the Y direction
     * @param j  pixel column index
     * @param i  pixel row index
     */
    private void castRay(int nX, int nY, int j, int i) {
        Ray ray = constructRay(nX, nY, j, i);
        Color color = rayTracer.traceRay(ray);
        imageWriter.writePixel(j, i, color);
    }
}
