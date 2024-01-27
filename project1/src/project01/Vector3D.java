package project01;

import java.util.Objects;

/**
This class represents an object of project01.Vector3D.
 */
public class Vector3D {

    private double x, y, z;

    /**
     * The constructor of project01.Vector3D with the given x, y, z.
     * @param x the x coordinate
     * @param y the y coordinate
     * @param z the z coordinate
     */
    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Computes the magnitude of the 3d Vector.
     * @return the double representing magnitude of the vector.
     */
    public double getMagnitude() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    /**
     * Normalize the 3d Vector, throws exception when not able to.
     * @return a new project01.Vector3D object representing the normalized vector.
     */
    public Vector3D normalize() {
        if (!isValidVector(this))
            throw new IllegalStateException("This is the origin, not a valid vector that can be normalized.");
        double magnitude = getMagnitude();
        return new Vector3D(x / magnitude, y / magnitude, z / magnitude);
    }

    /**
     * Adds another given Vector to the Vector.
     * @param v another given Vector.
     * @return a new project01.Vector3D object representing the result of adding.
     */
    public Vector3D add(Vector3D v) {
        return new Vector3D(this.x + v.x,this.y + v.y,this.z + v.z);
    }

    /**
     * Multiplies the Vector by a given constant.
     * @param coefficient the given constant.
     * @return a new project01.Vector3D object representing the result of multiplying.
     */
    public Vector3D multiply(double coefficient) {
        return new Vector3D(this.x * coefficient,this.y * coefficient,this.z * coefficient);
    }

    /**
     * Compute the dot product of another Vector with this vector.
     * @param v another given Vector.
     * @return double representing the dot product.
     */
    public double dotProduct(Vector3D v) {
        return this.x * v.x + this.y * v.y + this.z * v.z;
    }

    /**
     * Computes the angle between the given two vectors.
     * @param v the given Vector
     * @param u the given Vector
     * @return double representing the angle between the given two vectors.
     */
    public static double angleBetween(Vector3D v, Vector3D u) {
        if (!isValidVector(v) || !isValidVector(u))
            throw new IllegalStateException("There exists invalid vector, the computation cannot be completed.");
        double cos = v.dotProduct(u) / (v.getMagnitude() * u.getMagnitude());
        return Math.toDegrees(cos);
    }

    /**
     * Computes the cross product of this vector and another given vector.
     * @param v another given vector
     * @return a new project01.Vector3D object representing the result of cross product.
     */
    public Vector3D crossProduct(Vector3D v) {
        double newX = this.y * v.getZ() - this.z * v.getY();
        double newY = this.z * v.getX() - this.x * v.getZ();
        double newZ = this.x * v.getY() - this.y * v.getX();
        return new Vector3D(newX, newY, newZ);
    }

    /**
     * Checks if the given Vector is valid(not the origin whose magnitude is 0).
     * @param v the vector to be checked
     * @return true if the vector is valid, otherwise false
     */
    private static boolean isValidVector(Vector3D v) {
        return v.x != 0 || v.y != 0 || v.z != 0;
    }

    /**
     * Creates the String representation of the Vector.
     * @return a formatted String representation
     */
    @Override
    public String toString() {
        return String.format("(%.2f, %.2f, %.2f)", this.x, this.y, this.z);
    }

    /**
     * Compares another vector to this vector.
     * @param o another vector
     * @return true is all attributes are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vector3D vector3D)) return false;
        return Double.compare(vector3D.x, x) == 0 && Double.compare(vector3D.y, y) == 0 && Double.compare(vector3D.z, z) == 0;
    }

    /**
     * Generates hashcode of the vector object
     * @return hashcode of the vector object
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    /**
     * Getter of attribute x.
     * @return x
     */
    public double getX() {
        return x;
    }

    /**
     * Getter of attribute y.
     * @return y
     */
    public double getY() {
        return y;
    }

    /**
     * Getter of attribute z.
     * @return z
     */
    public double getZ() {
        return z;
    }
}

