package oop.labor10.lab10_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SortingDemo {
    private ArrayList<String> fruits = new ArrayList<>();

    public SortingDemo(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] items = line.split(", ");
                for (String item : items) {
                    fruits.add(item);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
        }
    }

    public void sortAlphabetically() {
        Collections.sort(fruits);
    }

    public void sortReverseAlphabetically() {
        Collections.sort(fruits, Collections.reverseOrder());
    }

    public void printFruits() {
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println();
    }
}