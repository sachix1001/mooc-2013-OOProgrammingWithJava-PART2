
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author teruaki
 */
public class Airplane {

    private HashMap<String, Integer> airplanes;

    public Airplane() {
        airplanes = new HashMap<String, Integer>();
    }

    public void addAirplane(String name, int capacity) {
        airplanes.put(name, capacity);
    }

    public String getAirplane(String name) {
        return name + " (" + airplanes.get(name) + " ppl)";
    }
    
    

    public void printPlane(String name) {
        System.out.print(this.getAirplane(name));
    }

    public void printPlanes() {
        for (String key : airplanes.keySet()) {
            printPlane(key);
            System.out.println();
        }

    }

}
