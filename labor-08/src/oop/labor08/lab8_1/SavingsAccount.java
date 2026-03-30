package oop.labor08.lab8_1;

public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(double interestRate) {
        super();
        this.interestRate = interestRate;
    }

    public void addInterest() {
        balance += balance * interestRate;
    }

    @Override
    public String toString() {
        return "Savings" + super.toString() + ", Interest Rate: " + interestRate;
    }
}