package chess;

/**
 *  This is the class of Bishop. It extends the Abstract class AbstractChessPiece.
 */
public class Bishop extends AbstractChessPiece{
    /**
     * The default constructor of Bishop with the no given parameters.
     */
    public Bishop() {
        super();
    }

    /**
     * The constructor of Bishop with the no given parameters.
     *
     * @param row   the row of the piece
     * @param col   the col of the piece
     * @param color the color of the piece
     */
    public Bishop(int row, int col, Color color) {
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
        return isDiagonal(row, col) && validPosition(row, col);
    }
}
