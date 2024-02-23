package questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is the Junit test class of MultipleChoice class.
 */
class MultipleChoiceTest {

    MultipleChoice choice1;
    MultipleChoice choice2;
    MultipleChoice choice3;

    @BeforeEach
    void setUp() {
        this.choice1 = new MultipleChoice(
                "If you update the equals() method for a particular class, you should also update its hashCode() method.",
                "1"
                ,"1. Yes, always.",
                "2. No. The method hashCode() should never be modified.",
                "3. Only when we are using a HashSet.",
                "4. Only true for Abstract classes.");
        this.choice2 = new MultipleChoice("Which of the following allows duplicate entries?",
                "4",
                "1. HashMap", "2. TreeMap", "3. HashSet", "4. ArrayList");
        this.choice3 = new MultipleChoice();

    }

    @Test
    void testConstructor() {
        Exception thrown = assertThrows(IllegalArgumentException.class, () -> {
            MultipleChoice test = new MultipleChoice("Java is easy to learn.", "2");
        });
        assertEquals("The options are not valid.", thrown.getMessage());

        thrown = assertThrows(IllegalArgumentException.class, () -> {
            MultipleChoice test = new MultipleChoice("Java is easy to learn.", "envoi3d", "1", "2", "3");
        });
        assertEquals("No valid answer is provided.", thrown.getMessage());
    }
    @Test
    void testAnswer() {
        assertEquals("Correct", choice1.answer("1"));
        assertEquals("Incorrect", choice1.answer("2"));
        assertEquals("Correct", choice2.answer("4"));
        assertEquals("Incorrect", choice2.answer("3"));
    }

    @Test
    void testGetText() {
        assertEquals("If you update the equals() method for a particular class, you should also update its hashCode() method.",
                choice1.getText());
        assertEquals("Which of the following allows duplicate entries?", choice2.getText());
        assertEquals("N/A", choice3.getText());
    }

    @Test
    void testSetText() {
        assertEquals("N/A", choice3.getText());
        choice3.setText("When thinking about equality, what does transitivity mean?");
        assertEquals("When thinking about equality, what does transitivity mean?", choice3.getText());
    }

    @Test
    void testGetPriority() {
        assertEquals(2, choice1.getPriority());
        assertEquals(2, choice2.getPriority());
        assertEquals(2, choice3.getPriority());
    }

    @Test
    void testSetPriority() {
        Exception thrown = assertThrows(IllegalArgumentException.class, () -> {
            choice1.setPriority(4);
        });
        assertEquals("Priority is fix to type of question, the modification is denied.", thrown.getMessage());
        assertEquals(2, choice1.getPriority());
    }

    @Test
    void testCompareTo() {
        assertTrue(choice1.compareTo(choice2) < 0);
        assertTrue(choice2.compareTo(choice3) > 0);
    }

    @Test
    void testGetOptions() {
        String[] test1 = new String[]{"1. Yes, always.",
                "2. No. The method hashCode() should never be modified.",
                "3. Only when we are using a HashSet.",
                "4. Only true for Abstract classes."};
        for (int i = 0; i < test1.length; i++) {
            assertEquals(test1[i], choice1.getOptions()[i]);
        }
    }

    @Test
    void testGetCorrectAns() {
        assertEquals(1, choice1.getCorrectAns());
        assertEquals(4, choice2.getCorrectAns());
    }

    @Test
    void testSetOptions() {
        String[] test1 = new String[]{"1. Yes, always.",
                "2. No. The method hashCode() should never be modified.",
                "3. Only when we are using a HashSet.",
                "4. Only true for Abstract classes."};
        for (int i = 0; i < test1.length; i++) {
            assertEquals(test1[i], choice1.getOptions()[i]);
        }
        choice1.setOptions("1. HashMap", "2. TreeMap", "3. HashSet", "4. ArrayList");
        String[] test2 = new String[]{"1. HashMap", "2. TreeMap", "3. HashSet", "4. ArrayList"};
        for (int i = 0; i < test2.length; i++) {
            assertEquals(test2[i], choice1.getOptions()[i]);
        }
    }

    @Test
    void testSetCorrectAns() {
        assertEquals(1, choice1.getCorrectAns());
        choice1.setCorrectAns("2");
        assertEquals(2, choice1.getCorrectAns());
    }
}