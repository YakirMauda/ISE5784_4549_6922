package primitives;

public class Point {

    final protected Double3 xyz;
    public final static Point ZERO = new Point(Double3.ZERO);


    public Point(double x, double y, double z) {
        xyz = new Double3(x, y, z);
    }

    public Point(Double3 xyz) {
        this(xyz.d1, xyz.d2, xyz.d3);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        return (object instanceof Point other)
                && xyz.equals(other.xyz);
    }

    @Override
    public String toString() {
        return xyz.toString();
    }

    public Point add(Vector vector) {
        return new Point(xyz.add(vector.xyz));
    }

    public Vector subtract(Point point) {
        return new Vector(xyz.subtract(point.xyz));
    }

    public double distance(Point point) {
        return Math.sqrt(distanceSquared(point));
    }


    public double distanceSquared(Point point) {
        double dx = xyz.d1 - point.xyz.d1;
        double dy = xyz.d2 - point.xyz.d2;
        double dz = xyz.d3 - point.xyz.d3;
        return dx * dx + dy * dy + dz * dz;
    }


    }