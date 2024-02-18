package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {
    Bishop white;
    Bishop black;
    @BeforeEach
    void setUp() {
        black = new Bishop(7,7,Color.BLACK);
        white = new Bishop();
    }

    @Test
    void testCanMove() {
        assertTrue(black.canMove(2,2));
        assertTrue(black.canMove(0,0));
        assertFalse(black.canMove(4,7));

        assertTrue(white.canMove(2,2));
        assertFalse(white.canMove(1,6));
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            white.canMove(0,0);
        });
        assertEquals("The target position is the piece itself!", thrown.getMessage());
    }

    @Test
    void testCanKill() {
        assertTrue(black.canKill(new Bishop(2,2, Color.WHITE)));
        assertTrue(black.canKill(white));
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            black.canKill(new Bishop(4, 7, Color.BLACK));
        });
        assertEquals("The target piece is of the same color!", thrown.getMessage());

        assertTrue(white.canKill(black));
        assertFalse(white.canKill(new Bishop(4, 7, Color.BLACK)));
        thrown = assertThrows(IllegalArgumentException.class, () -> {
            white.canKill(new Bishop(0, 0, Color.BLACK));
        });
        assertEquals("The target position is the piece itself!", thrown.getMessage());
    }
}