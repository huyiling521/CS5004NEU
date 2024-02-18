package artists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PoetTest {
    String[] genre = {"Autobiographical Fiction"};

    String[] awards1 = {"Pulitzer"};
    String[] awards2 = {"Nobel"};

    Poet poet;

    @BeforeEach
    void setUp() {
        poet = new Poet("Maya Angelou", 86, genre, awards2, "Random House");
    }

    @Test
    void testGetGenresAsSingleString() {
        assertEquals("[Autobiographical Fiction]", poet.getGenresAsSingleString());
    }

    @Test
    void testGetAge() {
        assertEquals(86, poet.getAge());
    }

    @Test
    void testGetName() {
        assertEquals("Maya Angelou", poet.getName());
    }

    @Test
    void testGetGenres() {
        assertEquals(genre, poet.getGenres());
    }

    @Test
    public void testReceiveAward() {
        String[] testAwards = {"Nobel", "Pulitzer"};
        poet.receiveAward("Pulitzer");
        assertArrayEquals(poet.getAwards(), testAwards);
    }

    @Test
    public void testGetAwards() {
        String[] testAwards = {"Nobel"};
        assertArrayEquals(poet.getAwards(), testAwards);
    }
}