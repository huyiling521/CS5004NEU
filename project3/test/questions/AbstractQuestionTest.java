package questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is the Junit test class of AbstractQuestion abstract class.
 */
class AbstractQuestionTest {

    AbstractQuestion likert;
    AbstractQuestion true1;
    AbstractQuestion false1;

    AbstractQuestion choice;
    AbstractQuestion select;

    @BeforeEach
    void setUp() {
        this.likert = new Likert("You feel confident in programing.");
        this.true1 = new TrueFalse("Java is an Object-Oriented Programing Language.", "TRUE");
        this.false1 = new TrueFalse("Java is easy to learn.", "false");
        this.select = new MultipleSelect(
                "How can I improve my Java skills?",
                "6 1 5 3"
                ,"1. Take course.",
                "2. Always ask ChatGpt.",
                "3. Review explanations",
                "4. Copy others work",
                "5. Regular practice",
                "6. Focus on areas with incorrect answers",
                "7. Cheat on Exam.");
        this.choice = new MultipleChoice(
                "If you update the equals() method for a particular class, you should also update its hashCode() method.",
                "1"
                ,"1. Yes, always.",
                "2. No. The method hashCode() should never be modified.",
                "3. Only when we are using a HashSet.",
                "4. Only true for Abstract classes.");
    }

    @Test
    void testAnswer() {
        assertEquals("Correct", likert.answer("5"));
        assertEquals("Incorrect", likert.answer("9"));
        assertEquals("Correct", true1.answer("TRue"));
        assertEquals("Incorrect", false1.answer("true"));
        assertEquals("Correct", select.answer("6 5 3 1"));
        assertEquals("Incorrect", choice.answer("3"));
    }

    @Test
    void testGetText() {
        assertEquals("You feel confident in programing.", likert.getText());
        assertEquals("Java is an Object-Oriented Programing Language.", true1.getText());
        assertEquals("Java is easy to learn.", false1.getText());
        assertEquals("If you update the equals() method for a particular class, you should also update its hashCode() method.",
                choice.getText());
        assertEquals("How can I improve my Java skills?", select.getText());
    }

    @Test
    void testSetText() {
        assertEquals("You feel confident in programing.", likert.getText());
        likert.setText("N/A");
        assertEquals("N/A", likert.getText());

        assertEquals("Java is easy to learn.", false1.getText());
        false1.setText("Now there is text.");
        assertEquals("Now there is text.", false1.getText());

        assertEquals("If you update the equals() method for a particular class, you should also update its hashCode() method.",
                choice.getText());
        choice.setText("When thinking about equality, what does transitivity mean?");
        assertEquals("When thinking about equality, what does transitivity mean?", choice.getText());

        assertEquals("How can I improve my Java skills?",
                select.getText());
        select.setText("When thinking about equality, what does transitivity mean?");
        assertEquals("When thinking about equality, what does transitivity mean?", select.getText());
    }

    @Test
    void testGetPriority() {
        assertEquals(4, likert.getPriority());
        assertEquals(1, true1.getPriority());
        assertEquals(1, false1.getPriority());
        assertEquals(2, choice.getPriority());
        assertEquals(3, select.getPriority());
    }

    @Test
    void testSetPriority() {
        Exception thrown = assertThrows(IllegalArgumentException.class, () -> {
            likert.setPriority(1);
        });
        assertEquals("Priority is fix to type of question, the modification is denied.", thrown.getMessage());
        assertEquals(4, likert.getPriority());

        thrown = assertThrows(IllegalArgumentException.class, () -> {
            true1.setPriority(4);
        });
        assertEquals("Priority is fix to type of question, the modification is denied.", thrown.getMessage());
        assertEquals(1, true1.getPriority());

        thrown = assertThrows(IllegalArgumentException.class, () -> {
            choice.setPriority(4);
        });
        assertEquals("Priority is fix to type of question, the modification is denied.", thrown.getMessage());
        assertEquals(2, choice.getPriority());

        thrown = assertThrows(IllegalArgumentException.class, () -> {
            select.setPriority(4);
        });
        assertEquals("Priority is fix to type of question, the modification is denied.", thrown.getMessage());
        assertEquals(3, select.getPriority());
    }

    @Test
    void testCompareTo() {
        AbstractQuestion[] test = new AbstractQuestion[]{true1, false1, choice,select,likert};
        for (int i = 0; i < test.length - 1; i++) {
            assertTrue(test[i].compareTo(test[i + 1]) < 0);
        }
        test = new AbstractQuestion[]{choice, likert, true1, false1, select};
        Arrays.sort(test);
        for (int i = 0; i < test.length - 1; i++) {
            assertTrue(test[i].compareTo(test[i + 1]) < 0);
        }
    }
}