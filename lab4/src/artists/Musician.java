package artists;

import java.util.Arrays;
/**
 *  This is the class of Musician. It extends the Abstract class AbstractArtist.
 */
public class Musician extends AbstractArtist{

    String recCompany, currAlbum;

    /**
     * Constructor of the Musician class.
     *
     * @param name   : name of the artist.
     * @param age    : age of the artist.
     * @param genres : genres of art the artist develops.
     * @param awards : awards earned by the artist.
     * @param recCompany : recording company of the musician
     * @param currAlbum : title of musician's current album
     */
    public Musician(String name, int age, String[] genres, String[] awards, String currAlbum, String recCompany) throws IllegalArgumentException {
        super(name, age, genres, awards);
        this.recCompany = recCompany;
        this.currAlbum = currAlbum;
    }

    /**
     * Override of the toString() method that answers the basic information held by the Musician.
     * @return (String)
     */
    @Override
    public String toString() {
        return super.toString() + "I am an MUSICIAN\n"
                + "I make these types of music: " + getGenresAsSingleString() + "\n"
                + "My current album is: " + this.currAlbum + "\n"
                + "My recording company is: " + this.recCompany;
    }
}
