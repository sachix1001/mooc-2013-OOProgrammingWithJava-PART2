/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author teruaki
 */
public class ConstantSensor implements Sensor {
    
    private int number;

    public ConstantSensor(int number) {
        this.number = number;
    }
    
    

    @Override
    public boolean isOn() {
        if(0 <= number){
            return true;
        }
        return false;
    }

    @Override
    public void on() {
        
    }

    @Override
    public void off() {
        
    }

    @Override
    public int measure() {
        return number;
    }
    
}
