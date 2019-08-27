/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phoneSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author teruaki
 */
public class phoneSearch {

    private Map<String, List<String>> phoneBook = new HashMap<String, List<String>>();
    private Map<String, String> addressBook = new HashMap<String, String>();

    public void addPhone(String name, String number) {
        if (!phoneBook.containsKey(name)) {
            phoneBook.put(name, new ArrayList<String>());
        }
        phoneBook.get(name).add(number);
    }

    public List<String> searchNumbers(String name) {
        return phoneBook.get(name);
    }

    public String searchName(String number) {
        String name = "";
        for (String key : phoneBook.keySet()) {
            if (phoneBook.get(key).contains(number)) {
                name = key;
            }
        }
        return name;
    }

    public void addAddress(String name, String address) {
        addressBook.put(name, address);
    }

    public String getAddress(String name) {
        return addressBook.get(name);
    }

    public void deleteInfo(String name) {
        phoneBook.remove(name);
        addressBook.remove(name);

    }

    public boolean isOnAddressBook(String name) {
        return addressBook.containsKey(name);
    }

    public boolean isContainInfo(String name) {
        boolean info = false;
        if (addressBook.containsKey(name)) {
            info = true;
        }
        if (phoneBook.containsKey(name)) {
            info = true;
        }
        return info;
    }

    public Map<String, List<String>> getPhoneBook() {
        return phoneBook;
    }

    public List<String> filter(String word) {
        List<String> nameList = new ArrayList<String>();

        for (String name : phoneBook.keySet()) {
            if (name.contains(word) || phoneBook.get(name).contains(word)) {
                nameList.add(name);
            }
        }
        for (String name : addressBook.keySet()) {
            if (name.contains(word) || addressBook.get(name).contains(word)) {
                if (!nameList.contains(name)) {
                    nameList.add(name);
                }
            }
        }

        Collections.sort(nameList);

        return nameList;
    }
}
