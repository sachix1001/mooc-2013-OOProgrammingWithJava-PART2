/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingfigure;

import java.awt.Graphics;
import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author teruaki
 */
public class CompoundFigure extends Figure{

    private ArrayList<Figure> compound;

    public CompoundFigure() {
        this.compound = new ArrayList<Figure>();
    }
    
    

    public CompoundFigure(int x, int y) {
        super(x, y);
        this.compound = new ArrayList<Figure>();
    }
    
    
    @Override
    public void draw(Graphics graphics) {
       for(Figure f: compound){
           f.draw(graphics);
       }
    }

    @Override
    public void move(int dx, int dy) {
        for(Figure f: compound){
           f.move(dx, dy);
       }
    }
    
    public void add(Figure f){
        compound.add(f);
    }
    
}
