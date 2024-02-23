package questions;

import java.util.Arrays;

/**
 * This Class of a MultipleSelect Object.
 */
public class MultipleSelect extends AbstractQuestion{
    private String[] options;
    private final static int DEFUALTPRIORITY = 3;
    private String correctAns;


    /**
     * Default constructor to create a MultipleChoice object.
     * Message indication invalid question is printed.
     */
    public MultipleSelect() {
        super();
        this.correctAns = "";
        this.options = new String[0];
        this.setPriority(DEFUALTPRIORITY);
    }

    /**
     * Constructor of a MultipleChoice object
     * @param text the text of the question
     * @param correctAns the correct answer
     * @param options the options of the question
     */
    public MultipleSelect(String text, String correctAns, String... options) {
        super(text);
        if (options.length < 3 || options.length > 8) throw new IllegalArgumentException("The options are not valid.");
        this.options = options;
        this.correctAns = checkValidAnswer(correctAns);
        this.setPriority(DEFUALTPRIORITY);
    }

    /**
     * Check if the given answer is in a valid pattern,
     * returns its corresponding String representation,
     * as a String of sorted integers of option numbers.
     *
     * @param answer the given answer to check validation
     * @return returns a String representation of sorted integers of option numbers.
     */
    private String checkValidAnswer(String answer) {
        String[] correctAnsBreak = answer.split(" ");
        if (correctAnsBreak.length < 1 || correctAnsBreak.length > options.length) throw new NumberFormatException("No valid answer is provided.");
        int[] correctAnsInt = new int[correctAnsBreak.length];
        for (int i = 0; i <correctAnsBreak.length; i++) {
            try {
                correctAnsInt[i] = Integer.parseInt(correctAnsBreak[i]);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("The answer is not valid.");
            }
        }
        Arrays.sort(correctAnsInt);
        StringBuilder b = new StringBuilder();
        for (int i : correctAnsInt) b.append(i);
        return b.toString();
    }

    /**
     * Check if the given answer matches the correct answer.
     *
     * @param answer
     * @return true if the answer corresponds to the correct one
     */
    private boolean isCorrect(String answer) {
        int ans;
        String answerCheck = checkValidAnswer(answer);
        return answerCheck.equals(this.correctAns);
    }

    /**
     * Set the options of the question
     * @param options
     */
    public void setOptions(String... options) {
        if (options.length < 3 || options.length > 8) throw new IllegalArgumentException("The options are not valid.");
        this.options = options;
    }
    /**
     * Determines if the answer is correct for a given question. If the answer is
     * correct, this method returns "Correct"; and "Incorrect" otherwise.
     *
     * @param answer the answer given
     * @return "Correct" or "Incorrect"
     */
    @Override
    public String answer(String answer) {
        return isCorrect(answer)? CORRECT : INCORRECT;
    }

    /**
     * Sets the priority of the question.
     *
     * @param priority target priority to set to the question.
     */
    @Override
    public void setPriority(int priority) {
        super.setPriority(DEFUALTPRIORITY);
        if (priority != DEFUALTPRIORITY) throw new IllegalArgumentException("Priority is fix to type of question, the modification is denied.");
    }


    /**
     * Sets the correct answer of the question.
     *
     * @param correctAns correct answer to set to the question.
     */
    public void setCorrectAns(String correctAns) {
        this.correctAns = checkValidAnswer(correctAns);
    }

    /**
     * Returns the options of the question.
     *
     * @return the options
     */
    public String[] getOptions() {
        return options;
    }

    /**
     * Returns the correct answer of the question.
     *
     * @return the correctAns
     */
    public String getCorrectAns() {
        return correctAns;
    }
}
