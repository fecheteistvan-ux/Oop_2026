package oop.labor08.lab8_1;

public class Main {
    public static void main(String[] args) {
        Bank otp = new Bank("OTP");

        Customer c1 = new Customer("Kovacs", "Janos");
        Customer c2 = new Customer("Szabo", "Anna");
        otp.addCustomer(c1);
        otp.addCustomer(c2);

        c1.addAccount(new SavingsAccount(0.05));
        c1.addAccount(new CheckingAccount(500));

        c2.addAccount(new SavingsAccount(0.03));
        c2.addAccount(new CheckingAccount(1000));

        for (int i = 0; i < 2; i++) {
            c1.getAccount(i).deposit(1000);
            c2.getAccount(i).deposit(2000);
        }

        System.out.println("--- Kezdeti allapot ---");
        System.out.println(c1);
        System.out.println(c2);

        for (BankAccount account : c1.getAccounts()) {
            if (account instanceof SavingsAccount) {
                ((SavingsAccount) account).addInterest();
            }
        }

        System.out.println("\n--- Kamatozas utan ---");
        System.out.println(c1);

        c1.getAccount(1).withdraw(1200);

        System.out.println("\n--- Penzkivetel utan ---");
        System.out.println(c1);
    }
}
