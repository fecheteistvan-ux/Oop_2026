package oop.labor04.Lab4_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void readFilePrintItsLineNumbered(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            int count = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                count++;
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
    }

    public static ArrayList<Person> readFromCSVFile(String fileName) {
        ArrayList<Person> persons = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                String[] items = line.split(",");
                // trim: eliminates leading and trailing spaces
                String firstName = items[0].trim();
                String lastName = items[1].trim();
                // Convert String → int: Integer.parseInt( String)
                int birthYear = Integer.parseInt(items[2].trim());
                persons.add(new Person(firstName, lastName, birthYear));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return persons;
    }
    public static void main(String[] args) {
        readFilePrintItsLineNumbered("labor-04/src/oop/labor04/Lab4_1/input.txt");
        ArrayList<Person>people = readFromCSVFile("labor-04/src/oop/labor04/Lab4_1/input.txt");
        for (Person p : people) {
            System.out.println(persons);
        }
    }
}