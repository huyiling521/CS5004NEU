package distance;

/**
 * This class represents a "utility service" Physics class,
 * provides a class method that calculates a unitless velocity
 * given two Point3D objects and an elapsed time.
 */
public class Physics {
    /**
     * Calculates a unitless velocity given two Point3D objects and an elapsed time.
     * @param one a Point3D object
     * @param two a Point3D object
     * @param elapsedTime the given elapsed time
     * @return the unitless velocity given two Point3D objects and an elapsed time,
     *          if elapsed time is valid, otherwise throw Exception.
     */
    public static double velocity(Point3D one, Point3D two, double elapsedTime) {
        if (elapsedTime > 0) return one.distanceTo(two) / elapsedTime;
        else throw new IllegalArgumentException("The elapsed time cannot be 0 or less than 0.");
    }
}
