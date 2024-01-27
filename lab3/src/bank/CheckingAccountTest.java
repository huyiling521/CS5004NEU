package bank;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckingAccountTest {

    CheckingAccount s;
    @BeforeEach
    void setUp() throws Exception {
        this.s = new CheckingAccount(300);
    }

    @Test
    void testConstructor() {
        assertEquals(300, s.getBalance());
        assertFalse(s.getPenalty());

        IllegalArgumentException thrown1 = assertThrows(IllegalArgumentException.class, () -> {
            CheckingAccount s1 = new CheckingAccount(0.001);
        });
        assertEquals("The starter deposit must be no less than 0.01.", thrown1.getMessage());

        IllegalArgumentException thrown2 = assertThrows(IllegalArgumentException.class, () -> {
            CheckingAccount s2 = new CheckingAccount(-10);
        });
        assertEquals("The starter deposit must be no less than 0.01.", thrown2.getMessage());
    }
    @Test
    void testDeposit() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            s.deposit(-100);
        });
        assertEquals("The deposit must be no less than 0.00.", thrown.getMessage());

        s.deposit(1000);
        assertEquals(1300, s.getBalance());
    }

    @Test
    void testWithdraw() {
        assertFalse(s.withdraw(-300));

        assertTrue(s.withdraw(50.45));
        assertEquals(249.55, s.getBalance());
        assertFalse(s.getPenalty());

        assertTrue(s.withdraw(5.45));
        assertEquals(244.1, s.getBalance(),6);
        assertFalse(s.getPenalty());

        assertTrue(s.withdraw(200.9));
        assertEquals(43.2, s.getBalance(),6);
        assertTrue(s.getPenalty());
    }

    @Test
    void testGetBalance() {
        s.deposit(100);
        assertEquals(400, s.getBalance());

        s.withdraw(250);
        assertEquals(150, s.getBalance());
    }

    @Test
    void testPerformMonthlyMaintenance() {
        assertFalse(s.getPenalty());
        s.withdraw(250);
        assertTrue(s.getPenalty());
        s.performMonthlyMaintenance();
        assertFalse(s.getPenalty());
        assertEquals(45, s.getBalance());
        s.performMonthlyMaintenance();
        assertFalse(s.getPenalty());
        assertEquals(40, s.getBalance());
    }

    @Test
    void testToString() {
        assertEquals("The account balance is: $ 300.00.", s.toString());
        s.withdraw(50.11112);
        assertEquals("The account balance is: $ 249.89.", s.toString());
    }
}