/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordinspection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author teruaki
 */
public class WordInspection {

    private File file;

    public WordInspection(File file) {
        this.file = file;
    }

    public int wordCount() {
        ArrayList<String> wordList = readFile();
        return wordList.size();

    }

    public List<String> wordsContainingZ() {
        ArrayList<String> wordList = readFile();
        List<String> z = new ArrayList<String>();
        for (String word : wordList) {
            if (word.contains("z")) {
                z.add(word);
            }
        }
        return z;
    }

    public List<String> wordsEndingInL() {
        ArrayList<String> wordList = readFile();
        List<String> endInL = new ArrayList<String>();

        for (String word : wordList) {
            if (word.endsWith("l")) {
                endInL.add(word);
            }
        }
        return endInL;
    }

    public List<String> palindromes() {
        ArrayList<String> wordList = readFile();
        List<String> palindromes = new ArrayList<String>();

        for (String word : wordList) {
            String palindrom = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            palindrom += word.charAt(i);
        }
            if (word.equals(palindrom)) {
                palindromes.add(word);
            }

        }
        return palindromes;
    }
    
    public List<String> wordsWhichContainAllVowels(){
        ArrayList<String> wordList = readFile();
        List<String> allVowels = new ArrayList<String>();
        for(String word: wordList){
            if(containsAllVowels(word)){
                allVowels.add(word);
            }
        }

        return allVowels;
    }
    
    private boolean containsAllVowels(String word){
        String[] vowels = {"a","e","i","o","u","y","ä","ö"};
        for(String vowel : vowels){
            if(!word.contains(vowel)){
                return false;
            }
        }
        return true;
    }

    private ArrayList<String> readFile() {
        ArrayList<String> wordList = new ArrayList<String>();

        try {

            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                String word = reader.nextLine();
                wordList.add(word);
            }
            return wordList;

        } catch (FileNotFoundException ex) {
            return wordList;
        }
    }
}
