package oop.labor06.lab6_1;

import java.io.PrintStream;
import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public int numCustomers() {
        return customers.size();
    }

    public Customer getCustomer(int customerId) {
        for (Customer customer : customers) {
            if (customer.getId() == customerId) {
                return customer;
            }
        }
        return null;
    }

    private void printCustomers(PrintStream ps) {
        ps.println("ID, Firstname, Last name, Number of bank accounts");
        for (Customer customer : customers) {
            ps.println(customer.getId() + ", " + customer.getFirstName() + ", " +
                    customer.getLastName() + ", " + customer.getNumAccounts());
        }
    }

    public void printCustomersToStdout() {
        printCustomers(System.out);
    }

    public void printCustomersToFile(String filename) {
        try (PrintStream out = new PrintStream(filename)) {
            printCustomers(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}