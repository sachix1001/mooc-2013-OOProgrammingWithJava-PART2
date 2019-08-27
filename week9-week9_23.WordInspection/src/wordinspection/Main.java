package wordinspection;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        // test your code here

        File file = new File("src/shortList.txt");
        // all words are in file src/wordList.txt
        WordInspection words = new WordInspection(file);
        System.out.println(words.wordCount());
        System.out.println(words.wordsContainingZ());
        System.out.println(words.wordsEndingInL());
        String word = "word";
        System.out.println(word.charAt(word.length()-1));
        String palindrom = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            palindrom += word.charAt(i);
        }
        System.out.println(palindrom);

    }
}
