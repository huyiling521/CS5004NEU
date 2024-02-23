package questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is the Junit test class of MultipleSelect class.
 */
class MultipleSelectTest {

    MultipleSelect select1;
    MultipleSelect select2;
    MultipleSelect select3;

    @BeforeEach
    void setUp() {
        this.select1 = new MultipleSelect(
                "How can I improve my Java skills?",
                "6 1 5 3"
                ,"1. Take course.",
                "2. Always ask ChatGpt.",
                "3. Review explanations",
                "4. Copy others work",
                "5. Regular practice",
                "6. Focus on areas with incorrect answers",
                "7. Cheat on Exam.");
        this.select2 = new MultipleSelect("Which of the following DOES NOT allows duplicate entries?",
                "3 1 2",
                "1. HashMap", "2. TreeMap", "3. HashSet", "4. List", "5. Array");
        this.select3 = new MultipleSelect();
    }

    @Test
    void testConstructor() {
        Exception thrown = assertThrows(IllegalArgumentException.class, () -> {
            MultipleSelect test = new MultipleSelect("Java is easy to learn.", "2");
        });
        assertEquals("The options are not valid.", thrown.getMessage());

        thrown = assertThrows(IllegalArgumentException.class, () -> {
            MultipleSelect test = new MultipleSelect("Java is easy to learn.", "envoi3d", "1", "2", "3");
        });
        assertEquals("The answer is not valid.", thrown.getMessage());
    }
    @Test
    void testAnswer() {
        assertEquals("Correct", select1.answer("1 3 5 6"));
        assertEquals("Incorrect", select1.answer("2 1 3"));
        assertEquals("Incorrect", select1.answer("1 3"));
        assertEquals("Correct", select2.answer("1 2 3"));
        assertEquals("Incorrect", select2.answer("3"));
    }

    @Test
    void testGetText() {
        assertEquals("How can I improve my Java skills?", select1.getText());
        assertEquals("Which of the following DOES NOT allows duplicate entries?", select2.getText());
        assertEquals("N/A", select3.getText());
    }

    @Test
    void testSetText() {
        assertEquals("N/A", select3.getText());
        select3.setText("When thinking about equality, what does transitivity mean?");
        assertEquals("When thinking about equality, what does transitivity mean?", select3.getText());
    }

    @Test
    void testGetPriority() {
        assertEquals(3, select1.getPriority());
        assertEquals(3, select2.getPriority());
        assertEquals(3, select3.getPriority());
    }

    @Test
    void testSetPriority() {
        Exception thrown = assertThrows(IllegalArgumentException.class, () -> {
            select1.setPriority(4);
        });
        assertEquals("Priority is fix to type of question, the modification is denied.", thrown.getMessage());
        assertEquals(3, select1.getPriority());
    }

    @Test
    void testCompareTo() {
        assertTrue(select1.compareTo(select2) < 0);
        assertTrue(select2.compareTo(select3) > 0);
    }

    @Test
    void testGetOptions() {
        String[] test1 = new String[]{"1. Take course.",
                "2. Always ask ChatGpt.",
                "3. Review explanations",
                "4. Copy others work",
                "5. Regular practice",
                "6. Focus on areas with incorrect answers",
                "7. Cheat on Exam."};
        for (int i = 0; i < test1.length; i++) {
            assertEquals(test1[i], select1.getOptions()[i]);
        }
    }

    @Test
    void testGetCorrectAns() {
        assertEquals("1356", select1.getCorrectAns());
        assertEquals("123", select2.getCorrectAns());
    }

    @Test
    void testSetOptions() {
        String[] test1 = new String[]{"1. Take course.",
                "2. Always ask ChatGpt.",
                "3. Review explanations",
                "4. Copy others work",
                "5. Regular practice",
                "6. Focus on areas with incorrect answers",
                "7. Cheat on Exam."};
        for (int i = 0; i < test1.length; i++) {
            assertEquals(test1[i], select1.getOptions()[i]);
        }
        select1.setOptions("1. HashMap", "2. TreeMap", "3. HashSet", "4. ArrayList");
        String[] test2 = new String[]{"1. HashMap", "2. TreeMap", "3. HashSet", "4. ArrayList"};
        for (int i = 0; i < test2.length; i++) {
            assertEquals(test2[i], select1.getOptions()[i]);
        }
    }

    @Test
    void testSetCorrectAns() {
        assertEquals("1356", select1.getCorrectAns());
        select1.setCorrectAns("2 7 6");
        assertEquals("267", select1.getCorrectAns());
    }
}