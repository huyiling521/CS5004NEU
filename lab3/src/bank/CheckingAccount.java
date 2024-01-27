package bank;

/**
 * This is the CheckingAccount class representing a checking account object,
 * that implements IAccount Interface.
 */
public class CheckingAccount implements IAccount{
    private double balance;
    private boolean penalty;

    /**
     * The constructor of CheckingAccount that creates the account
     * with the given amount of money representing the balance of the account.
     * @param amount the given amount of money representing the starter deposit.
     */
    public CheckingAccount(double amount) {
        if (amount >= 0.01) {
            this.balance = amount;
            isPenalty();
        }
        else throw new IllegalArgumentException("The starter deposit must be no less than 0.01.");
    }

    /**
     * Adds the given deposit to the account.
     * @param amount the given amount of money representing the deposit to be added.
     */
    @Override
    public void deposit(double amount) {
        isPenalty();
        if (amount >= 0) this.balance += amount;
        else throw new IllegalArgumentException("The deposit must be no less than 0.00.");
    }

    /**
     * Withdraws the money from the account.
     * @param amount the given amount representing the money to be withdrawn.
     * @return boolean representing whether the process is successful.
     */
    @Override
    public boolean withdraw(double amount) {
        if (amount >= 0 && amount <= this.balance) {
            this.balance -= amount;
            isPenalty();
            return true;
        }
        return false;
    }

    /**
     * Getter of the attribute of balance.
     * @return balance
     */
    @Override
    public double getBalance() {
        return this.balance;
    }

    /**
     * Getter of the attribute of penalty.
     * @return penalty status
     */
    public boolean getPenalty() {
        return this.penalty;
    }
    /**
     * Performs the monthly maintenance based on the penalty status.
     */
    @Override
    public void performMonthlyMaintenance() {
        isPenalty();
        if (this.penalty) this.balance -= 5;
        this.penalty = false;
    }

    /**
     * Creates String representation of the SavingAccount.
     * @return a String representation of the SavingAccount.
     */
    @Override
    public String toString() {
        return String.format("The account balance is: $ %.2f.", this.balance);
    }

    /**
     * Check the penalty status of the account.
     */
    private void isPenalty() {
        if (this.balance < 100) this.penalty = true;
    }
}
