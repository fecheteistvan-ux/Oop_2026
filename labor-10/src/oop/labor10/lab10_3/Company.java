package oop.labor10.lab10_3;

import oop.labor10.lab10_2.MyDate;
import java.io.*;
import java.util.*;

public class Company {
    private String name;
    private ArrayList<Employee> employees = new ArrayList<>();

    public Company(String name) { this.name = name; }

    public void hire(Employee employee) { employees.add(employee); }

    public void hireAll(String csvFile) {
        try (Scanner scanner = new Scanner(new File(csvFile))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.trim().isEmpty()) continue;
                String[] p = line.split(",");
                String lName = p[0].trim();
                String fName = p[1].trim();
                double sal = Double.parseDouble(p[2].trim());
                MyDate bDate = new MyDate(
                        Integer.parseInt(p[3].trim()),
                        Integer.parseInt(p[4].trim()),
                        Integer.parseInt(p[5].trim())
                );

                if (p.length > 6) {
                    hire(new Manager(fName, lName, sal, bDate, p[6].trim()));
                } else {
                    hire(new Employee(fName, lName, sal, bDate));
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + csvFile);
        }
    }

    public void sortByComparator(Comparator<Employee> comp) {
        employees.sort(comp);
    }

    public void printAll(PrintStream ps) {
        for (Employee e : employees) ps.println(e);
    }
}