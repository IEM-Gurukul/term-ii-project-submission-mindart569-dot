package storage;

import model.Expense;
import java.util.List;

/**
 * Interface defining storage operations.
 * Demonstrates Abstraction - defines WHAT to do, not HOW.
 */
public interface StorageHandler {

    // Save all expenses to storage
    void saveExpenses(List<Expense> expenses);

    // Load all expenses from storage
    List<Expense> loadExpenses();
}