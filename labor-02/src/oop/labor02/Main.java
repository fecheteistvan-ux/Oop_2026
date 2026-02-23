package oop.labor02;


public class Main {


    public static void main(String[] args) {

        BankAccount account1 = new BankAccount("OTP00001");

        System.out.println(account1.getAccountNumber() + ": " + account1.getBalance());

        account1.deposit(1000);

        System.out.println(account1.getAccountNumber() + ": " + account1.getBalance());

        boolean result = account1.withdraw(1500);
        if ( !result ) {
            System.out.println("You do not have sufficient funds for this operation!");
        }

        System.out.println(account1.getAccountNumber() + ": " + account1.getBalance());
    }
}