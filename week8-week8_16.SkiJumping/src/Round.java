
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author teruaki
 */
public class Round{

    private ArrayList<Jumper> playersList;

    public Round() {
        playersList = new ArrayList<Jumper>();
    }

    public ArrayList<Jumper> getPlayersList() {
        return playersList;
    }
    
    
    
    public void addPlayers(Jumper jumper){
        playersList.add(jumper);
        
    }

    public void jumpingOrder() {
        Collections.sort(playersList);
    }
    
    public void resultFromTheTop(){
        Collections.sort(playersList);
        Collections.reverse(playersList);
    }
    

    public void printJumpingOrder() {
        jumpingOrder();
        System.out.println("Jumping order:");
        for (int i = 0; i < playersList.size(); i++) {
            System.out.println("  " + (i+1) + ". " + playersList.get(i));
        }
    }
    
    public int jumpPointGenerate(){
        Random jumpPoint = new Random();
        return jumpPoint.nextInt(61)+60;
    }
    
    public ArrayList<Integer> judgePointGenerate(){
        Random judgePoint = new Random();
        ArrayList<Integer> points =  new ArrayList<Integer>();
        
        for(int i = 0; i < 5; i++){
            points.add(judgePoint.nextInt(11) + 10);
        }
        return points;
    }
    
    

}
