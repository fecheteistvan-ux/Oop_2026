package oop.labor06.lab6_1;

import java.util.ArrayList;

public class Customer {
    private static int numCustomers = 0;
    private final int id;
    private String firstName;
    private String lastName;
    private ArrayList<BankAccount> accounts;

    public Customer(String firstName, String lastName) {
        this.id = ++numCustomers;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accounts = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public BankAccount getAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public int getNumAccounts() {
        return accounts.size();
    }

    public ArrayList<String> getAccountNumbers() {
        ArrayList<String> accountNumbers = new ArrayList<>();
        for (BankAccount account : accounts) {
            accountNumbers.add(account.getAccountNumber());
        }
        return accountNumbers;
    }

    public void closeAccount(String accountNumber) {
        accounts.removeIf(account -> account.getAccountNumber().equals(accountNumber));
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accounts=" + accounts +
                '}';
    }

    public static class Main {
        public static void main(String[] args) {
            System.out.println("Hello, Lab_06");
        }
    }
}