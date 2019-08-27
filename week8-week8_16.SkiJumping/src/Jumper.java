
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
public class Jumper implements Comparable<Jumper>{
    private String name;
    private ArrayList<Integer> jumpPoints;
    private ArrayList<Integer> judgePoints;

    public Jumper(String name) {
        this.name = name;
        this.jumpPoints = new ArrayList<Integer>();
        this.judgePoints = new ArrayList<Integer>();
    }

    public void addPoints(int jump, int judge){
        jumpPoints.add(jump);
        judgePoints.add(judge);
    }

    public String getName() {
        return name;
    }
    
    public int totalPoints(){
        int totalPoints = 0;
        
        for(int point: jumpPoints){
            totalPoints += point;
        }
        for(int point: judgePoints){
            totalPoints += point;
        }
        return totalPoints;
    }
    
    public void printJumpLength(){
        System.out.print("jump lengths: ");
        System.out.print(jumpPoints.get(0) + " m");
        
        if(1 < jumpPoints.size())
        for(int i = 1; i < jumpPoints.size(); i++){
            System.out.print(", " + jumpPoints.get(i) + " m");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return this.name + " (" + this.totalPoints() + " points)";
    }
    
    

    @Override
    public int compareTo(Jumper compared) {
        return this.totalPoints() - compared.totalPoints();
    }
    
    

}
