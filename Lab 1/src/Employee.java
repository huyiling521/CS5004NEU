import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * This class represents a Employee.
 * The Employee has a name, ID, pay rate and his hours worked within a week.
 */
public class Employee {
    /** Name of the Employee */
    private String name;
    /** ID of the Employee */
    private String ID;
    /** pay rate of the Employee */
    private double payRate;
    /** Weekly working hours of the Employee, will be initialised to 0 */
    private double hoursWorked;

    /**
     * Constructs an Employee object and initializes by
     * the given name, ID, pay rate.
     * His hours worked within a week is initialized to 0.
     * @param name the name of this Employee
     * @param ID the ID of this Employee
     * @param payRate the hourly pay rate of this Employee
     */
    public Employee(String name, String ID, double payRate) {
        this.name = name;
        this.ID = ID;
        this.payRate = payRate;
        this.hoursWorked = 0.0;
    }

    /**
     * Adds the additional hours to the current hours worked of the Employee.
     * Adding "negative" hours is acceptable since it may need to do an "adjustment" on the time,
     * while the hours worked for the week cannot drop below 0.
     * @param newHours the additional hours of working
     */
    public void addHoursWorked(double newHours) {
        if (this.hoursWorked + newHours >= 0) this.hoursWorked = this.hoursWorked + newHours;
        else this.hoursWorked = 0.0;
    }

    /**
     * Resets the employee’s hours worked for the week to zero.
     */
    public void resetHoursWorked() {
        this.hoursWorked = 0.0;
    }

    /**
     * Get the weekly hours worked for the employee.
     * @return the weekly hours worked for the employee.
     */
    public double getHoursWorked() {
        return this.hoursWorked;
    }

    /**
     * Get a new Paycheck object that is initialized
     * with rate and hours worked by the Employee.
     * @return a new Paycheck object based on rate and hours worked by the Employee.
     */
    public Paycheck getWeeklyCheck() {
        return new Paycheck(this.hoursWorked, this.payRate);
    }

    /**
     * Set the String representation of the Employee object
     * @return the String representation of the Employee object
     */
    @Override
    public String toString() {
        Paycheck p = this.getWeeklyCheck();
        return "Name: " + this.name + '\n' + "ID: " + this.ID + '\n' + p.toString();
    }
}
