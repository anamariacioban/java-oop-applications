package isp.lab3.exercise5;

import java.util.Scanner;

public class VendingMachine {
    private String[] products = {"Water", "Soda", "Chips", "Chocolate"};
    private int[] prices = {5, 7, 10, 12};
    private int credit = 0;

    public void displayProducts() {
        System.out.println("Produse disponibile:");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] + " - " + prices[i] + " credite");
        }
    }

    public void insertCoin(int value) {
        if (value > 0) {
            credit += value;
            System.out.println("Ai adăugat " + value + " credite. Credit total: " + credit);
        } else {
            System.out.println("Monedă invalidă!");
        }
    }

    public String selectProduct(int id) {
        if (id >= 1 && id <= products.length) {
            if (credit >= prices[id - 1]) {
                credit -= prices[id - 1];
                return "Produsul " + products[id - 1] + " a fost eliberat. Credit rămas: " + credit;
            } else {
                return "Credit insuficient!";
            }
        } else {
            return "Produs invalid!";
        }
    }

    public void displayCredit() {
        System.out.println("Credit curent: " + credit);
    }

    public void userMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Afișează produse");
            System.out.println("2. Introdu monede");
            System.out.println("3. Selectează produs");
            System.out.println("4. Afișează creditul");
            System.out.println("5. Ieșire");
            System.out.print("Alege o opțiune: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                    System.out.print("Introduceți suma: ");
                    int coin = scanner.nextInt();
                    insertCoin(coin);
                    break;
                case 3:
                    System.out.print("Alegeți ID-ul produsului: ");
                    int productId = scanner.nextInt();
                    System.out.println(selectProduct(productId));
                    break;
                case 4:
                    displayCredit();
                    break;
                case 5:
                    System.out.println("Ieșire...");
                    break;
                default:
                    System.out.println("Opțiune invalidă!");
            }
        } while (choice != 5);

        scanner.close();
    }

    public int getCredit() {
        return credit;
    }

    public String[] getProduct() {
        String[] product = new String[products.length];
        for (int i = 0; i < products.length; i++) {
            product[i] = (i + 1) + ". " + products[i] + " - " + prices[i] + " credite";
        }
        return product;
    }

}