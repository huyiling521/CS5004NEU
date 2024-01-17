import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * This class represents a Paycheck object.
 * The Paycheck has a total pay initialized by the given weekly working hours and pay rate.
 */
public class Paycheck {
    /** Total payment of the Paycheck object */
    private double totalPay;

    /**
     * Constructs an Paycheck object, set the totalPay by the given weekly working hours and pay rate.
     * If the number of hours worked is 40 or less, totalPay is based as rate * hours;
     * If the hours worked exceeds 40,
     * the totalPay applies an overtime rate of 1.5x for all of the hours in excess of 40.
     * @param hoursWorked the given weekly working hours
     * @param payRate the given pay rate.
     */
    public Paycheck(double hoursWorked, double payRate) {
        if (hoursWorked <= 40) this.totalPay = hoursWorked * payRate;
        else this.totalPay = 40 * payRate + (hoursWorked - 40) * payRate * 1.5;
    }

    /**
     * Calculate the actual payment after considering tax.
     * If the totalPay is less than $400, deduct 10% as tax;
     * If the totalPay is $400 or more, deduct 15% as tax.
     * @return the actual payment after deducting tax.
     */
    public double getPayAfterTaxes() {
        if (this.totalPay >= 400) return this.totalPay * 0.85;
        else return this.totalPay * 0.9;
    }

    /**
     * Set the String representation of the Paycheck object
     * @return the String representation of the Paycheck object
     */
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("$ 0.00",new DecimalFormatSymbols(Locale.US));
        df.setRoundingMode(RoundingMode.UP);
        return "Payment after taxes: " + df.format(this.getPayAfterTaxes());
    }
}
