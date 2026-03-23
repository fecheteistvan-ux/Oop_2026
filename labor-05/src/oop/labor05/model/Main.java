package oop.labor05.model;

import oop.labor05.model.Course; // Ez az import KÖTELEZŐ, hogy lássa a másik csomagot
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // 1. Kurzusok beolvasása
        ArrayList<Course> courses = readCourses("courses.csv");

        // 2. Kurzusok kiíratása
        if (courses.isEmpty()) {
            System.out.println("Nem sikerült kurzusokat beolvasni (üres a lista).");
        } else {
            for (Course course : courses) {
                System.out.println(course);
            }
        }
    }

    private static ArrayList<Course> readCourses(String filename) {
        ArrayList<Course> courses = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.trim().isEmpty()) continue;

                // Széttörjük a sort a vesszők mentén
                String[] parts = line.split(",");

                if (parts.length >= 3) {
                    String name = parts[0].trim();
                    String description = parts[1].trim();
                    int numHours = Integer.parseInt(parts[2].trim());

                    // Létrehozzuk az immutable objektumot és adjuk a listához
                    courses.add(new Course(name, description, numHours));
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Hiba: A fájl nem található: " + filename);
            System.err.println("Tipp: Állítsd be a Working Directory-t a labor05 mappára!");
        } catch (NumberFormatException e) {
            System.err.println("Hiba: Az óraszám nem érvényes szám az egyik sorban.");
        }

        return courses;
    }
}