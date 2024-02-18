package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class KnightTest {


    Knight white;
    Knight black;
    @BeforeEach
    void setUp() {
        black = new Knight(7,7,Color.BLACK);
        white = new Knight();
    }

    @Test
    void testCanMove() {
        assertTrue(black.canMove(5,8));
        assertTrue(black.canMove(6,5));
        assertFalse(black.canMove(4,7));

        assertTrue(white.canMove(1,2));
        assertFalse(white.canMove(1,6));
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            white.canMove(0,0);
        });
        assertEquals("The target position is the piece itself!", thrown.getMessage());
    }

    @Test
    void testCanKill() {
        assertTrue(black.canKill(new Knight(5,8, Color.WHITE)));
        assertFalse(black.canKill(white));
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            black.canKill(new Knight(4, 7, Color.BLACK));
        });
        assertEquals("The target piece is of the same color!", thrown.getMessage());

        assertFalse(white.canKill(black));
        assertTrue(white.canKill(new Knight(1, 2, Color.BLACK)));
        thrown = assertThrows(IllegalArgumentException.class, () -> {
            white.canKill(new Knight(0, 0, Color.BLACK));
        });
        assertEquals("The target position is the piece itself!", thrown.getMessage());
    }
}