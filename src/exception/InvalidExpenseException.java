package exception;

/**
 * Custom exception thrown when invalid expense data is entered.
 * Demonstrates custom Exception handling in OOP.
 */
public class InvalidExpenseException extends RuntimeException {

    public InvalidExpenseException(String message) {
        super(message);
    }
}
