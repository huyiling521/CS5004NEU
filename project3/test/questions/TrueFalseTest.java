package questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is the Junit test class of TrueFalse class.
 */
class TrueFalseTest {
    TrueFalse true1;
    TrueFalse true2;
    TrueFalse false1;
    TrueFalse false2;
    @BeforeEach
    void setUp() {
        this.true1 = new TrueFalse("Java is an Object-Oriented Programing Language.", "TRUE");
        this.true2 = new TrueFalse("Programmer makes money.", "TRue");
        this.false1 = new TrueFalse();
        this.false2 = new TrueFalse("Java is easy to learn.", "false");
    }

    @Test
    void testConstructor() {
        Exception thrown = assertThrows(IllegalArgumentException.class, () -> {
            TrueFalse test = new TrueFalse("Java is easy to learn.", "sdsljcfnksj");
        });
        assertEquals("No valid answer is provided.", thrown.getMessage());
    }
    @Test
    void testAnswer() {
        assertEquals("Correct", true1.answer("trUE"));
        assertEquals("Incorrect", true1.answer("falSe"));
        assertEquals("Correct", false1.answer("false"));
        assertEquals("Incorrect", false2.answer("true"));
    }

    @Test
    void testGetText() {
        assertEquals("Java is an Object-Oriented Programing Language.", true1.getText());
        assertEquals("Programmer makes money.", true2.getText());
        assertEquals("N/A", false1.getText());
        assertEquals("Java is easy to learn.", false2.getText());
    }

    @Test
    void testSetText() {
        assertEquals("N/A", false1.getText());
        false1.setText("Now there is text.");
        assertEquals("Now there is text.", false1.getText());
    }

    @Test
    void testGetPriority() {
        assertEquals(1, true1.getPriority());
        assertEquals(1, true2.getPriority());
        assertEquals(1, false1.getPriority());
        assertEquals(1, false2.getPriority());
    }

    @Test
    void testSetPriority() {
        Exception thrown = assertThrows(IllegalArgumentException.class, () -> {
            true1.setPriority(4);
        });
        assertEquals("Priority is fix to type of question, the modification is denied.", thrown.getMessage());
        assertEquals(1, true1.getPriority());
    }

    @Test
    void testSetCorrectAns() {
        assertEquals("Correct", false1.answer("false"));
        false1.setCorrectAns("true");
        assertEquals("Correct", false1.answer("TRUE"));
    }

    @Test
    void testCompareTo() {
        assertTrue(true1.compareTo(true2) < 0);
        assertTrue(true2.compareTo(false1) > 0);
        assertTrue(false2.compareTo(true1) > 0);
    }

    @Test
    void testGetCorrectAns() {
        assertTrue(true1.getCorrectAns());
        assertTrue(true2.getCorrectAns());
        assertFalse(false1.getCorrectAns());
        assertFalse(false2.getCorrectAns());
    }
}