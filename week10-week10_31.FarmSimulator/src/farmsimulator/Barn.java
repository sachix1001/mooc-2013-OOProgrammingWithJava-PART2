/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.Collection;

/**
 *
 * @author teruaki
 */
public class Barn {
    private BulkTank bulkTank;
    private MilkingRobot robot;

    public Barn(BulkTank bulkTank) {
        this.bulkTank = bulkTank;
    }

    public BulkTank getBulkTank() {
        return bulkTank;
    }
    
    public void installMilkingRobot(MilkingRobot milkingRobot){
        this.robot = milkingRobot;
        robot.setBulkTank(bulkTank);
    }
    
    public void takeCareOf(Cow cow){
        try{
        robot.milk(cow);
        
        }catch (Exception e){
            throw new IllegalStateException();
        }
    }
    
    public void takeCareOf(Collection<Cow> cows){
        try{
            for(Cow cow: cows){
                robot.milk(cow);
            }
        }catch (Exception e){
            throw new IllegalStateException();
        }
    }
    
    public String toString(){
        return bulkTank.toString();
    }
}
