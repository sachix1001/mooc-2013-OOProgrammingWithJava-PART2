/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author teruaki
 */
public class Purchase {
    private String product;
    private int amount;
    private int unitPrice;

    public Purchase(String product, int amount, int unitPrice) {
        this.product = product;
        this.amount = amount;
        this.unitPrice = unitPrice;
    }
    
    public int price(){
        return unitPrice * amount;
    }
    
    public void increaseAmount(){
        amount++;
    }
    
    public String toString(){
        return product + ": " + amount;
    }
    
    @Override
    public boolean equals(Object object) {
        if (object == null){
            return false;
        }
        Purchase compared = (Purchase) object;
        if(this.product != compared.product){
            return false;
        }
        return true;
    }
    
    public int hashCode(){
        return this.product.hashCode() + this.amount + this.unitPrice;
    }
}
