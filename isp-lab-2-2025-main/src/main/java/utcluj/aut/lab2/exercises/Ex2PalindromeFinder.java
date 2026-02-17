package utcluj.aut.lab2.exercises;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Class for finding palindromic numbers in a given range.
 * Students should implement all methods to pass the unit tests.
 */
public class Ex2PalindromeFinder {

    /**
     * Checks if a number is palindromic (reads the same backward as forward).
     *
     * @param number the number to check
     * @return true if the number is palindromic, false otherwise
     */
    public boolean isPalindromic(int number) {
        String string = "" + number;
        String reverseString = new StringBuilder(string).reverse().toString();
        return string.equals(reverseString);
    }

    /**
     * Finds all palindromic numbers in the given range [a, b], inclusive.
     *
     * @param a the lower bound of the range
     * @param b the upper bound of the range
     * @return an array of all palindromic numbers in the range
     * @throws IllegalArgumentException if a > b
     */
    public int[] findPalindromes(int a, int b) {
        int[] palindromesCandidates = new int[b - a + 1];
        int c = 0;

        for (int i = a; i <= b; i++) {
            if (isPalindromic(i)) {
                palindromesCandidates[c++] = i;
            }
        }

        int[] palindromes = new int[c];
        for (int i = 0; i < c; i++) {
            palindromes[i] = palindromesCandidates[i];
        }

        return palindromes;
    }

    private int[] readInterval() {
        int a, b;
        boolean isALessThanB = false;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Enter 'a': ");
            a = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter 'b': ");
            b = scanner.nextInt();
            scanner.nextLine();

            if (a < b) {
                isALessThanB = true;
            } else {
                System.err.println("Invalid input for 'a' and/or 'b'!");
            }
        } while (!isALessThanB);

        return new int[]{a, b};
    }

    public static void main(String[] args) {
        Ex2PalindromeFinder finder = new Ex2PalindromeFinder();
        int[] interval = finder.readInterval();
        int[] palindromes = finder.findPalindromes(interval[0], interval[1]);
        System.out.printf("Palindromes number: %d\n", palindromes.length);
        System.out.printf("Palindromes: %s\n", Arrays.toString(palindromes));
    }
}
