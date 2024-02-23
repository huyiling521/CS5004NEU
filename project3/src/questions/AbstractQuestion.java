package questions;

/**
 * This an Abstract Class of a AbstractQuestion Object.
 */
public class AbstractQuestion implements Question{

    private String text;
    private int priority;

    /**
     * Default constructor to create a AbstractQuestion object.
     * Message indication invalid question is printed.
     */
    public AbstractQuestion() {
        this("N/A");
        System.out.println("No text set to the question. This question is currently invalid.");
    }

    /**
     * Constructor of a AbstractQuestion object
     * @param text the text of the question
     */
    public AbstractQuestion(String text) {
        this.text = text;
        this.priority = -1;
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
        return null;
    }

    /**
     * Returns the text of the question.
     *
     * @return the text
     */
    @Override
    public String getText() {
        return this.text;
    }

    /**
     * Sets the text of the question.
     *
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Returns the priority of the question.
     *
     * @return the priority
     */
    public int getPriority() {
        return this.priority;
    }


    /**
     * Sets the priority of the question.
     *
     * @param priority target priority to set to the question.
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * @param other the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Question other) {
        if (other == null) throw new NullPointerException("The input is not a valid Question object!");
        if (!(other instanceof AbstractQuestion)) throw new ClassCastException("The is not a valid Question set to get compared!");
        AbstractQuestion o = (AbstractQuestion) other;
        return (this.priority == o.getPriority())?
                this.getText().compareTo(o.getText()) : this.priority - o.getPriority();
    }
}
