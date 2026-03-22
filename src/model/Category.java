package model;

/**
 * Enum representing expense categories.
 * Using enum ensures only valid categories can be used.
 */
public enum Category {
    FOOD,
    TRANSPORT,
    EDUCATION,
    ENTERTAINMENT,
    HEALTH,
    OTHER;

    /**
     * Displays categories in a numbered list for the user.
     */
    public static void printAll() {
        Category[] categories = Category.values();
        for (int i = 0; i < categories.length; i++) {
            System.out.println((i + 1) + ". " + categories[i]);
        }
    }
}