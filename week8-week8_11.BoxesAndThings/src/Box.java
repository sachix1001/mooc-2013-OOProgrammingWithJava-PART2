
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author teruaki
 */
public class Box implements ToBeStored{

    private double maxWeight;
    private ArrayList<ToBeStored> list;

    public Box(double maxWeight) {
        this.maxWeight = maxWeight;
        list = new ArrayList<ToBeStored>();
    }

    public void add(ToBeStored thing) {
        if ((this.weight() + thing.weight()) <= this.maxWeight) {
            list.add(thing);
        }
    }

    public double weight(){
        
        double weight = 0;
        
        for(ToBeStored item : list){
            weight+= item.weight();
        }
        return weight;
    }
    @Override
    public String toString() {
        return "Box: " + list.size() + " things, total weight " + weight() + " kg";
    }

}
