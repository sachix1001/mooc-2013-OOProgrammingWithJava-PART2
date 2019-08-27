/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import gameoflife.GameOfLifeBoard;
import static java.lang.Math.random;
import java.util.Random;

/**
 *
 * @author teruaki
 */
public class PersonalBoard extends GameOfLifeBoard {

    public PersonalBoard(int width, int height) {
        super(width, height);
    }

    @Override
    public void initiateRandomCells(double d) {
        Random random = new Random();

        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                if (random.nextDouble() < d) {
                    turnToLiving(x, y);
                } else {
                    turnToDead(x, y);
                }
            }
        }
    }

    @Override
    public boolean isAlive(int i, int i1
    ) {
        if (i < super.getWidth() && 0 <= i
                && i1 < super.getHeight() && 0 <= i1) {
            return super.getBoard()[i][i1];
        }
        return false;
    }

    @Override
    public void turnToLiving(int i, int i1
    ) {
        if (i <= super.getWidth() && 0 <= i
                && i1 <= super.getHeight() && 0 <= i1) {
            super.getBoard()[i][i1] = true;
        }
    }

    @Override
    public void turnToDead(int i, int i1
    ) {
        if (i <= super.getWidth() && 0 <= i
                && i1 <= super.getHeight() && 0 <= i1) {
            super.getBoard()[i][i1] = false;
        }
    }

    @Override
    public int getNumberOfLivingNeighbours(int i, int i1
    ) {
        int living = 0;

        for (int m = i1 - 1; m <= i1 + 1; m++) {
            for (int n = i - 1; n <= i + 1; n++) {

                if (n < super.getWidth() && 0 <= n
                        && m < super.getHeight() && 0 <= m) {
                    if (super.getBoard()[n][m]) {
                        living++;
                    }
                }
            }

        }
        if(super.getBoard()[i][i1]){
            living--;
        }
        return living;
    }

    @Override
    public void manageCell(int i, int i1, int i2
    ) {
        if(i2 < 2 || 3 < i2){
            turnToDead(i,i1);
            
        }else if(i2 == 3){
            turnToLiving(i,i1);
        }
    }

}
