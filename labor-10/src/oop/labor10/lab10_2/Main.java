package oop.labor10.lab10_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<MyDate> dates = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            dates.add(new MyDate(2026, rand.nextInt(12) + 1, rand.nextInt(28) + 1));
        }

        System.out.println("Unsorted dates:");
        dates.forEach(System.out::println);

        Collections.sort(dates);

        System.out.println("\nSorted dates:");
        dates.forEach(System.out::println);
    }
}