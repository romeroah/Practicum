import java.util.Scanner;

public class SafeInput {

    /**
     * Prompts the user for a non-zero length string input.
     *
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt the message displayed to the user
     * @return a non-zero length String entered by the user
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = ""; // Initialize an empty string to start
        do {
            System.out.print("\n" + prompt + ": "); // Display the prompt
            retString = pipe.nextLine(); // Get input from the user
        } while (retString.length() == 0); // Repeat if input is empty

        return retString; // Return valid input
    }
    // Other methods, like getNonZeroLenString, go here

    /**
     * Prompts the user for an integer input, ensuring the input is valid.
     *
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt the message displayed to the user
     * @return a valid integer entered by the user
     */
    public static int getInt(Scanner pipe, String prompt) {
        int retVal = 0;
        boolean valid = false;

        do {
            System.out.print("\n" + prompt + ": "); // Display the prompt
            if (pipe.hasNextInt()) { // Check if the input is an integer
                retVal = pipe.nextInt(); // Read the integer
                valid = true; // Set valid to true to exit loop
            } else {
                String trash = pipe.next(); // Read the invalid input
                System.out.println("Error: \"" + trash + "\" is not a valid integer."); // Show error message
            }
            pipe.nextLine(); // Clear the input buffer (newline character)
        } while (!valid); // Repeat until a valid integer is entered

        return retVal;
    }
    // Other methods, like getInt and getNonZeroLenString, go here

    /**
     * Prompts the user for a double input, ensuring the input is valid.
     *
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt the message displayed to the user
     * @return a valid double entered by the user
     */
    public static double getDouble(Scanner pipe, String prompt) {
        double retVal = 0.0;
        boolean valid = false;

        do {
            System.out.print("\n" + prompt + ": "); // Display the prompt
            if (pipe.hasNextDouble()) { // Check if the input is a double
                retVal = pipe.nextDouble(); // Read the double
                valid = true; // Set valid to true to exit loop
            } else {
                String trash = pipe.next(); // Read the invalid input
                System.out.println("Error: \"" + trash + "\" is not a valid double."); // Show error message
            }
            pipe.nextLine(); // Clear the input buffer (newline character)
        } while (!valid); // Repeat until a valid double is entered

        return retVal;
    }
    // Other methods, like getInt, getDouble, etc., go here

    /**
     * Prompts the user to input an integer within a specified inclusive range.
     *
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt the message displayed to the user
     * @param low    the minimum acceptable value (inclusive)
     * @param high   the maximum acceptable value (inclusive)
     * @return a valid integer within the specified range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retVal = 0;
        boolean valid = false;

        do {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: "); // Display the prompt with range
            if (pipe.hasNextInt()) { // Check if the input is an integer
                retVal = pipe.nextInt(); // Read the integer
                if (retVal >= low && retVal <= high) { // Check if within range
                    valid = true; // Set valid to true to exit loop
                } else {
                    System.out.println("Error: " + retVal + " is not within the range [" + low + " - " + high + "].");
                }
            } else {
                String trash = pipe.next(); // Read the invalid input
                System.out.println("Error: \"" + trash + "\" is not a valid integer.");
            }
            pipe.nextLine(); // Clear the input buffer (newline character)
        } while (!valid); // Repeat until a valid integer within range is entered

        return retVal;
    }
    // Other methods like getInt, getDouble, getRangedInt, etc., go here

    /**
     * Prompts the user to input a double within a specified inclusive range.
     *
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt the message displayed to the user
     * @param low    the minimum acceptable value (inclusive)
     * @param high   the maximum acceptable value (inclusive)
     * @return a valid double within the specified range
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retVal = 0.0;
        boolean valid = false;

        do {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: "); // Display the prompt with range
            if (pipe.hasNextDouble()) { // Check if the input is a double
                retVal = pipe.nextDouble(); // Read the double
                if (retVal >= low && retVal <= high) { // Check if within range
                    valid = true; // Set valid to true to exit loop
                } else {
                    System.out.println("Error: " + retVal + " is not within the range [" + low + " - " + high + "].");
                }
            } else {
                String trash = pipe.next(); // Read the invalid input
                System.out.println("Error: \"" + trash + "\" is not a valid double.");
            }
            pipe.nextLine(); // Clear the input buffer (newline character)
        } while (!valid); // Repeat until a valid double within range is entered

        return retVal;
    }
    // Other methods like getInt, getDouble, getRangedInt, getRangedDouble, etc., go here

    /**
     * Prompts the user for a Yes or No (Y/N) input and returns true for "Yes" and false for "No".
     *
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt the message displayed to the user
     * @return true if user responds with Y/y, false if user responds with N/n
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String response;
        boolean isYes = false;
        boolean valid = false;

        do {
            System.out.print("\n" + prompt + " [Y/N]: "); // Display the prompt with Y/N option
            response = pipe.nextLine().trim(); // Read and trim any extra spaces

            if (response.equalsIgnoreCase("Y")) { // Check for "Y" or "y"
                isYes = true;
                valid = true;
            } else if (response.equalsIgnoreCase("N")) { // Check for "N" or "n"
                isYes = false;
                valid = true;
            } else {
                System.out.println("Error: Invalid input. Please enter 'Y' for Yes or 'N' for No.");
            }
        } while (!valid); // Repeat until valid input

        return isYes;
    }
    // Other methods like getInt, getDouble, getRangedInt, etc., go here

    /**
     * Prompts the user for input that matches a specified RegEx pattern.
     *
     * @param pipe  a Scanner opened to read from System.in
     * @param prompt the message displayed to the user
     * @param regEx  the regular expression pattern to match
     * @return a String that matches the RegEx pattern
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String response;
        boolean valid = false;

        do {
            System.out.print("\n" + prompt + ": "); // Display the prompt to the user
            response = pipe.nextLine().trim(); // Read and trim any extra spaces

            if (response.matches(regEx)) { // Check if the input matches the RegEx pattern
                valid = true;
            } else {
                System.out.println("Error: Input does not match the required format. Please try again.");
            }
        } while (!valid); // Repeat until valid input is provided

        return response;
    }

    public static void prettyHeader(String msg) {
        final int WIDTH = 60;
        int padding = (WIDTH - msg.length() - 6) / 2; // 6 for the 3 asterisks on each side

        // Top border
        for (int i = 0; i < WIDTH; i++) {
            System.out.print("*");
        }
        System.out.println();

        // Centered message line
        System.out.print("***");
        for (int i = 0; i < padding; i++) {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < padding; i++) {
            System.out.print(" ");
        }
        if ((msg.length() % 2) != 0) { // Adjust if msg length is odd
            System.out.print(" ");
        }
        System.out.println("***");

        // Bottom border
        for (int i = 0; i < WIDTH; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}


