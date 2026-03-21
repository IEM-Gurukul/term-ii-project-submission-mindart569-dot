package manager;

import exception.InvalidExpenseException;
import model.Category;
import model.Expense;
import storage.FileStorage;
import storage.StorageHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages all expense operations.
 * Contains core business logic of the application.
 * Demonstrates Collections usage with ArrayList.
 */
public class ExpenseManager {

    private List<Expense> expenses;
    private StorageHandler storage;
    private int nextId;

    public ExpenseManager() {
        storage = new FileStorage();
        expenses = storage.loadExpenses();
        nextId = expenses.isEmpty() ? 1 : expenses.get(expenses.size() - 1).getId() + 1;
    }

    /**
     * Adds a new expense after validating input.
     * Throws InvalidExpenseException for bad data.
     */
    public void addExpense(double amount, Category category,
                           String description, String date) {
        if (amount <= 0) {
            throw new InvalidExpenseException("Amount must be greater than zero!");
        }
        if (description == null || description.trim().isEmpty()) {
            throw new InvalidExpenseException("Description cannot be empty!");
        }
        Expense expense = new Expense(nextId++, amount, category, description, date);
        expenses.add(expense);
        storage.saveExpenses(expenses);
        System.out.println("Expense added successfully!");
    }

    /**
     * Returns all expenses.
     */
    public List<Expense> getAllExpenses() {
        return expenses;
    }

    /**
     * Finds an expense by its ID.
     */
    public Expense findById(int id) {
        for (Expense e : expenses) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    /**
     * Updates an existing expense by ID.
     */
    public boolean updateExpense(int id, double amount, Category category,
                                 String description, String date) {
        if (amount <= 0) {
            throw new InvalidExpenseException("Amount must be greater than zero!");
        }
        Expense expense = findById(id);
        if (expense == null) return false;

        expense.setAmount(amount);
        expense.setCategory(category);
        expense.setDescription(description);
        expense.setDate(date);
        storage.saveExpenses(expenses);
        System.out.println("Expense updated successfully!");
        return true;
    }

    /**
     * Deletes an expense by ID.
     */
    public boolean deleteExpense(int id) {
        Expense expense = findById(id);
        if (expense == null) return false;

        expenses.remove(expense);
        storage.saveExpenses(expenses);
        System.out.println("Expense deleted successfully!");
        return true;
    }

    /**
     * Prints a summary report by category.
     */
    public void printSummary() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }
        System.out.println("\n===== EXPENSE SUMMARY =====");
        double total = 0;
        for (Category cat : Category.values()) {
            double catTotal = 0;
            for (Expense e : expenses) {
                if (e.getCategory() == cat) {
                    catTotal += e.getAmount();
                }
            }
            if (catTotal > 0) {
                System.out.printf("%-15s: Rs. %.2f%n", cat, catTotal);
            }
            total += catTotal;
        }
        System.out.println("---------------------------");
        System.out.printf("%-15s: Rs. %.2f%n", "TOTAL", total);
        System.out.println("===========================");
    }
}