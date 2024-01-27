package bank;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {

    SavingsAccount c;
    @BeforeEach
    void setUp() {
        this.c = new SavingsAccount(300);
    }

    @Test
    void testConstructor() {
        assertEquals(300, c.getBalance());
        assertEquals(0, c.getMonthlyWithdrawTimes());
        assertFalse(c.getPenalty());

        IllegalArgumentException thrown1 = assertThrows(IllegalArgumentException.class, () -> {
            SavingsAccount s1 = new SavingsAccount(0.001);
        });
        assertEquals("The starter deposit must be no less than 0.01.", thrown1.getMessage());

        IllegalArgumentException thrown2 = assertThrows(IllegalArgumentException.class, () -> {
            SavingsAccount s2 = new SavingsAccount(-10);
        });
        assertEquals("The starter deposit must be no less than 0.01.", thrown2.getMessage());
    }
    @Test
    void testDeposit() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            c.deposit(-100);
        });
        assertEquals("The deposit must be no less than 0.00.", thrown.getMessage());

        c.deposit(1000);
        assertEquals(1300, c.getBalance());
    }

    @Test
    void testWithdraw() {
        assertFalse(c.withdraw(-300));
        assertEquals(0, c.getMonthlyWithdrawTimes());

        assertTrue(c.withdraw(50.45));
        assertEquals(1, c.getMonthlyWithdrawTimes());
        assertEquals(249.55, c.getBalance());
        assertFalse(c.getPenalty());

        assertTrue(c.withdraw(5.45));
        assertEquals(2, c.getMonthlyWithdrawTimes());
        assertEquals(244.1, c.getBalance(),6);
        assertFalse(c.getPenalty());

        for (int i = 0; i < 4; i++) {
            assertTrue(c.withdraw(1));
            assertEquals(243.1 - i, c.getBalance(), 6);
            assertFalse(c.getPenalty());
        }

        assertTrue(c.withdraw(1));
        assertTrue(c.getPenalty());
    }

    @Test
    void testGetBalance() {
        c.deposit(100);
        assertEquals(400, c.getBalance());

        c.withdraw(250);
        assertEquals(150, c.getBalance());
    }

    @Test
    void testPerformMonthlyMaintenance() {
        assertEquals(0, c.getMonthlyWithdrawTimes());
        assertFalse(c.getPenalty());
        for (int i = 0; i < 7; i++) {
            assertTrue(c.withdraw(1));
        }
        assertTrue(c.getPenalty());
        c.performMonthlyMaintenance();
        assertFalse(c.getPenalty());
        assertEquals(279, c.getBalance());
    }

    @Test
    void testToString() {
        assertEquals("The account balance is: $ 300.00.", c.toString());
    }
}