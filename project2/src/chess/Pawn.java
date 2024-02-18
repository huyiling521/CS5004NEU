package chess;

/**
 *  This is the class of Pawn. It extends the Abstract class AbstractChessPiece.
 */
public class Pawn extends AbstractChessPiece {
    private boolean firstStep;

    /**
     * The default constructor of Pawn with the no given parameters.
     */
    public Pawn() {
        super();
        firstStep = true;
    }

    /**
     * The constructor of Pawn with the no given parameters.
     *
     * @param row   the row of the piece
     * @param col   the col of the piece
     * @param color the color of the piece
     */
    public Pawn(int row, int col, Color color) {
        super(row, col, color);
        firstStep = true;
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
        if (isFirstStep()) {
            if (this.getColor().equals(Color.BLACK)) return isVertical(row, col)
                    && (this.getRow() - row == 1 || this.getRow() - row == 2);
            else return isVertical(row, col)
                    && (row - this.getRow() == 1 || row - this.getRow()== 2);
        } else {
            if (this.getColor().equals(Color.BLACK)) return isVertical(row, col)
                    && this.getRow() - row == 1;
            else return isVertical(row, col)
                    && row - this.getRow() == 1;
        }
    }

    /**
     * Determine of the piece can kill another piece starting from its current location.
     *
     * @param piece the piece that might be killed.
     * @return True if the new piece can be killed.
     */
    @Override
    public boolean canKill(ChessPiece piece) {
        if (isSameColor(piece)) throw new IllegalArgumentException("The target piece is of the same color!");
        if (isSamePosition(piece.getRow(), piece.getColumn())) throw new IllegalArgumentException("The target position is the piece itself!");
        if (this.getColor().equals(Color.BLACK)) {
            return isDiagonal(piece.getRow(), piece.getColumn()) && this.getRow() - piece.getRow() == 1;
        } else return isDiagonal(piece.getRow(), piece.getColumn()) && piece.getRow() - this.getRow() == 1;
    }

    /**
     * Move the piece to the given pawn piece
     * This is override based on the first step rule
     *
     * @param row the row of the position to move to
     * @param col the col of the position to move to
     * @return
     */
    @Override
    public boolean moveTo(int row, int col) {
        if (super.moveTo(row, col)) {
            firstStep = false;
            return true;
        }
        return false;
    }

    /**
     * Return if this is the first step of pawn
     *
     * @return true if it is the first step of pawn
     */
    protected boolean isFirstStep() {
        return firstStep;
    }

    /**
     * Set the value of the firststep
     * @param firstStep the value to be set to firststep
     */
    public void setFirstStep(boolean firstStep) {
        this.firstStep = firstStep;
    }
}
