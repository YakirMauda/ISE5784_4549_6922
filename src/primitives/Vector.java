package primitives;

/**
 * Represents a vector in three-dimensional (3D) space.
 * A vector is a directed line segment that has both magnitude and direction.
 * This class encapsulates the coordinates of a vector and provides methods for vector operations.
 * Instances of this class are immutable.
 */
public class Vector extends Point {

    /**
     * Constructs a vector from its x, y, and z coordinates.
     *
     * @param x The x-coordinate of the vector.
     * @param y The y-coordinate of the vector.
     * @param z The z-coordinate of the vector.
     * @throws IllegalArgumentException if the vector is the zero vector (0,0,0).
     */
    public Vector(double x, double y, double z) {
        super(x, y, z);

        if (new Double3(x, y, z).equals(Double3.ZERO))
            throw new IllegalArgumentException("Vector cannot be (0,0,0)");
    }

    /**
     * Constructs a vector from a Double3 object.
     *
     * @param xyz The Double3 object containing the vector coordinates.
     */
    public Vector(Double3 xyz) {
        super(xyz);
    }


    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }


    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Returns the squared length of the vector.
     *
     * @return The squared length of the vector.
     */
    public double lengthSquared() {
        return this.dotProduct(this);
    }

    /**
     * Returns the length of the vector.
     *
     * @return The length of the vector.
     */
    public double length() {
        return Math.sqrt(lengthSquared());
    }


    @Override
    public Vector add(Vector vector) {
        return new Vector(xyz.add(vector.xyz));
    }

    /**
     * Scales the vector by a scalar value.
     *
     * @param scalar The scalar value by which to scale the vector.
     * @return The scaled vector.
     */
    public Vector scale(double scalar) {
        return new Vector(xyz.scale(scalar));
    }

    /**
     * Calculates the dot product of this vector and another vector.
     *
     * @param vector The other vector.
     * @return The dot product of the two vectors.
     */
    public double dotProduct(Vector vector) {
        return this.xyz.d1 * vector.xyz.d1
                + this.xyz.d2 * vector.xyz.d2
                + this.xyz.d3 * vector.xyz.d3;
    }

    /**
     * Calculates the cross product of this vector and another vector.
     *
     * @param vector The other vector.
     * @return The cross product of the two vectors.
     */
    public Vector crossProduct(Vector vector) {
        return new Vector((xyz.d2 * vector.xyz.d3) - (xyz.d3 * vector.xyz.d2),
                (xyz.d3 * vector.xyz.d1) - (xyz.d1 * vector.xyz.d3),
                (xyz.d1 * vector.xyz.d2) - (xyz.d2 * vector.xyz.d1));
    }

    /**
     * Normalizes the vector (i.e., creates a unit vector in the same direction).
     *
     * @return The normalized vector.
     */
    public Vector normalize() {
        return scale(1 / length());
    }
}