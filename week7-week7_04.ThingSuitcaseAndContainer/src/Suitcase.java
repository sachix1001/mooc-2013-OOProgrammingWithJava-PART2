
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
public class Suitcase {

    private int maxWeight;
    private ArrayList<Thing> things;

    public Suitcase(int maxWeight) {
        this.maxWeight = maxWeight;
        things = new ArrayList<Thing>();
    }

    public void addThing(Thing thing) {
        if (this.totalWeight() + thing.getWeight() <= maxWeight) {
            things.add(thing);
        }
    }

    @Override
    public String toString() {
        if (things.size() == 0) {
            return "empty (0 kg)";
        } else if (things.size() == 1) {
            return " 1 thing ( " + totalWeight() + " kg)";
        }
        return things.size() + "things (" + totalWeight() + " kg)";
    }
    
    public void printThings(){
        for(Thing thing : things){
            System.out.println(thing);
        }
    }
    
    public int totalWeight(){
        int totalWeight = 0;
        for(Thing thing : things){
            totalWeight += thing.getWeight();
        }
        return totalWeight;
    }
    
    public Thing heaviestThing(){
        if(things.isEmpty()){
            return null;
        }
        
        Thing heaviestSoFar = things.get(0);
        for(Thing thing : things){
            if(heaviestSoFar.getWeight() < thing.getWeight()){
                heaviestSoFar = thing;
            }
        }
        return heaviestSoFar;
    }
}


