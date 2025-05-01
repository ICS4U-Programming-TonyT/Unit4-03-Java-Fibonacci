import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * .
 * This class calculates the Fibonacci of a number using recursion.
 * @author Tony Tran
 * @version 1.0
 * @since 2025-04-25
 */
final class Fibonacci {
    /**
     * This is a private constructor to satisfy style checker.
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private Fibonacci() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This function calculates the factorial of a number using recursion.
     * @param args
     * @return recFactorial
     */
    public static int recFibonacci(final int args) {
        if (args <= 1) {
            return args;
        }
        return recFibonacci(args - 1) + recFibonacci(args - 2);
    }

    /**
     * This the main method to run the program.
     * @param args
     */
    public static void main(final String[] args) throws Exception {
        // Create a Scanner object to read from the input file
        Scanner input = new Scanner(new File(args[0]));
        // Create a FileWriter object to write to the output file
        FileWriter writer = new FileWriter("output.txt");
        // Loop through space-separated integers in the input file
        while (input.hasNext()) {
            try {
                // Read the next integer from the input file
                int number = Integer.parseInt(input.next());
                if (number < 0) {
                    // Write an error message to the output file
                    writer.write("Error: Fibonacci is not defined"
                            + " for negative numbers.\n");
                    continue;
                }
                // Calculate the factorial of the number
                int result = recFibonacci(number);
                // Write the result to the output file
                writer.write("The Fibonacci of "
                        + number + " is " + result + "\n");
            } catch (NumberFormatException e) {
                // Write an error message to the output file
                writer.write("Error: Invalid input.\n");
                continue;
            }
        }
        // Close the Scanner and FileWriter objects
        input.close();
        writer.close();
    }
}
