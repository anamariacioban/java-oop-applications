package utcluj.aut.lab2.exercises;

/**
 * Class implementing the Bulls and Cows number guessing game.
 * Students should implement all methods to pass the unit tests.
 */
import java.util.Random;
import java.util.HashSet; ///pt ca fiecare cifra din numar sa fie unica
import java.util.Set;  ///le folosim pe amandoua
import java.util.Scanner;

public class Ex6BullsAndCowsGame {
    private String secretNumber;

    /**
     * Creates a new game with a random secret number.
     */
    public Ex6BullsAndCowsGame() {
        this.secretNumber = generateSecretNumber();
    }
    // constructor implicit pentru initializarea obietului(este apelat automat)
    /**
     * Creates a new game with the specified secret number (for testing).
     *
     * @param secretNumber the secret number to use
     */
    public Ex6BullsAndCowsGame(String secretNumber) {
        this.secretNumber = secretNumber;
    }
     // nu e implicit
    /**
     * Generates a random 4-digit number with no repeated digits.
     *
     * @return a string representing the 4-digit number
     */
    public static String generateSecretNumber() {
        // TODO: Implement this method
        // 1. Generate 4 unique random digits (no repeats)
        // 2. Concatenate them into a string
        // 3. Return the string
        Random random = new Random();
        Set<Integer> digits = new HashSet<>();
        StringBuilder secret = new StringBuilder();

        while (secret.length() < 4) {
            int digit = random.nextInt(10);
            if (digits.add(digit)) {
                secret.append(digit);///adauga cifra la sfarsitul nr secret
            }
        }

        return secret.toString();
    }

    /**
     * Evaluates a guess against the secret number.
     *
     * @param guess the guess to evaluate
     * @return an array with [bulls, cows]
     * @throws IllegalArgumentException if the guess is invalid
     */
    public int[] evaluateGuess(String guess) {
        // TODO: Implement this method
        // 1. Validate the guess (4 digits, no repeats)
        // 2. Count bulls (correct digit in correct position)
        // 3. Count cows (correct digit in wrong position)
        // 4. Return both counts as an array [bulls, cows]
        if (guess.length() != 4 || !guess.matches("[0-9]{4}") || hasDuplicates(guess)) {
            throw new IllegalArgumentException("Guess must be a 4-digit number with no repeated digits.");
        }

        int bulls = 0;
        int cows = 0;
        boolean[] secretMatched = new boolean[4];
        boolean[] guessMatched = new boolean[4];

        // Count bulls (correct digits in correct position)
        for (int i = 0; i < 4; i++) {
            if (guess.charAt(i) == secretNumber.charAt(i)) {
                bulls++;
                secretMatched[i] = true;
                guessMatched[i] = true;
            }
        }

        // Count cows (correct digits in wrong position)
        for (int i = 0; i < 4; i++) {
            if (!guessMatched[i]) {
                for (int j = 0; j < 4; j++) {
                    if (!secretMatched[j] && guess.charAt(i) == secretNumber.charAt(j)) {
                        cows++;
                        secretMatched[j] = true;
                        break;
                    }
                }
            }
        }

        return new int[]{bulls, cows};
    }
    // Helper method to check for duplicates in the guess
    private boolean hasDuplicates(String str) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!set.add(c)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Plays the game with a predetermined list of guesses (for testing).
     *
     * @param guesses the list of guesses to try
     * @return the number of attempts needed to guess correctly
     */
    public int playTestGame(String[] guesses) {
        // TODO: Implement this method
        // 1. Iterate through each guess
        // 2. Evaluate the guess
        // 3. If all bulls, return the number of attempts
        // 4. If no correct guess, return the number of guesses
        int attempts = 0;
        for (int i = 0; i < guesses.length; i++) {
            attempts++;
            int[] result = evaluateGuess(guesses[i]);
            if (result[0] == 4) {
                return attempts;
            }
        }
        return attempts;
    }

    /**
     * Plays an interactive game with user input.
     */
    public void play() {
        // TODO: Implement this method
        // 1. Create a scanner for user input
        // 2. Loop until the user guesses correctly
        // 3. Validate and evaluate each guess
        // 4. Display the number of bulls and cows
        // 5. Track the number of attempts
        // 6. Display the final result
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        boolean guessedCorrectly = false;

        System.out.println("Welcome to Bulls and Cows! Try to guess the 4-digit number.");

        while (!guessedCorrectly) {
            System.out.print("Enter your guess: ");
            String guess = scanner.nextLine();
            attempts++;

            try {
                int[] result = evaluateGuess(guess);
                int bulls = result[0];
                int cows = result[1];

                System.out.println("Bulls: " + bulls + ", Cows: " + cows);

                if (bulls == 4) {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid guess. Please enter a 4-digit number with no repeated digits.");
            }
        }

        scanner.close();
    }
    public static void main(String[] args) {
        // Creăm o instanță a jocului
        Ex6BullsAndCowsGame game = new Ex6BullsAndCowsGame();

        // Apelăm metoda pentru a începe jocul interactiv
        game.play();
    }
}
