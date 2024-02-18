package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChessPieceTest {

    ChessPiece bishop;
    ChessPiece king;
    ChessPiece queen;
    ChessPiece pawn;
    ChessPiece rook;
    ChessPiece knight;
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
}