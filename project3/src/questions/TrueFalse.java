package questions;

/**
 * This Class of a TrueFalse Object.
 */
public class TrueFalse extends AbstractQuestion{
    private final static int DEFUALTPRIORITY = 1;
    private boolean correctAns;

    /**
     * Default constructor to create a TrueFalse object.
     * Message indication invalid question is printed.
     */
    public TrueFalse() {
        super();
        this.correctAns = false;
        this.setPriority(DEFUALTPRIORITY);
    }

    /**
     * Constructor of a TrueFalse object
     * @param text the text of the question
     * @param correctAns the correct answer
     */
    public TrueFalse(String text, String correctAns) {
        super(text);
        this.correctAns = checkValidAnswer(correctAns);
        this.setPriority(DEFUALTPRIORITY);
    }

    /**
     * Check if the given answer is in a valid pattern,
     * returns its corresponding boolean value.
     *
     * @param answer the given answer to check validation
     * @return true if the given answer is a valid string of true,
     *          false if the given answer is a valid string of false,
     *          otherwise throw IllegalArgumentException.
     */
    private static boolean checkValidAnswer(String answer) {
        if (answer.toLowerCase().equals("true")) return true;
        else if (answer.toLowerCase().equals("false")) return false;
        else throw new IllegalArgumentException("No valid answer is provided.");
    }

    /**
     * Check if the given answer matches the correct answer.
     * @param answer
     * @return true if the answer corresponds to the correct one
     */
    private boolean isCorrect(String answer) {
        return answer.toLowerCase().equals(Boolean.toString(correctAns));
    }

    /**
     * Sets the correct answer of the question
     * @param correctAns the correct answer
     */
    public void setCorrectAns(String correctAns) {
        this.correctAns = checkValidAnswer(correctAns);
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
     * Returns the correct answer of the question.
     *
     * @return the correctAns
     */
    public boolean getCorrectAns() {
        return correctAns;
    }
}
