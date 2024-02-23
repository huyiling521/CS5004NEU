package questions;

/**
 * This Class of a Likert Object.
 */
public class Likert extends AbstractQuestion{
    final static int DEFUALTPRIORITY = 4;

    /**
     * Default constructor to create a TrueFalse object.
     * Message indication invalid question is printed.
     */
    public Likert() {
        super();
        this.setPriority(DEFUALTPRIORITY);
    }

    /**
     * Constructor of a Likert object
     * @param text the text of the question
     */
    public Likert(String text) {
        super(text);
        this.setPriority(DEFUALTPRIORITY);
    }

    /**
     * Check if the given answer matches the correct answer.
     * @param answer
     * @return true if the answer corresponds to the correct one
     */
    private boolean isCorrect(int answer) {
        return answer >= 1 && answer <= 5;
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
        int num;
        try {
            num = Integer.parseInt(answer);
        } catch (NumberFormatException e) {
            return(INCORRECT);
        }
        return isCorrect(num)? CORRECT : INCORRECT;
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
}
