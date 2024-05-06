package primitives;

public class Vector extends Point{

    @Override
    public boolean equals(Object object) {
        super.equals(object);
        if (this == object) return true;
        return (object instanceof Vector other)
                && xyz.equals(other.xyz);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public double lengthSquared() {
        return xyz.lengthSquared();
    }

    public double length() {
        return Math.sqrt(lengthSquared());
    }

    @Override
    public Vector add(Vector vector) {
        return new Vector(xyz.add(vector.xyz));
    }

    public Vector scale(double scalar) {
        return new Vector(xyz.scale(scalar));
    }

    public Vector dotProduct(Vector vector) {
        return new Vector(xyz.dotProduct(vector.xyz));
    }

    public Vector crossProduct(Vector vector) {
        return new Vector(xyz.crossProduct(vector.xyz));
    }

    public Vector normalize() {
        return new Vector(xyz.normalize());
    }
}
