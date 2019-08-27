/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

import static java.lang.Math.abs;
import java.util.*;

/**
 *
 * @author teruaki
 */
public class ContainerHistory {

    private List<Double> history = new ArrayList<Double>();

    public ContainerHistory() {

    }

    public void add(double situation) {
        history.add(situation);
    }

    public void reset() {
        history.clear();
    }

    public double maxValue() {
        if (history.isEmpty()) {
            return 0;
        }
        double max = history.get(0);
        for (double value : history) {
            if (max < value) {
                max = value;
            }
        }
        return max;
    }

    public double minValue() {
        if (history.isEmpty()) {
            return 0;
        }
        double min = history.get(0);
        for (double value : history) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    public double average() {
        double total = 0;
        for (double value : history) {
            total += value;
        }
        double average = total / history.size();
        return average;
    }

    public double greatestFluctuation() {
        if (history.isEmpty() || history.size() == 1) {
            return 0;
        }
        double oneBefore = history.get(0);
        double greatest = 0;
        for (double value : history) {
            if (greatest < abs(oneBefore - value)) {
                greatest = abs(oneBefore - value);
                
            }
            oneBefore = value;
        }
        return greatest;
    }

    public double variance() {
        if (history.isEmpty() || history.size() == 1) {
            return 0;
        }
        double average = average();
        double denominator = 0;
        for (double value : history) {
            denominator += (value - average) * (value - average);
        }
        
       double variance = denominator / (history.size()-1);
       return variance;
    }

    public String toString() {
        return history.toString();
    }
}
