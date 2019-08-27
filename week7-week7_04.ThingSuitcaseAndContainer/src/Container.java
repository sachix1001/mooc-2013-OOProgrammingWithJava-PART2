
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author teruaki
 */
public class Container {

    private int maxWeight;
    private ArrayList<Suitcase> container;

    public Container(int maxWeight) {
        this.maxWeight = maxWeight;
        container = new ArrayList<Suitcase>();
    }

    public void addSuitcase(Suitcase suitcase) {
        if (totalWeight() + suitcase.totalWeight() <= maxWeight) {
            container.add(suitcase);
        }
    }

    @Override
    public String toString() {
        return container.size() + " suitcases (" + totalWeight() + " kg)";
    }

    public int totalWeight() {
        int totalWeight = 0;
        for (Suitcase suitcase : container) {
            totalWeight += suitcase.totalWeight();
        }
        return totalWeight;
    }

    public void printThings() {
        for (Suitcase suitcase : container) {
            suitcase.printThings();
        }
    }

}
