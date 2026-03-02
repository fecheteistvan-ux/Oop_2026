package oop.labor03.lab3_2;

import oop.labor03.lab3_1.BankAccount;

public class Main {
    public static void main(String[] args) {
        // 1
        Customer john = new Customer("John", "BLACK");

        // 2

        john.addAccount(new BankAccount("OTP00001"));
        john.addAccount(new BankAccount("VISA00002"));

        // 3

        BankAccount otp = john.getAccount("OTP00001");
        if (otp != null) {
            otp.deposit(1000);
        }

        // 4
        BankAccount visa = john.getAccount("VISA00002");
        if (visa != null) {
            visa.deposit(500);
        }

        // 5
        System.out.println(john);

        // 6
        BankAccount hiba = john.getAccount("NINCS_ILYEN");
        if (hiba == null) {
            System.out.println("Hiba: Ez a számla nem létezik Johnnál!");
        }
    }
}