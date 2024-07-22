package renderer;

import primitives.*;
import renderer.Pixel;

import java.util.LinkedList;
import java.util.List;
import java.util.MissingResourceException;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

/**
 * Represents a camera in the 3D space, with its position and orientation vectors.
 * Provides methods to construct rays through the view plane and a builder for
 * constructing camera instances.
 */
public class Camera implements Cloneable {

    private Point position;
    private Vector vTo;
    private Vector vUp;
    private Vector vRight;
    private double viewPlaneHigh = 0.0;
    private double viewPlaneWidth = 0.0;
    private double viewPlaneDistance = 0.0;
    private ImageWriter imageWriter;
    private RayTracerBase rayTracer;

    /** The number of samples for super sampling */
    int numSamples = 1;

    private int threadsCount = 0; // -2 auto, -1 range/stream, 0 no threads, 1+ number of threads
    private final int SPARE_THREADS = 2; // Spare threads if trying to use all the cores
    private double printInterval = 0; // printing progress percentage interval

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

    public Ray constructRay(int nX, int nY, double j, double i) {
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
            camera.vRight = camera.vTo.crossProduct(camera.vUp).normalize();
            return this;
        }

        public Builder setDirection(Point p, Vector vUp) {
            if(p == null || vUp == null)
                throw new IllegalArgumentException("Camera position and up vector cannot be null");

            if (vUp.equals(Vector.ZERO))
                throw new IllegalArgumentException("Camera up vector cannot be the zero vector");

            camera.vTo = p.subtract(camera.position).normalize();
            camera.vRight = camera.vTo.crossProduct(vUp).normalize();
            camera.vUp = camera.vRight.crossProduct(camera.vTo).normalize();
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
         * Sets the number of samples for super sampling.
         *
         * @param numSamples the number of samples
         * @return the builder instance
         */
        public Builder setNumSamples(int numSamples) {
            if(numSamples < 1)
                throw new IllegalArgumentException("Number of samples must be positive");
            camera.numSamples = numSamples;
            return this;
        }

        public Builder setMultithreading(int threads) {
            if (threads < -2)
                throw new IllegalArgumentException("Multithreading must be -2 or higher");
            if (threads >= -1)
                camera.threadsCount = threads;
            else { // == -2
                int cores = Runtime.getRuntime().availableProcessors() - camera.SPARE_THREADS;
                camera.threadsCount = cores <= 2 ? 1 : cores;
            }
            return this;
        }

        /**
         * Sets the interval for debug printing.
         *
         * @param interval the interval at which to print the progress (as a percentage)
         * @return the Builder instance for method chaining
         */
        public Builder setDebugPrint(double interval) {
            camera.printInterval = interval;
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


            if (camera.imageWriter == null)
                throw new MissingResourceException(DATA_MISS, DATA_MISS, "image writer");
            if (camera.rayTracer == null) throw new MissingResourceException(DATA_MISS, DATA_MISS, "ray tracer");

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
     * Render the image using either single-threaded or multithreaded approach.
     * @return The Camera object, allowing for method chaining
     */
    public Camera renderImage() {
        // Get the dimensions of the image
        int ny = imageWriter.getNy();
        int nx = imageWriter.getNx();

        // Initialize the Pixel class with image dimensions and print interval
        Pixel.initialize(ny, nx, printInterval);

        // Single-threaded rendering
        if (threadsCount == 0) {
            for (int i = 0; i < ny; ++i)
                for (int j = 0; j < nx; ++j)
                    castRays(nx, ny, j, i);
            return this;
        }

        // Multithreaded rendering
        List<Thread> threads = new LinkedList<>();

        // Determine the number of threads to use
        int availableProcessors = threadsCount == -1 ? Runtime.getRuntime().availableProcessors()
                : threadsCount;

        // Create and initialize threads
        for (int t = 0; t < availableProcessors; t++) {
            threads.add(new Thread(() -> {
                Pixel pixel;
                // Each thread processes pixels until there are no more left
                while ((pixel = Pixel.nextPixel()) != null)
                    castRays(nx, ny, pixel.col(), pixel.row());
            }));
        }

        // Start all threads
        for (var thread : threads)
            thread.start();

        // Wait for all threads to complete
        try {
            for (var thread : threads)
                thread.join();
        } catch (InterruptedException ignore) {
            // Interruption is ignored in this implementation
        }

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
    private void castRays(int nX, int nY, int j, int i) {
        // Initialize the color sum to black.
        Color sum = new Color(0, 0, 0);

        // Loop through each sample within the pixel.
        for (int k = 0; k < numSamples * numSamples; ++k) {
            // Calculate the X and Y offsets for the current sample.
            double x = j + (k % numSamples + (Math.random() - 0.5)) / (double) numSamples;
            double y = i + (k / numSamples + (Math.random() - 0.5)) / (double) numSamples;

            // Construct the ray for the current sample.
            Ray ray = constructRay(nX, nY, x, y);

            // Trace the ray and get its color.
            Color color = rayTracer.traceRay(ray);

            // Add the color to the sum.
            sum = sum.add(color);
        }

        // Calculate the average color for the pixel by scaling the sum.
        Color color = sum.scale(1d / (numSamples * numSamples));

        // Write the average color to the pixel in the image.
        imageWriter.writePixel(j, i, color);

        // Mark the pixel as processed.
        Pixel.pixelDone();
    }
}
