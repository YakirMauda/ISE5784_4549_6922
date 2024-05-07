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
        return this.dotProduct(this);
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

    public double dotProduct(Vector vector) {
        return this.xyz.d1 * vector.xyz.d1
                + this.xyz.d2 * vector.xyz.d2
                + this.xyz.d3 * vector.xyz.d3;
    }

    public Vector crossProduct(Vector vector) {
        return new Vector((xyz.d2 * vector.xyz.d3) - (xyz.d3 * vector.xyz.d2),
                (xyz.d3 * vector.xyz.d1) - (xyz.d1 * vector.xyz.d3),
                (xyz.d1 * vector.xyz.d2) - (xyz.d2 * vector.xyz.d1));
    }

    public Vector normalize() { return scale(1/length()); }
}
