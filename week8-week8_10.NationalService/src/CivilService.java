/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author teruaki
 */
public class CivilService implements NationalService {

    private int days;

    public CivilService() {
        days = 362;
    }

    public int getDaysLeft() {
        return days;
    }

    public void work() {
        if(0 <= days-1){
            days--;
        }
    }

}
