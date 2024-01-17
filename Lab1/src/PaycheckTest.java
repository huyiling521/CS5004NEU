import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A JUnit test class for the Paycheck class
 */
class PaycheckTest {
    /**
     *
     */
    private Paycheck check1;
    private Paycheck check2;
    private Paycheck check3;
    @BeforeEach
    void setUp() {
        this.check1 = new Paycheck(40, 19.567790);
        this.check2 = new Paycheck(20, 16.5);
        this.check3 = new Paycheck(50, 19.567790);
    }

    @Test
    void getPayAfterTaxes() {
        assertEquals(665.30486, this.check1.getPayAfterTaxes());
        assertEquals(297.0, this.check2.getPayAfterTaxes());
        assertEquals(914.7941825, this.check3.getPayAfterTaxes());
    }

    @Test
    void testToString() {
        assertEquals("Payment after taxes: $ 665.31", this.check1.toString());
        assertEquals("Payment after taxes: $ 297.00", this.check2.toString());
        assertEquals("Payment after taxes: $ 914.80", this.check3.toString());
    }
}