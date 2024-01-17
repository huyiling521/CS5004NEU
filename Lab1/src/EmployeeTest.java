import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
/**
 * A JUnit test class for the Employee class
 */
class EmployeeTest {
    private Employee tom;
    @BeforeEach
    public void setUp() {
        this.tom = new Employee("Tom Smith", "23456", 19.5);
    }
    @Test
    public void testAddHoursWorked() {
        this.tom.addHoursWorked(-3.6);
        assertEquals(0, this.tom.getHoursWorked());
        this.tom.addHoursWorked(3.6);
        assertEquals(3.6, this.tom.getHoursWorked());
        this.tom.addHoursWorked(20);
        assertEquals(23.6, this.tom.getHoursWorked());
        this.tom.addHoursWorked(-200);
        assertEquals(0, this.tom.getHoursWorked());
    }

    @Test
    public void testResetHoursWorked() {
        this.tom.addHoursWorked(3.6);
        assertEquals(3.6, this.tom.getHoursWorked());
        this.tom.resetHoursWorked();
        assertEquals(0, this.tom.getHoursWorked());
    }

    @Test
    public void testGetHoursWorked() {
        assertEquals(0, this.tom.getHoursWorked());
        this.tom.addHoursWorked(10.5);
        assertEquals(10.5, this.tom.getHoursWorked());

    }

    @Test
    public void testGetWeeklyCheck() {
        this.tom.addHoursWorked(40);
        Paycheck p = this.tom.getWeeklyCheck();
        assertEquals(663.0, p.getPayAfterTaxes());
    }

    @Test
    public void testToString() {
        this.tom.addHoursWorked(40);
        assertEquals("Name: Tom Smith\nID: 23456\nPayment after taxes: $ 663.00", this.tom.toString());
    }
}