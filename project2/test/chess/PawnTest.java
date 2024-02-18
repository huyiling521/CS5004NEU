package chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    Pawn white;
    Pawn black;
    @BeforeEach
    void setUp() {
        black = new Pawn(7,7,Color.BLACK);
        white = new Pawn();
    }

    @Test
    void testCanMove() {
        assertTrue(black.canMove(5,7));
        black.setFirstStep(false);
        assertFalse(black.canMove(5,7));
        assertTrue(black.canMove(6,7));

        assertTrue(white.canMove(2,0));
        assertFalse(white.canMove(1,6));
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            white.canMove(0,0);
        });
        assertEquals("The target position is the piece itself!", thrown.getMessage());
    }

    @Test
    void testCanKill() {
        assertTrue(black.canKill(new Pawn(6,6, Color.WHITE)));
        assertFalse(black.canKill(white));
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            black.canKill(new Pawn(4, 7, Color.BLACK));
        });
        assertEquals("The target piece is of the same color!", thrown.getMessage());

        assertFalse(white.canKill(black));
        assertTrue(white.canKill(new Pawn(1, 1, Color.BLACK)));
        thrown = assertThrows(IllegalArgumentException.class, () -> {
            white.canKill(new Pawn(0, 0, Color.BLACK));
        });
        assertEquals("The target position is the piece itself!", thrown.getMessage());
    }
    @Test
    void testMoveTo() {
        assertTrue(black.isFirstStep());
        assertTrue(black.moveTo(5,7));
        assertFalse(black.isFirstStep());
        assertFalse(black.moveTo(3,7));
        assertTrue(black.moveTo(4,7));
    }

    @Test
    void testIsFirstStep() {
        assertTrue(black.isFirstStep());
        assertTrue(black.moveTo(5,7));
        assertFalse(black.isFirstStep());
    }

    @Test
    void testSetFirstStep() {
        assertTrue(black.isFirstStep());
        black.setFirstStep(false);
        assertFalse(black.isFirstStep());
    }
}