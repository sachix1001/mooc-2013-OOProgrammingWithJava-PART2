/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phoneSearch;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author teruaki
 */
public class Person {
    
    private String name;
    private Set<String> number;
    private String address;

    public Person(String name, Set<String> number, String address) {
        this.name = name;
        this.number = number;
        this.address = address;
    }

    public Person(String name, String number) {
        this.name = name;
        this.number = new HashSet<String>();
        this.number.add(number);
        
    }
    
    public void addPhoneNumber(String newNumber){
        number.add(newNumber);
    }
    

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(Set<String> number) {
        this.number = number;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Set<String> getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }

    

    
    
    
    
    
}
