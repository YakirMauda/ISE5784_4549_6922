package primitives;

public class Point {

    final Double3 xyz;

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
        return new Point(xyz.add(vector));
    }

    public Vector subtract(Point point) {
        return new Vector(xyz.subtract(point.xyz));
    }

    public double distance(Point point) {
        return Math.sqrt(distanceSquared(point));
    }


    public double distanceSquared(Point point) {
        return xyz.subtract(point.xyz).lengthSquared();
    }