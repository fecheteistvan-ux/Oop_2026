
package oop.labor09.lab9_2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- Szótár szolgáltatás inicializálása ---");

        DictionaryService service = new DictionaryService(DictionaryType.ARRAY_LIST);


        System.out.println("\n--- 1. Teszt: Ismeretlen szavak a fájlból ---");
        System.out.println("Unknown words from a file: ");

        System.out.println(service.findWordsFile("labor-09/text_to_find.txt"));

        System.out.println("\n--- 2. Teszt: Interaktív keresés ---");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Word to find (Enter <end> for exit): ");
            String word = scanner.nextLine();

            if (word.equalsIgnoreCase("end")) {
                break;
            }
            System.out.println(" Find(" + word + "): " + service.findWord(word));
        }

        scanner.close();
        System.out.println("Program vége.");
    }
}