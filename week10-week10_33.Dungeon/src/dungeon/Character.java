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
public class Character {

    private int height;
    private int length;
    private int x;
    private int y;

    public Character(int height, int length) {
        this.height = height;
        this.length = length;
    }

    public void moveHorizontal(int x) {
        if (0 <= (this.x + x) && (this.x + x) < length) {
            this.x += x;
        }
    }

    public void moveVertical(int y) {
        if (0 <= (this.y + y) && (this.y + y) < height) {
            this.y += y;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        Character compared = (Character) obj;

        if (this.x == compared.x && this.y == compared.y) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.x + this.y;
    }

}
