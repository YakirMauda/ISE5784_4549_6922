package primitives;

public class Vector extends Point{

    public Vector(double x, double y, double z) {
        super(x, y, z);

        if(new Double3(x,y,z).equals(Double3.ZERO))
            throw new IllegalArgumentException("Vector cannot be (0,0,0)");

    }

    public Vector(Double3 xyz) {
        this(xyz.d1, xyz.d2, xyz.d3);
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object);
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
