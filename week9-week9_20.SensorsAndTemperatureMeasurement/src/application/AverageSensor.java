/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author teruaki
 */
public class AverageSensor implements Sensor {
    private ArrayList<Sensor> sensor;
    private ArrayList<Integer> readings = new ArrayList<Integer>();

    public AverageSensor() {
        sensor = new ArrayList<Sensor>();
    }
    
    public void addSensor(Sensor additional){
        sensor.add(additional);
    }

     
    @Override
    public boolean isOn() {
        boolean isOn = false;
        for(Sensor s : sensor){
            if(s.isOn()){
                isOn = true;
            }
        }
        return isOn;
    }

    @Override
    public void on() {
        for(Sensor s : sensor){
            s.on();
        }
    }

    @Override
    public void off() {
        for(Sensor s : sensor){
            s.off();
        }
    }

    @Override
    public int measure() {
        int total = 0;
        for(Sensor s : sensor){
            total += s.measure();
        }
        int measurement = total / sensor.size();
        readings.add(measurement);
        return measurement;
    }
    
    public List<Integer> readings(){
        return readings;
    }
    
    
}
