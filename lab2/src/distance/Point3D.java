package distance;

import java.util.Objects;

/**
 * This class represents a point in 3-D cartesian space.
 * The Employee has an x, y and z coordinate of a point in 3-D cartesian space..
 */
public class Point3D {

    private int x, y, z;

    /**
     * Constructs a point in 3-D cartesian space without x,y,z coordinates;
     * default set to be the origin point where x,y,z all equals 0.
     */
    public Point3D() {
        new Point3D(0, 0, 0);
    }

    /**
     * Constructs a point in 3-D cartesian space with x,y,z coordinates.
     * @param x x coordinate
     * @param y y coordinate
     * @param z z coordinate
     */
    public Point3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Compares to another point object to check if they are the same.
     * @param o another object to be compared.
     * @return true if they are the same otherwise return false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point3D point3D = (Point3D) o;
        return x == point3D.x && y == point3D.y && z == point3D.z;
    }

    /**
     * Generate hashCode for the point object.
     * @return integer representing the hashCode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    /**
     * Compute the distance to the given point by applying given distance formula.
     * @param other the given point to compute distance to.
     * @return the double representing the distance between two points.
     */
    public double distanceTo(Point3D other) {
        return Math.sqrt(Math.pow(other.getX() - this.getX(), 2)
                + Math.pow(other.getY() - this.getY(), 2)
                + Math.pow(other.getZ() - this.getZ(), 2));
    }

    /**
     * Getter of x coordinate.
     * @return x coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * Getter of y coordinate.
     * @return y coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Getter of z coordinate.
     * @return z coordinate.
     */
    public int getZ() {
        return z;
    }
}
