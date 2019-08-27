/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author teruaki
 */
public class Dungeon {

    private final int LENGTH;
    private final int HEIGHT;
    private int vampires;
    private int moves;
    private boolean vampiresMove;
    private Scanner reader = new Scanner(System.in);
    private Player player;
    private List<Vampire> vampiresList;

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.LENGTH = length;
        this.HEIGHT = height;
        this.vampires = vampires;
        this.moves = moves;
        this.vampiresMove = vampiresMove;
        player = new Player(LENGTH, HEIGHT);
        vampiresList = new ArrayList<Vampire>();
        initializeVampire(vampires);
    }

    private void initializeVampire(int vampires) {
        for (int i = 0; i < vampires; i++) {
            Vampire v = new Vampire(LENGTH, HEIGHT);
            if (vampiresList.contains(v)) {
                v.move();
            }
            vampiresList.add(v);
        }
    }

    public void run() {
        while (0 < moves) {
            play();

            if (vampiresList.isEmpty()) {
                System.out.println("YOU WIN");
                return;
            }
            moves--;
        }
        System.out.println("YOU LOSE");
    }

    public void play() {
        printCondition();
        printField();
        command();
    }

    public void printCondition() {
        System.out.println(moves);
        System.out.println();
        System.out.println(player);
        printVampires();
        System.out.println();
    }

    public void printVampires() {
        for (Vampire v : vampiresList) {
            System.out.println(v);
        }
    }

    public void printField() {
        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                EmptySpace empty = new EmptySpace(HEIGHT, LENGTH);
                empty.setPosition(i,j);

                if (empty.equals(player)) {
                    System.out.print("@");

                } else if (vampiresList.contains(empty)) {
                    System.out.print("v");

                } else {
                    System.out.print(".");
                }
            }
            System.out.print("\n");
        }
        System.out.println();

    }

    public void command() {
        String command = reader.nextLine();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'w') {
                moveVertical(-1);

            } else if (command.charAt(i) == 's') {
                moveVertical(1);

            } else if (command.charAt(i) == 'a') {
                moveHorizontal(-1);

            } else if (command.charAt(i) == 'd') {
                moveHorizontal(+1);
            }
            remove();

        }
    }

    private void moveVertical(int i) {
        player.moveVertical(i);
        if (vampiresMove) {
            for (Vampire v : vampiresList) {
                v.move();
            }
        }
    }

    private void moveHorizontal(int i) {
        player.moveHorizontal(i);
        if (vampiresMove) {
            for (Vampire v : vampiresList) {
                v.move();
            }
        }
    }

    private void remove() {
        List<Character> toBeRemoved = new ArrayList<Character>();
        for (Vampire v : vampiresList) {
            if (v.equals(player)) {
                toBeRemoved.add(v);
            }

        }
        vampiresList.removeAll(toBeRemoved);
    }

}
