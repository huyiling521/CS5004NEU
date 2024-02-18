package artists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ActorTest {

    String[] genre1 = {"Action", "SciFi", "Drama"};
    String[] genre2 = {"Thriller", "Comedy"};

    String[] awards1 = {"Academy Award", "Golden Globe"};
    String[] awards2 = {"Oscars"};

    String[] movies1 = {"Glory", "Flight", "Training Day", "Book of Eli", "Fences"};
    String[] movies2 = {"Bridesmaids", "Tammy", "Life of the Party", "Ghostbusters"};

    Actor denzel;
    Actor david;

    @BeforeEach
    void setUp() {
        denzel = new Actor("Denzel Washington", 67, genre1, awards1, movies1);
        david = new Actor("David Lee", 25, genre2, awards2, movies2);
    }

    @Test
    void testGetGenresAsSingleString() {
        assertEquals("[Action, SciFi, Drama]", denzel.getGenresAsSingleString());
        assertEquals("[Thriller, Comedy]", david.getGenresAsSingleString());
    }

    @Test
    void testGetAge() {
        assertEquals(67, denzel.getAge());
        assertEquals(25, david.getAge());
    }

    @Test
    void testGetName() {
        assertEquals("Denzel Washington", denzel.getName());
        assertEquals("David Lee", david.getName());
    }

    @Test
    void testGetGenres() {
        assertEquals(genre1, denzel.getGenres());
        assertEquals(genre2, david.getGenres());
    }

    @Test
    public void testReceiveAward() {
        String[] testAwards = {"Academy Award", "Golden Globe", "Oscars"};
        denzel.receiveAward("Oscars");
        assertArrayEquals(denzel.getAwards(), testAwards);

        String[] testAwards2 = {"Oscars", "Academy Award", "Golden Globe"};
        david.receiveAward("Academy Award");
        david.receiveAward("Golden Globe");
        assertArrayEquals(david.getAwards(), testAwards2);
    }

    @Test
    public void testGetAwards() {
        String[] testAwards = {"Academy Award", "Golden Globe"};
        assertArrayEquals(denzel.getAwards(), testAwards);
    }
}