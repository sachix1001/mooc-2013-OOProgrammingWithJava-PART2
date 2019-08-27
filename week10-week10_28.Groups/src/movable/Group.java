/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movable;

import java.util.*;

/**
 *
 * @author teruaki
 */
public class Group implements Movable{
    
    private List<Movable> group = new ArrayList<Movable>();

    public void addToGroup(Movable movable){
        group.add(movable);
    }
    @Override
    public String toString() {
        String movables ="";
        for ( Movable movable: group){
            movables += movable + "\n";
        }
        
            return movables;
        
    }

    @Override
    public void move(int dx, int dy) {
        for(Movable object : group){
            object.move(dx, dy);
        }
    }
    
}
