/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author teruaki
 */
public class Book implements ToBeStored{
    
    private String writer;
    private String name;
    private double weight;

    public Book(String writer, String name, double weight) {
        this.writer = writer;
        this.name = name;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }


    @Override
    public String toString() {
        return writer + ": " + name;
    }
    
    
    
}
