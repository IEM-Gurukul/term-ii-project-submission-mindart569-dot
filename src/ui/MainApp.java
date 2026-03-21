package ui;

import exception.InvalidExpenseException;
import manager.ExpenseManager;
import model.Category;
import model.Expense;

import java.util.List;
import java.util.Scanner;

/**
 * Main application class - handles all user interaction.
 * This is the entry point of the Smart Expense Tracker.
 */
public class MainApp {

    private static ExpenseManager manager = new ExpenseManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   Welcome to Smart Expense Tracker!");
        System.out.println("========================================");

        boolean running = true;
        while (running) {
            printMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1: addExpense(); break;
                case 2: viewExpenses(); break;
                case 3: updateExpense(); break;
                case 4: deleteExpense(); break;
                case 5: manager.printSummary(); break;
                case 6:
                    System.out.println("Goodbye! Keep tracking your expenses!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please enter 1-6.");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n---------- MAIN MENU ----------");
        System.out.println("1. Add Expense");
        System.out.println("2. View All Expenses");
        System.out.println("3. Update Expense");
        System.out.println("4. Delete Expense");
        System.out.println("5. View Summary Report");
        System.out.println("6. Exit");
        System.out.println("-------------------------------");
    }

    private static void addExpense() {
        System.out.println("\n--- Add New Expense ---");
        double amount = getDoubleInput("Enter amount (Rs.): ");
        System.out.println("Select category:");
        Category.printAll();
        int catChoice = getIntInput("Enter category number: ");
        Category category = Category.values()[catChoice - 1];
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter date (DD-MM-YYYY): ");
        String date = scanner.nextLine();

        try {
            manager.addExpense(amount, category, description, date);
        } catch (InvalidExpenseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewExpenses() {
        List<Expense> expenses = manager.getAllExpenses();
        if (expenses.isEmpty()) {
            System.out.println("No expenses found!");
            return;
        }
        System.out.println("\n--- All Expenses ---");
        for (Expense e : expenses) {
            System.out.println(e);
        }
    }

    private static void updateExpense() {
        viewExpenses();
        int id = getIntInput("Enter expense ID to update: ");
        double amount = getDoubleInput("Enter new amount (Rs.): ");
        System.out.println("Select new category:");
        Category.printAll();
        int catChoice = getIntInput("Enter category number: ");
        Category category = Category.values()[catChoice - 1];
        System.out.print("Enter new description: ");
        String description = scanner.nextLine();
        System.out.print("Enter new date (DD-MM-YYYY): ");
        String date = scanner.nextLine();

        try {
            boolean updated = manager.updateExpense(id, amount, category, description, date);
            if (!updated) System.out.println("Expense ID not found!");
        } catch (InvalidExpenseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void deleteExpense() {
        viewExpenses();
        int id = getIntInput("Enter expense ID to delete: ");
        boolean deleted = manager.deleteExpense(id);
        if (!deleted) System.out.println("Expense ID not found!");
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
    }

    private static double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = Double.parseDouble(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid amount.");
            }
        }
    }
}