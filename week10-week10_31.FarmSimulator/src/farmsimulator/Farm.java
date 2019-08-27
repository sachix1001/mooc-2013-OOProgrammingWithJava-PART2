/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author teruaki
 */
public class Farm implements Alive{
    
    private String owner;
    private Barn barn;
    private List<Cow> animals;

    public Farm(String Owner, Barn barn) {
        this.owner = Owner;
        this.barn = barn;
        animals = new ArrayList<Cow>();
    }
    
    public void addCow(Cow cow){
        animals.add(cow);
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        String animal = "";
        if(animals.isEmpty()){
            animal += "No cows.";
        }else{
            animal += "Animals:\n";
            for(Cow cow : animals){
                animal += "        " + cow.toString() + "\n";
            }
        }
        return "Farm owner: " + this.owner + "\n"
                + "Barn bulk tank: "+ barn.toString() + "\n"
                + animal;
    }
    
    public void manageCows(){
        barn.takeCareOf(animals);
    }
    
    

    @Override
    public void liveHour() {
        for(Cow cow: animals){
            cow.liveHour();
        }
    }
    
    public void installMilkingRobot(MilkingRobot robot){
        barn.installMilkingRobot(robot);
    }
    
}
