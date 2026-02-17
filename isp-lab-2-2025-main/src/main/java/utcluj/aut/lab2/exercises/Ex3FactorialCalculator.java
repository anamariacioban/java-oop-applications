package utcluj.aut.lab2.exercises;
/**
 * Class for calculating factorials using recursive and non-recursive approaches.
 * Students should implement all methods to pass the unit tests.
 */
import java.util.Scanner;
public class Ex3FactorialCalculator {

    /**
     * Calculates the factorial of n using recursion.
     *
     * @param n the number to calculate factorial for
     * @return the factorial of n
     * @throws IllegalArgumentException if n is negative
     */
    public long recursiveFactorial(int n) {
        // TODO: Implement this method using recursion
        // 1. Validate that n is not negative, throw IllegalArgumentException if it is
        // 2. Implement the recursive algorithm for factorial
        // 3. Remember the base case (0! = 1)
        if (n < 0) {
            throw new IllegalArgumentException("n cannot be negative");
        }
        if (n == 0) {
            return 1; // base case: 0! = 1
        }
        return n * recursiveFactorial(n - 1); // recursive case
    }

    /**
     * Calculates the factorial of n using a non-recursive approach.
     *
     * @param n the number to calculate factorial for
     * @return the factorial of n
     * @throws IllegalArgumentException if n is negative
     */
    public long nonRecursiveFactorial(int n) {
        // TODO: Implement this method using a loop (not recursion)
        // 1. Validate that n is not negative, throw IllegalArgumentException if it is
        // 2. Implement a loop-based algorithm for factorial
        // 3. Remember the base case (0! = 1)
        if (n < 0) {
            throw new IllegalArgumentException("n cannot be negative");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i; // multiply each number from 1 to n
        }
        return result;
    }

    /**
     * Compares the execution time of both factorial methods.
     *
     * @param n the number to calculate factorial for
     * @return an array with [recursiveTime, nonRecursiveTime] in nanoseconds
     */
    public long[] compareExecutionTime(int n) {
        // TODO: Implement this method
        // 1. Measure the execution time of recursiveFactorial
        // 2. Measure the execution time of nonRecursiveFactorial
        // 3. Return both times in an array
        long[] times = new long[2];

        // Measure execution time for recursive method
        long startTime = System.nanoTime();
        recursiveFactorial(n);
        long endTime = System.nanoTime();
        times[0] = endTime - startTime;

        // Measure execution time for non-recursive method
        startTime = System.nanoTime();
        nonRecursiveFactorial(n);
        endTime = System.nanoTime();
        times[1] = endTime - startTime;

        return times;
    }

     public static void main(String[] args) {
        // TODO: Implement the main method
        // 1. Create an instance of FactorialCalculator
        // 2. Read an integer input from the user
        // 3. Calculate the factorial using both recursive and non-recursive methods
        // 4. Compare the execution times of both methods
        // 5. Print the results (factorials and execution times)
         Ex3FactorialCalculator calculator = new Ex3FactorialCalculator();
         Scanner scanner = new Scanner(System.in);

         // Read input from the user
         System.out.println("Enter an integer to calculate its factorial: ");
         int n = scanner.nextInt();

         // Handle invalid input
         if (n < 0) {
             System.out.println("Factorial is not defined for negative numbers.");
             return;
         }

         // Calculate factorials using both methods
         long recursiveResult = calculator.recursiveFactorial(n);
         long nonRecursiveResult = calculator.nonRecursiveFactorial(n);

         // Compare execution times
         long[] executionTimes = calculator.compareExecutionTime(n);

         // Print results
         System.out.println("Factorial of " + n + " (recursive): " + recursiveResult);
         System.out.println("Factorial of " + n + " (non-recursive): " + nonRecursiveResult);
         System.out.println("Execution time (recursive): " + executionTimes[0] + " nanoseconds");
         System.out.println("Execution time (non-recursive): " + executionTimes[1] + " nanoseconds");
    }
}
