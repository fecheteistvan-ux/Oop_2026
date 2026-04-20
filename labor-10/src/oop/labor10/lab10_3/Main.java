package oop.labor10.lab10_3;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Company company = new Company("Tech Solutions");
        company.hireAll("labor-10/employees.csv");

        System.out.println("--- Alphabetically ---");
        company.sortByComparator(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getLastName().compareTo(e2.getLastName());
            }
        });
        company.printAll(System.out);

        System.out.println("\n--- Decreasing Salary ---");
        company.sortByComparator((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
        company.printAll(System.out);

        System.out.println("\n--- Managers first, then Alphabetical ---");
        company.sortByComparator((e1, e2) -> {
            if (e1 instanceof Manager && !(e2 instanceof Manager)) return -1;
            if (!(e1 instanceof Manager) && e2 instanceof Manager) return 1;
            return e1.getLastName().compareTo(e2.getLastName());
        });
        company.printAll(System.out);
    }
}