package oop.labor10.lab10_1;

public class Main {
    public static void main(String[] args) {
        SortingDemo demo = new SortingDemo("labor-10/fruits.txt");

        System.out.println("Original:");
        demo.printFruits();

        System.out.println("Alphabetical:");
        demo.sortAlphabetically();
        demo.printFruits();

        System.out.println("Reverse Alphabetical:");
        demo.sortReverseAlphabetically();
        demo.printFruits();
    }
}