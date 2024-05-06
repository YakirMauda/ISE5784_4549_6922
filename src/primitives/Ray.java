package primitives;

public class Ray {
    final private Point head;
    final private Vector direction;

    public boolean equals(Object object) {
        if (this == object) return true;
        return (object instanceof Ray other)
                && head.equals(other.head)
                && direction.equals(other.direction);
    }

    public String toString() {
        return "head: " + head + ", direction: " + direction;
    }
}
