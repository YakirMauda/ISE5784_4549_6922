package primitives;

/**
 * Represents a point in three-dimensional space.
 * This class encapsulates the coordinates of a point and provides methods for manipulating points.
 * Instances of this class are immutable.
 */
public class Point {

    /** The coordinates of the point. */
    final protected Double3 xyz;

    /** The zero point. */
    public final static Point ZERO = new Point(Double3.ZERO);

    /**
     * Constructs a point from its x, y, and z coordinates.
     *
     * @param x The x-coordinate of the point.
     * @param y The y-coordinate of the point.
     * @param z The z-coordinate of the point.
     */
    public Point(double x, double y, double z) {
        xyz = new Double3(x, y, z);
    }

    /**
     * Constructs a point from a Double3 object.
     *
     * @param xyz The Double3 object containing the point coordinates.
     */
    public Point(Double3 xyz) {
        this.xyz = xyz;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        return (object instanceof Point other)
                && xyz.equals(other.xyz);
    }


    /**
     * Returns a string representation of the object.
     * This method returns the string representation of the `xyz` field.
     *
     * @return the string representation of the `xyz` field.
     */
    public String toString() {
        return xyz.toString();
    }


    /**
     * Adds a vector to the point.
     *
     * @param vector The vector to add.
     * @return The resulting point after adding the vector.
     */
    public Point add(Vector vector) {
        return new Point(xyz.add(vector.xyz));
    }

    /**
     * Subtracts another point from this point to create a vector.
     *
     * @param point The point to subtract.
     * @return The vector from this point to the other point.
     */
    public Vector subtract(Point point) {
        return new Vector(xyz.subtract(point.xyz));
    }

    /**
     * Calculates the distance between this point and another point.
     *
     * @param point The other point.
     * @return The distance between this point and the other point.
     */
    public double distance(Point point) {
        return Math.sqrt(distanceSquared(point));
    }

    /**
     * Calculates the squared distance between this point and another point.
     *
     * @param point The other point.
     * @return The squared distance between this point and the other point.
     */
    public double distanceSquared(Point point) {
        double dx = xyz.d1 - point.xyz.d1;
        double dy = xyz.d2 - point.xyz.d2;
        double dz = xyz.d3 - point.xyz.d3;
        return dx * dx + dy * dy + dz * dz;
    }
}
