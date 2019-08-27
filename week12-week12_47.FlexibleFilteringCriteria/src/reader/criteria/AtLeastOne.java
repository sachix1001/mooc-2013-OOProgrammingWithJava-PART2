/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reader.criteria;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author teruaki
 */
public class AtLeastOne implements Criterion {

    List<Criterion> criterion = new ArrayList<Criterion>();

    public AtLeastOne(Criterion... criterion) {
        for (Criterion c : criterion) {
            this.criterion.add(c);
        }
    }

    @Override
    public boolean complies(String line) {
        boolean isCompile = false;
        
        for (Criterion c : criterion) {
            if (c.complies(line)) {
                isCompile = true;
            }
        }
        return isCompile;
    }
}
