package artists;

import java.util.Arrays;

/**
 *  This is the class of Actor. It extends the Abstract class AbstractArtist.
 */
public class Actor extends AbstractArtist{

    String[] movies;

    /**
     * Constructor of the Actor class.
     *
     * @param name   : name of the artist.
     * @param age    : age of the artist.
     * @param genres : genres of art the artist develops.
     * @param awards : awards earned by the artist.
     * @param movies : movies the actor participated
     */
    public Actor(String name, int age, String[] genres, String[] awards, String[] movies) throws IllegalArgumentException {
        super(name, age, genres, awards);
        this.movies = movies;
    }

    /**
     * Override of the toString() method that answers the basic information held by the Actor.
     * @return (String)
     */
    @Override
    public String toString() {
        return super.toString() + "I am an ACTOR\n"
                + "I make these types of movies: " + getGenresAsSingleString() + "\n"
                + "I have acted in these movies: " + Arrays.toString(this.movies);
    }
}
