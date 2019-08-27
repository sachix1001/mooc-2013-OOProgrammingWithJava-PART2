
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author teruaki
 */
public class UserInterface {

    private Scanner reader;
    private Round round;

    public UserInterface(Scanner reader, Round round) {
        this.reader = reader;
        this.round = round;
    }

    public void start() {
        System.out.println("Kumpula ski jumping week");
        System.out.println();
        System.out.println("Write the names of the participants one at a time;"
                + " an empty string brings you to the jumping phase.");

        readName();

        System.out.println();
        System.out.println("The tournament begins!");
        System.out.println();

        startJump();

        System.out.println("Thanks!");
        System.out.println();

        printTornamentResults();
    }

    public void readName() {
        while (true) {
            System.out.print("  Participant name: ");
            String name = reader.nextLine();
            Jumper jumper = new Jumper(name);

            if (name.isEmpty()) {
                break;
            }
            round.addPlayers(jumper);
        }
    }

    public void startJump() {
        int howManyRound = 1;
        while (true) {
            System.out.print("Write \"jump\" to jump; otherwise you quit: ");
            String command = reader.nextLine();
             

            if (!command.equals("jump")) {
                break;
            }

           
            System.out.println();
            System.out.println("Round " + howManyRound);
            System.out.println();
            round.printJumpingOrder();
            System.out.println();

            System.out.println("Results of round " + howManyRound);
            printResults();
            System.out.println();
            howManyRound++;

        }
    }

    public void printResults() {
        for (Jumper jumper : round.getPlayersList()) {
            int jumpPoint = round.jumpPointGenerate();
            ArrayList<Integer> judgePoints = round.judgePointGenerate();
            int judgePoint = judgePointCalculate(judgePoints);
            jumper.addPoints(jumpPoint, judgePoint);

            System.out.println("  " + jumper.getName());
            System.out.println("    length: " + jumpPoint);
            printJudgePoints(judgePoints);
        }
    }

    public int judgePointCalculate(ArrayList<Integer> judgePoints) {
        int max = Collections.max(judgePoints);
        int min = Collections.min(judgePoints);
        int totalPoints = 0;

        for (int i : judgePoints) {
            totalPoints += i;
        }
        return totalPoints - max - min;
    }

    public void printJudgePoints(ArrayList<Integer> judgePoints) {
        System.out.print("    judge votes: [");
        System.out.print(judgePoints.get(0));
        for (int i = 1; i < judgePoints.size(); i++) {
            System.out.print(", " + judgePoints.get(i));
        }
        System.out.print("]");
        System.out.println("");
    }

    public void printTornamentResults() {
        System.out.println("Tournament results:");
        System.out.println("Position    Name");
        round.resultFromTheTop();

        int playersNumber = 1;
        for (Jumper jumper : round.getPlayersList()) {
            System.out.println(playersNumber + "           " + jumper);
            System.out.print("            ");
            jumper.printJumpLength();
            playersNumber++;
        }
    }

}
