/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author teruaki
 */
public class Vampire extends Character{
    
    private Random random = new Random();
    
    public Vampire(int height, int length) {
        super(height, length);
        move();
        while(this.getX() == 0 && this.getY() == 0){
            move();
        }
    }
    
    public void move(){
        this.setX(random.nextInt(this.getLength()));
        this.setY(random.nextInt(this.getHeight()));
    }

    @Override
    public String toString() {
        return "v " + this.getX() + " " + this.getY();
    }
    
}
    
