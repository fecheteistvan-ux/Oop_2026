package oop.labor06.lab6_1;

public class BankAccount {
    public static final String PREFIX = "OTP";
    public static final int ACCOUNT_NUMBER_LENGTH = 10;
    private static int numAccounts = 0;

    private final String accountNumber;
    private double balance;

    public BankAccount() {
        ++numAccounts;
        this.accountNumber = createAccountNumber();
    }

    private static String createAccountNumber() {
        int numDigits = ACCOUNT_NUMBER_LENGTH - PREFIX.length();
        String formatString = "%s%0" + numDigits + "d";
        return String.format(formatString, PREFIX, numAccounts);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}