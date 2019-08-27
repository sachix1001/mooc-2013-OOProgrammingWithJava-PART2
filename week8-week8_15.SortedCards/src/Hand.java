
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author teruaki
 */
public class Hand implements Comparable<Hand>{
    private ArrayList<Card> cardsInHand = new ArrayList<Card>();
    
    public void add(Card card){
        cardsInHand.add(card);
    }
    
    public void print(){
        for(Card card: cardsInHand){
            System.out.println(card);
        }
    }
    
    public void sort(){
        Collections.sort(cardsInHand);
    }

    @Override
    public int compareTo(Hand hand) {
        int thisTotal = 0;
        int compareTotal = 0;
        for(Card card: this.cardsInHand){
            thisTotal += card.getValue();
        }
        
        for(Card card: hand.cardsInHand){
            compareTotal += card.getValue();
        }
        
        return thisTotal - compareTotal;
    }
    
    public void sortAgainstSuit(){
        Collections.sort(cardsInHand, new SortAgainstSuitAndValue());
    }
    
}
