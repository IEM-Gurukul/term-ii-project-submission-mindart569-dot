package model;

/**
 * Represents a single expense entry.
 * Demonstrates Encapsulation - all fields are private.
 */
public class Expense {

    // Private fields - can only be accessed via getters/setters
    private int id;
    private double amount;
    private Category category;
    private String description;
    private String date;

    // Constructor - creates a new Expense object
    public Expense(int id, double amount, Category category,
                   String description, String date) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
    }

    // Getters - allow reading private fields
    public int getId() { return id; }
    public double getAmount() { return amount; }
    public Category getCategory() { return category; }
    public String getDescription() { return description; }
    public String getDate() { return date; }

    // Setters - allow updating private fields
    public void setAmount(double amount) { this.amount = amount; }
    public void setCategory(Category category) { this.category = category; }
    public void setDescription(String description) { this.description = description; }
    public void setDate(String date) { this.date = date; }

    /**
     * Overrides toString() to display expense details nicely.
     * This demonstrates Polymorphism - overriding a parent class method.
     */
    @Override
    public String toString() {
        return String.format("[%d] %s | Rs.%.2f | %s | %s",
                id, date, amount, category, description);
    }
}