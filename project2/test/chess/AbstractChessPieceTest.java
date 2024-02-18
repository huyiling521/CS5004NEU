package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractChessPieceTest {
    AbstractChessPiece bishop;
    AbstractChessPiece king;
    AbstractChessPiece queen;
    AbstractChessPiece pawn;
    AbstractChessPiece rook;
    AbstractChessPiece knight;
    @BeforeEach
    void setUp() {
        bishop = new Bishop(0,2,Color.WHITE);
        king = new King(8,3,Color.BLACK);
        queen = new Queen(0,4,Color.WHITE);
        pawn = new Pawn(7,5,Color.BLACK);
        rook = new Rook(0,7,Color.WHITE);
        knight = new Knight(8,8,Color.BLACK);
    }

    @Test
    void testGetRow() {
        assertEquals(0, bishop.getRow());
        assertEquals(8, king.getRow());
        assertEquals(0, queen.getRow());
        assertEquals(7, pawn.getRow());
        assertEquals(0, rook.getRow());
        assertEquals(8, knight.getRow());
    }

    @Test
    void testGetColumn() {
        assertEquals(2, bishop.getColumn());
        assertEquals(3, king.getColumn());
        assertEquals(4, queen.getColumn());
        assertEquals(5, pawn.getColumn());
        assertEquals(7, rook.getColumn());
        assertEquals(8, knight.getColumn());
    }

    @Test
    void testGetColor() {
        assertEquals(Color.WHITE, bishop.getColor());
        assertEquals(Color.BLACK, king.getColor());
        assertEquals(Color.WHITE, queen.getColor());
        assertEquals(Color.BLACK, pawn.getColor());
        assertEquals(Color.WHITE, rook.getColor());
        assertEquals(Color.BLACK, knight.getColor());
    }

    @Test
    void testCanMove() {
        assertTrue(bishop.canMove(1,3));
        assertFalse(king.canMove(3,7));
        assertTrue(queen.canMove(4,8));
        assertFalse(pawn.canMove(4,7));
        assertTrue(knight.canMove(7,6));
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            rook.canMove(0,7);
        });
        assertEquals("The target position is the piece itself!", thrown.getMessage());
    }

    @Test
    void testCanKill() {
        assertTrue(bishop.canKill(new King(1,3,Color.BLACK)));
        assertFalse(king.canKill(new Pawn(3,7, Color.WHITE)));
        assertTrue(queen.canKill(new Queen(4,8,Color.BLACK)));
        assertFalse(pawn.canKill(new Knight(4,7,Color.WHITE)));
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            knight.canKill(new Rook(4, 7, Color.BLACK));
        });
        assertEquals("The target piece is of the same color!", thrown.getMessage());
        thrown = assertThrows(IllegalArgumentException.class, () -> {
            rook.canKill(new Bishop(0,7,Color.BLACK));
        });
        assertEquals("The target position is the piece itself!", thrown.getMessage());
    }

    @Test
    void testMoveTo() {
        assertEquals(0, bishop.getRow());
        assertEquals(2, bishop.getColumn());
        assertTrue(bishop.moveTo(1,3));
        assertEquals(1, bishop.getRow());
        assertEquals(3, bishop.getColumn());

        assertEquals(8, king.getRow());
        assertEquals(3, king.getColumn());
        assertFalse(king.moveTo(1,5));
        assertEquals(8, king.getRow());
        assertEquals(3, king.getColumn());

        assertEquals(0, rook.getRow());
        assertEquals(7, rook.getColumn());
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            rook.canMove(0,7);
        });
        assertEquals("The target position is the piece itself!", thrown.getMessage());
        assertEquals(0, rook.getRow());
        assertEquals(7, rook.getColumn());
    }

    @Test
    void testValidPosition() {
        assertTrue(AbstractChessPiece.validPosition(0,0));
        assertTrue(AbstractChessPiece.validPosition(5,7));
        assertFalse(AbstractChessPiece.validPosition(-1,7));
        assertFalse(AbstractChessPiece.validPosition(9,9));
    }

    @Test
    void testIsDiagonal() {
        assertTrue(bishop.isDiagonal(1,3));
        assertTrue(king.isDiagonal(7,2));
        assertFalse(queen.isDiagonal(2,5));
        assertFalse(pawn.isDiagonal(2,4));
    }

    @Test
    void testIsVertical() {
        assertTrue(bishop.isVertical(1,2));
        assertTrue(king.isVertical(7,3));
        assertFalse(queen.isVertical(2,5));
        assertFalse(pawn.isVertical(2,4));
    }

    @Test
    void testIsHorizontal() {
        assertTrue(bishop.isHorizontal(0,3));
        assertTrue(king.isHorizontal(8,2));
        assertFalse(queen.isHorizontal(2,5));
        assertFalse(pawn.isHorizontal(2,4));
    }

    @Test
    void testIsSamePosition() {
        assertTrue(bishop.isSamePosition(0,2));
        assertTrue(king.isSamePosition(8,3));
        assertFalse(queen.isSamePosition(2,5));
        assertFalse(pawn.isSamePosition(2,4));
    }

    @Test
    void testIsSameColor() {
        assertTrue(bishop.isSameColor(queen));
        assertTrue(king.isSameColor(pawn));
        assertFalse(bishop.isSameColor(king));
        assertFalse(rook.isSameColor(knight));
    }
}