
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author teruaki
 */
public class RingingCentre {

    private Map<Bird, List<String>> observation;

    public RingingCentre() {
        observation = new HashMap<Bird, List<String>>();
    }

    public void observe(Bird bird, String place) {
        if (!observation.containsKey(bird)) {
            observation.put(bird, new ArrayList<String>());
        }
        observation.get(bird).add(place);
    }

    public void observations(Bird bird) {
        
        if (observation.containsKey(bird)) {
            System.out.println(bird + " observations: " + observation.get(bird).size());
            for (String place : observation.get(bird)) {
                System.out.println(place);
            }
        }else{
            System.out.println(bird + " observations: 0");
        }

    }
}
