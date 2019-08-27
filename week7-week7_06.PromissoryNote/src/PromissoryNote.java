
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author teruaki
 */
public class PromissoryNote {
    private HashMap<String, Double> debt;

    public PromissoryNote() {
        debt = new HashMap<String,Double>();
    }
    
    public void setLoan(String toWhom, double value){
        debt.put(toWhom, value);
    }

    public double howMuchIsTheDebt(String whose){
        if(this.debt.containsKey(whose)){
            return this.debt.get(whose);
        }
        return 0;
    }
    
}
