/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author teruaki
 */
public class PersonalDuplicateRemover implements DuplicateRemover {

    private Set<String> wordList = new HashSet<String>();
    private int duplicate = 0;
    
    @Override
    public void add(String characterString) {
        if(wordList.contains(characterString)){
            duplicate++;
        }
        wordList.add(characterString);
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        return duplicate;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        return wordList;
    }

    @Override
    public void empty() {
        wordList.clear();
        duplicate = 0;
    }
    
}
