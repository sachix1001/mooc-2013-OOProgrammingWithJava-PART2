
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author teruaki
 */
public class TextUserInterface {

    private Scanner reader;
    private Dictionary dictionary;

    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dictionary = dictionary;
    }

    public void start() {
        System.out.println("Statements:");
        System.out.println("  add - adds a word pair to the dictionary");
        System.out.println("  translate - asks a word and prints its translation");
        System.out.println("  quit - quit the text user interface");
        System.out.println();

        while (true) {
            System.out.print("Statement: ");
            String command = reader.nextLine();
            if (command.equals("quit")) {
                System.out.println("Cheers!");
                break;
            }
            handleCommand(command);
            System.out.println();

        }
    }

    private void handleCommand(String command) {

        if (command.equals("add")) {
            addWord();
        } else if (command.equals("translate")) {
            translateWord();
        } else {
            System.out.println("Unknown statement");
        }
    }

    public void addWord() {
        System.out.print("In Finnish: ");
        String key = reader.nextLine();
        System.out.print("Translation: ");
        String traslate = reader.nextLine();
        dictionary.add(key, traslate);
    }

    public void translateWord() {
        System.out.print("Give a word: ");
        String word = reader.nextLine();

        if (dictionary.translate(word) == null) {
            System.out.println("Unknown word!");
        } else {
            System.out.println("Translation: " + dictionary.translate(word));
        }

    }
}
