package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {

    Queen white;
    Queen black;
    @BeforeEach
    void setUp() {
        black = new Queen(7,7,Color.BLACK);
        white = new Queen();
    }
    @Test
    void testCanMove() {
        assertTrue(black.canMove(6,7));
        assertTrue(black.canMove(6,6));
        assertTrue(black.canMove(7,3));
        assertFalse(black.canMove(4,5));

        assertTrue(white.canMove(0,1));
        assertFalse(white.canMove(1,6));
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            white.canMove(0,0);
        });
        assertEquals("The target position is the piece itself!", thrown.getMessage());
    }

    @Test
    void testCanKill() {
        assertTrue(black.canKill(new Queen(6,7, Color.WHITE)));
        assertTrue(black.canKill(white));
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            black.canKill(new Queen(4, 7, Color.BLACK));
        });
        assertEquals("The target piece is of the same color!", thrown.getMessage());

        assertTrue(white.canKill(black));
        assertTrue(white.canKill(new Queen(1, 1, Color.BLACK)));
        thrown = assertThrows(IllegalArgumentException.class, () -> {
            white.canKill(new Queen(0, 0, Color.BLACK));
        });
        assertEquals("The target position is the piece itself!", thrown.getMessage());
    }
}