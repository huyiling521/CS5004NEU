package questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is the Junit test class of Question interface.
 */
class QuestionTest {

    Question likert;
    Question true1;
    Question false1;

    Question choice;
    Question select;
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
}