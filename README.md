[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/pG3gvzt-)
# PCCCS495 – Term II Project

## Project Title
Smart Expense Tracker

---

## Problem Statement (max 150 words)
College students often struggle to keep track of their daily expenses.
Money gets spent on food, transport, and other things without any record,
making it hard to understand where it all goes. This project is a
console-based Java application that lets students log their expenses with
an amount, category, description, and date. All data is saved to a file
so it persists between sessions. The app supports adding, viewing,
updating, and deleting expenses, as well as generating a category-wise
summary report. It is designed to be simple, fast, and easy to use
directly from the terminal.

---

## Target User
College students who want a simple way to track their daily spending
without needing an internet connection or a smartphone app.

---

## Core Features

- Add, view, update and delete expenses with category and date
- Category-wise spending summary report
- Persistent storage using a CSV file (expenses.csv)
- Input validation with custom exception handling
- Support for premium expenses with receipt numbers

---

## OOP Concepts Used

- **Abstraction:** StorageHandler interface defines what storage must do without exposing how it works
- **Inheritance:** PremiumExpense extends Expense, adding a receipt number field
- **Polymorphism:** toString() is overridden in both Expense and PremiumExpense to display different outputs
- **Exception Handling:** InvalidExpenseException is thrown for negative amounts or empty descriptions
- **Collections:** ArrayList is used in ExpenseManager to store and manage expenses in memory

---

## Proposed Architecture Description
The project follows a clean layered architecture with 5 packages.
The model package holds data classes (Expense, Category, PremiumExpense).
The manager package contains ExpenseManager which handles all business logic.
The storage package has a StorageHandler interface and FileStorage class
that reads and writes to a CSV file. The exception package contains
InvalidExpenseException for input validation. The ui package has MainApp
which is the entry point and handles all console interaction.

---

## How to Run
1. Open the project in IntelliJ IDEA
2. Navigate to src/ui/MainApp.java
3. Press Shift+F10 or click the green Run button
4. Use the numbered menu in the console to interact with the app

---

## Git Discipline Notes
Minimum 10 meaningful commits required.
