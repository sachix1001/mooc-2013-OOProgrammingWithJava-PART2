/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author teruaki
 */
public class Player extends Character {

    public Player(int height, int width) {
        super(height, width);
        this.setX(0);
        this.setY(0);
    }

    @Override
    public String toString() {
        return "@ " + this.getX() + " " + this.getY();
    }

}
