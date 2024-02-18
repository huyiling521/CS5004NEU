package chess;

import org.javatuples.Pair;

/**
 *  AbstractChessPiece class.
 *  This is the abstract superclass of all chess piece concrete classes. It implements the
 *  ChessPiece interface and serves as the "repository" of reuse code for certain common services.
 */
public abstract class AbstractChessPiece implements ChessPiece{

    private int row, col;
    private Color color;
    private static final int BOARDSIZE = 8;

    /**
     * The default constructor of AbstractChessPiece with the no given parameters.
     */
    public AbstractChessPiece() {
        this(0,0, Color.WHITE);
    }

    /**
     * The constructor of AbstractChessPiece with the given parameters.
     * @param row the row of the piece
     * @param col the col of the piece
     * @param color the color of the piece
     */
    public AbstractChessPiece(int row, int col, Color color) {
        this.row = row;
        this.col = col;
        this.color = color;
    }

    /**
     * Return the current row of the chess piece.
     *
     * @return the row of the current piece.
     */
    @Override
    public int getRow() {
        return this.row;
    }

    /**
     * Return the current column of the chess piece.
     *
     * @return the column of the current chess piece.
     */
    @Override
    public int getColumn() {
        return this.col;
    }

    /**
     * Get the color of the chess piece.
     *
     * @return the color of the chess piece (black or white).
     */
    @Override
    public Color getColor() {
        return this.color;
    }

    /**
     * Set the row of the chess piece.
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * Set the col of the chess piece.
     */
    public void setCol(int col) {
        this.col = col;
    }

    /**
     * Set the color of the chess piece(black or white).
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Move the piece to the given row and col.
     * @param row the row of the position to move to
     * @param col the col of the position to move to
     */
    public boolean moveTo(int row, int col) {
        if (canMove(row, col)) {
            setRow(row);
            setCol(col);
            return true;
        }
        return false;
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
        return false;
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
        return canMove(piece.getRow(), piece.getColumn());
    }

    /**
     * Check if the position is a valid position on a chess board.
     * @param row the row of given position
     * @param col the column of given position
     * @return
     */
    public static boolean validPosition(int row, int col) {
        return row <= BOARDSIZE && row >=0
                && col <= BOARDSIZE && col >= 0;
    }

    /**
     * Check if the position is valid for a diagonal move
     * @param row the row of destination position
     * @param col the column of destination position
     * @return
     */
    protected boolean isDiagonal(int row, int col) {
        return Math.abs(row - this.row) == Math.abs(col - this.col);
    }

    /**
     * Check if the position is valid for a vertical move
     * @param row the row of destination position
     * @param col the column of destination position
     * @return
     */
    protected boolean isVertical(int row, int col) {
        return Math.abs(col - this.col) == 0;
    }

    /**
     * Check if the position is valid for a horizontal move
     * @param row the row of destination position
     * @param col the column of destination position
     * @return
     */
    protected boolean isHorizontal(int row, int col) {
        return Math.abs(row - this.row) == 0;
    }

    /**
     * Check if the position is the piece's current position
     * @param row the row of position
     * @param col the column of position
     * @return
     */
    protected boolean isSamePosition(int row, int col) {
        return col == this.col && row == this.row;
    }

    /**
     * Check if the given piece is of the same color
     * @param piece the given piece to check
     * @return
     */
    protected boolean isSameColor(ChessPiece piece) {
        return this.color.equals(piece.getColor());
    }

}
