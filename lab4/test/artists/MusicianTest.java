package artists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MusicianTest {

    String[] genre1 = {"Rock", "Rock-Soul"};
    String[] genre2 = {"R&B", "Pop", "Rap", "Jazz"};

    String[] awards1 = {"Grammy", "American Music Award"};
    String[] awards2 = {"Grammy", "Billboard"};

    String[] movies = {"Glory", "Flight", "Training Day", "Book of Eli", "Fences"};
    String[] movies3 = {"Bridesmaids", "Tammy", "Life of the Party", "Ghostbusters"};

    Musician bruce;
    Musician lizzo;

    @BeforeEach
    void setUp() {
        bruce = new Musician("Bruce Springsteen", 73, genre1, awards1,
                "Only the Strong Survive", "Columbia Records");

        lizzo = new Musician("Lizzo", 34, genre2, awards2,
                "Special", "Atlantic Records");
    }

    @Test
    void testGetGenresAsSingleString() {
        assertEquals("[Rock, Rock-Soul]", bruce.getGenresAsSingleString());
        assertEquals("[R&B, Pop, Rap, Jazz]", lizzo.getGenresAsSingleString());
    }

    @Test
    void testGetAge() {
        assertEquals(73, bruce.getAge());
        assertEquals(34, lizzo.getAge());
    }

    @Test
    void testGetName() {
        assertEquals("Bruce Springsteen", bruce.getName());
        assertEquals("Lizzo", lizzo.getName());
    }

    @Test
    void testGetGenres() {
        assertEquals(genre1, bruce.getGenres());
        assertEquals(genre2, lizzo.getGenres());
    }

    @Test
    public void testReceiveAward() {
        String[] testAwards = {"Grammy", "American Music Award", "Billboard"};
        bruce.receiveAward("Billboard");
        assertArrayEquals(bruce.getAwards(), testAwards);

        String[] testAwards2 = {"Grammy", "Billboard", "American Music Award"};
        lizzo.receiveAward("American Music Award");
        assertArrayEquals(lizzo.getAwards(), testAwards2);
    }

    @Test
    public void testGetAwards() {
        String[] testAwards = {"Grammy", "Billboard"};
        assertArrayEquals(lizzo.getAwards(), testAwards);
    }
}