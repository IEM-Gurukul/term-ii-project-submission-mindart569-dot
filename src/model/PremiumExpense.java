package model;

/**
 * Represents a premium expense with a receipt number.
 * Demonstrates Inheritance - extends Expense class.
 * PremiumExpense IS-A Expense with an extra field.
 */
public class PremiumExpense extends Expense {

    // Extra field that only PremiumExpense has
    private String receiptNumber;

    // Constructor calls parent constructor using super()
    public PremiumExpense(int id, double amount, Category category,
                          String description, String date, String receiptNumber) {
        super(id, amount, category, description, date);
        this.receiptNumber = receiptNumber;
    }

    // Getter for receipt number
    public String getReceiptNumber() {
        return receiptNumber;
    }

    // Setter for receipt number
    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    /**
     * Overrides toString() to include receipt number.
     * Demonstrates Polymorphism - same method, different behavior.
     */
    @Override
    public String toString() {
        return super.toString() + " | Receipt: " + receiptNumber;
    }
}