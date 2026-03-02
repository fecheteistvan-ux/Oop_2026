package oop.labor03.lab3_1;

public class Main {
    public static void main(String[] args) {
        // 1
        Customer customer1 = new Customer("John", "BLACK");
        System.out.println("Kezdeti állapot:");
        System.out.println(customer1); // toString() hívása

        // 2
        customer1.setAccount(new BankAccount("OTP00001"));

        // 3
        customer1.getAccount().deposit(1000);
        System.out.println("\nBefizetés után:");
        System.out.println(customer1);

        // 4
        Customer customer2 = new Customer("Mary", "WHITE");
        customer2.setAccount(new BankAccount("OTP00002"));
        customer2.getAccount().deposit(500);
        System.out.println("\nMary adatai:");
        System.out.println(customer2);

        // 5
        customer2.closeAccount();
        System.out.println("\nMary számlájának bezárása után:");
        System.out.println(customer2);

        // 6

        customer2.setAccount(customer1.getAccount());

        System.out.println("\nKözös számla beállítása után:");
        System.out.println("John: " + customer1);
        System.out.println("Mary: " + customer2);


        customer1.getAccount().deposit(500);
        System.out.println("\nÚjabb 500 EUR befizetése után (John számlájára):");
        System.out.println("Mary új egyenlege: " + customer2.getAccount().getBalance());
    }
}