package oop.labor06.lab6_1;

public class Main {
    public static void main(String[] args) {
        // BankAccount teszt (150 fiók)
        System.out.println("--- BankAccount Teszt ---");
        for (int i = 0; i < 150; i++) {
            BankAccount ba = new BankAccount();
            if (i < 3 || i > 147) { // Csak az első párat és az utolsó párat nyomtatjuk ki a rövidség kedvéért
                System.out.println(ba);
            }
        }

        // Bank teszt
        System.out.println("\n--- Bank Teszt ---");
        Bank bank = new Bank("OTP");

        Customer c1 = new Customer("John", "Doe");
        Customer c2 = new Customer("Jane", "Smith");

        bank.addCustomer(c1);
        bank.addCustomer(c2);

        BankAccount acc1 = new BankAccount();
        BankAccount acc2 = new BankAccount();
        c1.addAccount(acc1);
        c1.addAccount(acc2);

        BankAccount acc3 = new BankAccount();
        BankAccount acc4 = new BankAccount();
        c2.addAccount(acc3);
        c2.addAccount(acc4);

        System.out.println("Customer ID 1:");
        System.out.println(bank.getCustomer(1));

        // Pénz befizetése
        bank.getCustomer(1).getAccount(acc1.getAccountNumber()).deposit(5000);
        bank.getCustomer(2).getAccount(acc4.getAccountNumber()).deposit(10000);

        System.out.println("\nCustomer ID 2 a befizetés után:");
        System.out.println(bank.getCustomer(2));

        System.out.println("\n--- Minden ügyfél nyomtatása (Stdout) ---");
        bank.printCustomersToStdout();

        // Fájlba írás
        bank.printCustomersToFile("bank_customers.csv");
    }
}