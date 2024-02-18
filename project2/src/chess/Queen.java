package chess;

/**
 *  This is the class of Queen. It extends the Abstract class AbstractChessPiece.
 */
public class Queen extends AbstractChessPiece{

    /**
     * The default constructor of Queen with the no given parameters.
     */
    public Queen() {
        super();
    }

    /**
     * The constructor of Queen with the no given parameters.
     *
     * @param row   the row of the piece
     * @param col   the col of the piece
     * @param color the color of the piece
     */
    public Queen(int row, int col, Color color) {
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
        return (isDiagonal(row, col) || isHorizontal(row, col) || isVertical(row, col))
                && validPosition(row, col);
    }
}
