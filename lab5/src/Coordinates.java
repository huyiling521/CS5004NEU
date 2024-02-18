import java.util.Objects;

/**
 * This is the class represents the Coordinates objects.
 * The Coordinates object is comparable.
 */
public class Coordinates implements Comparable<Coordinates>{

    double latitude, longitude;
    static final double LATFAVORCITY = 37.335480;
    static final double LONGFAVORCITY = -121.893028;

    /**
     * Default constructor to set a Coordinate at the favorite city.
     */
    public Coordinates() {
        this(37.335480,-121.893028);
    }

    /**
     * Constructor to set a Coordinate at the given latitude and longitude.
     * @param latitude latitude of the given coordinate
     * @param longitude longitude of the given coordinate
     */
    public Coordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * A static methods that computes the distance between
     * the favorite Coordinate and the given Coordinate
     * @param coordinate the given Coordinate to compute the distance
     * @return the distance between the favorite Coordinate and the given Coordinate
     */
    private static double distanceTo(Coordinates coordinate) {
        return Math.sqrt(Math.pow(LATFAVORCITY - coordinate.latitude, 2)
                + Math.pow(LONGFAVORCITY - coordinate.longitude, 2));
    }
    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * @param other the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     */
    @Override
    public int compareTo(Coordinates other) {
        if (other == null) throw new NullPointerException("The other coordinate does not exist!");
        double compare = distanceTo(this) - distanceTo(other);
        if (compare == 0) return 0;
        return (compare < 0)? -1 : 1;
    }

    /**
     * Generates new String representation of the Coordinates objects
     * @return the String representation of the Coordinate
     */
    @Override
    public String toString() {
        return " (" + latitude + ", " + longitude + ") ";
    }
}
