package questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is the Junit test class of Likert class.
 */
class LikertTest {
    Likert likert1;
    Likert likert2;

    @BeforeEach
    void setUp() {
        this.likert1 = new Likert("You feel confident in programing.");
        this.likert2 = new Likert();
    }

    @Test
    void testAnswer() {
        assertEquals("Correct", likert1.answer("5"));
        assertEquals("Incorrect", likert1.answer("234569"));
        assertEquals("Correct", likert2.answer("1"));
        assertEquals("Incorrect", likert2.answer("0"));
    }

    @Test
    void testGetText() {
        assertEquals("You feel confident in programing.", likert1.getText());
        assertEquals("N/A", likert2.getText());
        likert2.setText("You feel comfortable when networking with others.");
        assertEquals("You feel comfortable when networking with others.", likert2.getText());
    }

    @Test
    void testGetPriority() {
        assertEquals(4, likert1.getPriority());
        assertEquals(4,likert2.getPriority());
    }

    @Test
    void testSetPriority() {
        Exception thrown = assertThrows(IllegalArgumentException.class, () -> {
            likert1.setPriority(1);
        });
        assertEquals("Priority is fix to type of question, the modification is denied.", thrown.getMessage());
        assertEquals(4, likert1.getPriority());
    }

    @Test
    void testCompareTo() {
        assertTrue(likert1.compareTo(likert2) > 0);
    }
}