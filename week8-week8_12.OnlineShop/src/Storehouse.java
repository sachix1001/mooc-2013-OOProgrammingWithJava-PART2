
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author teruaki
 */
public class Storehouse {

    private Map<String, Integer> priceList = new HashMap<String, Integer>();
    private Map<String, Integer> stockList = new HashMap<String, Integer>();

    public void addProduct(String product, int price, int stock) {
        priceList.put(product, price);
        stockList.put(product, stock);
    }

    public int price(String product) {
        if (priceList.containsKey(product)) {
            return priceList.get(product);
        }
        return -99;
    }

    public int stock(String product) {
        if (stockList.containsKey(product)) {
            return stockList.get(product);
        }
        return 0;
    }

    public boolean take(String product) {
        if (!stockList.containsKey(product)) {
            return false;
        }
        if (0 < stockList.get(product)) {
            stockList.replace(product, stockList.get(product) - 1);
            return true;
        }
        return false;
    }
    
    public Set<String> products(){
        Set<String> productList = priceList.keySet();
        return productList;
    }
    
    
}
