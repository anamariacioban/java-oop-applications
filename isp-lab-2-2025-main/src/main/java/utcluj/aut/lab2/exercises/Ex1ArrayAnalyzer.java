package utcluj.aut.lab2.exercises;

import java.util.Random;

public class Ex1ArrayAnalyzer {

    /**
     * Generates an array of random size between 25 and 150,
     * filled with random integers between -100 and 100.
     *
     * @return an array of random integers
     */
    public int[] generateArray() {
        Random rand = new Random();
        int size = rand.nextInt(126) + 25;  // Dimensiune aleatorie între 25 și 150
        int[] array = new int[size];

        // Umple array-ul cu numere aleatoare între -100 și 100
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(201) - 100; // Generare număr între -100 și 100
        }

        return array;
    }

    /**
     * Calculates the average value of all elements in the given array.
     *
     * @param array the array to analyze
     * @return the average value of all elements
     */
    public double calculateAverage(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        // Evităm eroarea de împărțire la zero dacă array-ul este gol
        if (array.length == 0) {
            return 0.0;
        }

        return (double) sum / array.length;  // Media
    }

    /**
     * Counts how many elements are above and below the given average.
     *
     * @param array the array to analyze
     * @param average the average value to compare against
     * @return an array of 2 integers: [countAbove, countBelow]
     */
    public int[] countAboveBelowAverage(int[] array, double average) {
        int countAbove = 0;
        int countBelow = 0;

        // Numărăm elementele mai mari decât media și cele mai mici
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            if (num > average) {
                countAbove++;
            } else if (num < average) {
                countBelow++;
            }
        }

        return new int[]{countAbove, countBelow};
    }

    public static void main(String[] args) {
        // Crearea unui obiect al clasei Ex1ArrayAnalyzer
        Ex1ArrayAnalyzer analyzer = new Ex1ArrayAnalyzer();

        // Generăm un array aleator
        int[] array = analyzer.generateArray();

        // Calculăm media array-ului
        double average = analyzer.calculateAverage(array);

        // Numărăm elementele mai mari și mai mici decât media
        int[] counts = analyzer.countAboveBelowAverage(array, average);

        // Afișăm rezultatele
        System.out.println("Array-ul generat are dimensiunea: " + array.length);
        System.out.println("Media elementelor din array este: " + average);
        System.out.println("Numărul de elemente mai mari decât media: " + counts[0]);
        System.out.println("Numărul de elemente mai mici decât media: " + counts[1]);
    }
}