package oop.labor08.lab8_1;

public class BankAccount {
    private static final String PREFIX = "OTP";
    private static final int ACCOUNT_NUMBER_LENGTH = 10;
    private static int numAccounts = 0;

    protected String accountNumber;
    protected double balance;

    public BankAccount() {
        accountNumber = createAccountNumber();
        balance = 0;
    }

    private static String createAccountNumber() {
        numAccounts++;
        int numDigits = ACCOUNT_NUMBER_LENGTH - PREFIX.length();
        String formatString = "%s%0" + numDigits + "d";
        return String.format(formatString, PREFIX, numAccounts);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account: " + accountNumber + ", Balance: " + balance;
    }
}
