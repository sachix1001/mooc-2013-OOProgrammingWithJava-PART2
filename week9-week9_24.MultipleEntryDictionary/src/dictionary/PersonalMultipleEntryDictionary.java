/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author teruaki
 */
public class PersonalMultipleEntryDictionary implements  MultipleEntryDictionary{

    private Map<String, Set<String>> wordList;

    public PersonalMultipleEntryDictionary() {
        wordList = new HashMap<String, Set<String>>();
    }
    
    
    @Override
    public void add(String word, String entry) {
        if(!wordList.containsKey(word)){
            this.wordList.put(word, new HashSet<String>());
        }
        
        Set<String> added = wordList.get(word);
        added.add(entry);
    }

    @Override
    public Set<String> translate(String word) {
        
        return wordList.get(word);
    }

    @Override
    public void remove(String word) {
        
        wordList.remove(word);
    }
    
}
