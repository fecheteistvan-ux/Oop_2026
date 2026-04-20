

package oop.labor09.lab9_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryService {
    private IDictionary dictionary;

    public DictionaryService(DictionaryType type) {
        this.dictionary = DictionaryProvider.createDictionary(type);
    }

    public boolean findWord(String word) {
        return dictionary.find(word);
    }

    public ArrayList<String> findWordsFile(String fileName) {
        ArrayList<String> unknownWords = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                String word = scanner.next().replaceAll("[^a-zA-Z]", "");
                if (!word.isEmpty() && !findWord(word)) {
                    unknownWords.add(word);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Keresendő fájl nem található: " + fileName);
        }
        return unknownWords;
    }
}