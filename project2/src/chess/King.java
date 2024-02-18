package chess;

/**
 *  This is the class of King. It extends the Abstract class AbstractChessPiece.
 */
public class King extends AbstractChessPiece{

    /**
     * The default constructor of King with the no given parameters.
     */
    public King() {
        super();
    }

    /**
     * The constructor of King with the no given parameters.
     *
     * @param row   the row of the piece
     * @param col   the col of the piece
     * @param color the color of the piece
     */
    public King(int row, int col, Color color) {
        super(row, col, color);
    }

    /**
     * Determine if the chess piece can move to a given cell.
     *
     * @param row the row where the piece might be moved to.
     * @param col the column where the piece might be moved to.
     * @return True if the piece can move to that location. False otherwise.
     */
    @Override
    public boolean canMove(int row, int col) {
        if (isSamePosition(row, col)) throw new IllegalArgumentException("The target position is the piece itself!");
        return (Math.abs(row - this.getRow()) == 1 || Math.abs(row - this.getRow()) == 0)
                && (Math.abs(col - this.getColumn()) == 1 || Math.abs(col - this.getColumn()) == 0)
                && validPosition(row, col);
    }
}
