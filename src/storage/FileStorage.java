package storage;

import model.Category;
import model.Expense;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles reading and writing expenses to a CSV file.
 * Implements StorageHandler - demonstrates Abstraction and Polymorphism.
 */
public class FileStorage implements StorageHandler {

    private static final String FILE_NAME = "expenses.csv";

    /**
     * Saves all expenses to the CSV file.
     * Each expense is written as one line.
     */
    @Override
    public void saveExpenses(List<Expense> expenses) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Expense expense : expenses) {
                writer.write(expense.getId() + "," +
                        expense.getAmount() + "," +
                        expense.getCategory() + "," +
                        expense.getDescription() + "," +
                        expense.getDate());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving expenses: " + e.getMessage());
        }
    }

    /**
     * Loads all expenses from the CSV file.
     * Returns empty list if file doesn't exist yet.
     */
    @Override
    public List<Expense> loadExpenses() {
        List<Expense> expenses = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return expenses; // Return empty list if no file yet
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    int id = Integer.parseInt(parts[0]);
                    double amount = Double.parseDouble(parts[1]);
                    Category category = Category.valueOf(parts[2]);
                    String description = parts[3];
                    String date = parts[4];
                    expenses.add(new Expense(id, amount, category, description, date));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading expenses: " + e.getMessage());
        }
        return expenses;
    }
}
