/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author teruaki
 */
public class MindfulDictionary {

    private Map<String, String> dictionary = new HashMap<String, String>();
    private String file;

    public MindfulDictionary() {
    }

    public MindfulDictionary(String file) {
        this.file = file;
    }

    public boolean load() {
        File file = new File(this.file);
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parts = line.split(":");

                this.add(parts[0], parts[1]);
            }

        } catch (FileNotFoundException ex) {
            return false;
        }
        return true;
    }

    public void add(String word, String translation) {
        if (dictionary.containsKey(word)) {
            return;
        }

        dictionary.put(word, translation);
    }

    public String translate(String word) {
        if (dictionary.containsKey(word)) {
            return dictionary.get(word);
        }

        if (dictionary.containsValue(word)) {
            for (String s : dictionary.keySet()) {
                if (dictionary.get(s).equals(word)) {
                    return s;
                }
            }
        }
        return null;
    }

    public void remove(String word) {
        String toBeRemoved ="";
        if (dictionary.containsKey(word)) {
            toBeRemoved = word;
        }

        if (dictionary.containsValue(word)) {
            for (String s : dictionary.keySet()) {
                if (dictionary.get(s).equals(word)) {
                    toBeRemoved = s;
                }
            }
        }
        dictionary.remove(toBeRemoved);
    }

    public boolean save() {
        try {
            FileWriter writer = new FileWriter(file);

            for (String key : dictionary.keySet()) {
                String translate = key + ":" + dictionary.get(key) + "\n";
                writer.write(translate);
            }
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(MindfulDictionary.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}