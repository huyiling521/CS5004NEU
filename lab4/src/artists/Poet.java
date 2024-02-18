package artists;

import java.util.Arrays;
/**
 *  This is the class of Poet. It extends the Abstract class AbstractArtist.
 */
public class Poet extends AbstractArtist{

    String publisher;

    /**
     * Constructor of the Poet class.
     *
     * @param name   : name of the artist.
     * @param age    : age of the artist.
     * @param genres : genres of art the artist develops.
     * @param awards : awards earned by the artist.
     * @param publisher :  publisher that publishes the poet's books/work
     */
    public Poet(String name, int age, String[] genres, String[] awards, String publisher) throws IllegalArgumentException {
        super(name, age, genres, awards);
        this.publisher = publisher;
    }

    /**
     * Override of the toString() method that answers the basic information held by the Poet.
     * @return (String)
     */
    @Override
    public String toString() {
        return super.toString() + "I am an POET\n"
                + "I make these types of poems: " + getGenresAsSingleString() + "\n"
                + "My publishing company is: " + this.publisher;
    }
}
