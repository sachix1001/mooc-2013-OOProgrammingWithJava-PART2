/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

/**
 *
 * @author teruaki
 */
public class EmptySpace extends Character{
    
    public EmptySpace(int height, int length) {
        super(height, length);
    }
    
    public void setPosition(int x, int y){
        this.setX(x);
        this.setY(y);
    }
    
    
}
