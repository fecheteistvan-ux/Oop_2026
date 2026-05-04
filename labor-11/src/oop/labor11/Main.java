package oop.labor11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Problem 4: Custom Checked Exception
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// Problem 4: BankAccount osztály
class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds! Current balance: " + balance);
        }
        balance -= amount;
        System.out.println("Withdrawal successful. New balance: " + balance);
    }
}

public class Main {

    public static void main(String[] args) {
        System.out.println("--- Problem 1: Checked Exception ---");
        System.out.println("Eredmény (alma.txt): " + readFirstLine("alma.txt"));
        System.out.println();

        System.out.println("--- Problem 2: Unchecked Exception ---");
        try {
            System.out.println("10 / 2 = " + safeDivide(10, 2));
            System.out.println("10 / 0 = " + safeDivide(10, 0));
        } catch (RuntimeException e) {
            System.out.println("Elkapott hiba: " + e.getMessage());
        }
        System.out.println();

        System.out.println("--- Problem 3: finally always runs ---");
        try {
            demonstrateFinally();
        } catch (RuntimeException e) {
            System.out.println("A main elkapta a végén: " + e.getMessage());
        }
        System.out.println();

        System.out.println("--- Problem 4: Custom Exception ---");
        BankAccount myAccount = new BankAccount(500.0);
        try {
            System.out.println("Kivét 200...");
            myAccount.withdraw(200);
            System.out.println("Kivét 400...");
            myAccount.withdraw(400);
        } catch (InsufficientFundsException e) {
            System.out.println("Banki hiba: " + e.getMessage());
        }
    }

    // Problem 1 metódus
    public static String readFirstLine(String path) {
        try (Scanner scanner = new Scanner(new File(path))) {
            if (scanner.hasNextLine()) {
                return scanner.nextLine();
            } else {
                return "";
            }
        } catch (FileNotFoundException e) {
            return "FILE_NOT_FOUND";
        }
    }

    // Problem 2 metódus
    public static int safeDivide(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            throw new RuntimeException("DIVISION_BY_ZERO");
        }
    }

    // Problem 3 metódus
    public static void demonstrateFinally() {
        try {
            System.out.println("Resource is opened.");
            throw new RuntimeException("Something went wrong!");
        } finally {
            System.out.println("Resource is closed.");
        }
    }
}