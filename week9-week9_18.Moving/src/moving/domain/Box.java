/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.domain;

import java.util.ArrayList;

/**
 *
 * @author teruaki
 */
public class Box implements Thing {
    
    private int maxCapacity;
    private ArrayList<Thing> itemList;

    public Box(int maximumCapacity) {
        this.maxCapacity = maximumCapacity;
        itemList = new ArrayList<Thing>();
    }
    
    public boolean addThing(Thing thing){
        int weight = getVolume()+thing.getVolume();
        if(weight <= maxCapacity){
            itemList.add(thing);
            return true;
        }
        return false;
    }

    @Override
    public int getVolume() {
        int totalVolume = 0;
        for (Thing thing : itemList){
            totalVolume += thing.getVolume();
        }
        return totalVolume ;
    }
    
    public String toString(){
        return itemList.toString();
    }
    
    
    
}
