/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import java.util.*;
import wormgame.Direction;

/**
 *
 * @author teruaki
 */
public class Worm {

    private List<Piece> pieces;
    private Direction direction;
    private int length;

    public Worm(int originalX, int originalY, Direction originalDirection) {
        pieces = new ArrayList<Piece>();
        pieces.add(new Piece(originalX, originalY));
        this.direction = originalDirection;
        this.length = 3;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getLength() {
        return pieces.size();
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public void move() {
        Piece head = pieces.get(pieces.size() - 1);

        if (this.direction == Direction.RIGHT) {
            pieces.add(new Piece(head.getX() + 1, head.getY()));

        } else if (this.direction == Direction.LEFT) {
            pieces.add(new Piece(head.getX() - 1, head.getY()));

        } else if (this.direction == Direction.DOWN) {
            pieces.add(new Piece(head.getX(), head.getY() + 1));

        } else if (this.direction == Direction.UP) {
            pieces.add(new Piece(head.getX(), head.getY() - 1));
        }
        System.out.println(this.length);
        if (this.length < pieces.size()) {
            pieces.remove(0);
        }
    }

    public void grow() {
        if (3 <= this.getLength()) {
            this.length++;
        }
    }
    
    public boolean runsInto(Piece piece){
        boolean runsInto = false;
        for(Piece p: pieces){
            if(p.getX() == piece.getX() && p.getY() == piece.getY()){
                runsInto = true;
            }
        }
        return runsInto;
    }
    
    public boolean runsIntoItself(){
        boolean runsIntoItself = false;
        for(Piece piece: pieces){
            for(Piece piece2: pieces){
                if(piece != piece2){
                    if(piece.getX() == piece2.getX() && piece.getY() == piece2.getY()){
                        runsIntoItself = true;
                    }
                }
            }
        }
        return runsIntoItself;
    }
    
    
   
}
