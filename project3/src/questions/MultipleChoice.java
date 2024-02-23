package questions;

/**
 * This Class of a MultipleChoice Object.
 */
public class MultipleChoice extends AbstractQuestion{
    private String[] options;
    private final static int DEFUALTPRIORITY = 2;
    private int correctAns;

    /**
     * Default constructor to create a MultipleChoice object.
     * Message indication invalid question is printed.
     */
    public MultipleChoice() {
        super();
        this.correctAns = -1;
        this.options = new String[0];
        this.setPriority(DEFUALTPRIORITY);
    }

    /**
     * Constructor of a MultipleChoice object
     *
     * @param text the text of the question
     * @param correctAns the correct answer
     * @param options the options of the question
     */
    public MultipleChoice(String text, String correctAns, String... options) {
        super(text);
        setOptions(options);
        setCorrectAns(correctAns);
        this.setPriority(DEFUALTPRIORITY);
    }

    /**
     * Check if the given answer is in a valid pattern,
     * returns its corresponding integer representation.
     *
     * @param answer the given answer to check validation
     * @return returns a integer representation the correct option number.
     */
    private int checkValidAnswer(String answer) {
        int answerInt;
        try {
            answerInt = Integer.parseInt(answer);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("No valid answer is provided.");
        }
        return answerInt;
    }

    /**
     * Check if the given answer matches the correct answer.
     *
     * @param answer
     * @return true if the answer corresponds to the correct one
     */
    private boolean isCorrect(String answer) {
        int ans;
        try {
            ans = Integer.parseInt(answer);
        } catch (NumberFormatException e) {
            return false;
        }
        return ans == correctAns;
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
     * Sets the options of the question.
     *
     * @param options options to set to the question.
     */
    public void setOptions(String... options) {
        if (options.length < 3 || options.length > 8) throw new IllegalArgumentException("The options are not valid.");
        else this.options = options;
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
    public int getCorrectAns() {
        return correctAns;
    }
}
