
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

    Scanner reader;
    Flight flihgt;
    Airplane airplane;

    public UserInterface(Scanner reader, Flight flihgt, Airplane airplane) {
        this.reader = reader;
        this.flihgt = flihgt;
        this.airplane = airplane;
    }

    public void start() {

        airportPanel();

    }

    public void airportPanel() {
        System.out.println("Airport panel");
        System.out.println("--------------------");
        System.out.println();
        System.out.println("");
        airportCommand();

        System.out.println("Flight service");
        System.out.println("------------");
        System.out.println("");
        flightService();
    }

    public void airportCommand() {
        while (true) {
            System.out.println("Choose operation:");
            System.out.println("[1] Add airplane");
            System.out.println("[2] Add flight");
            System.out.println("[x] Exit");
            String command = reader.nextLine();
            if (command.equals("1")) {
                addAirplane();
            } else if (command.equals("2")) {
                addFlight();
            } else {
                break;
            }
        }
    }

    public void addAirplane() {
        System.out.print("Give plane ID: ");
        String name = reader.nextLine();
        System.out.print("Give plane capacity: ");
        int capacity = Integer.parseInt(reader.nextLine());
        airplane.addAirplane(name, capacity);
    }

    public void addFlight() {
        System.out.print("Give plane ID: ");
        String name = reader.nextLine();
        System.out.print("Give departure airport code: ");
        String from = reader.nextLine();
        System.out.print("Give destination airport code: ");
        String to = reader.nextLine();
        flihgt.addFlight(name, from, to);
    }

    public void flightService() {
        

        while (true) {
            System.out.println("Choose operation:");
            System.out.println("[1] Print planes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print plane info");
            System.out.println("[x] Quit");

            String command = reader.nextLine();
            if (command.equals("1")) {
                airplane.printPlanes();
            } else if (command.equals("2")) {
                this.flihgt.printFlight();
            } else if (command.equals("3")) {
                planeInfo();
            }else if(command.equals("x")){
                break;
            }
        }
    }

    private void planeInfo() {
        System.out.println("Give plane ID: ");
        String name = reader.nextLine();
        airplane.printPlane(name);
    }
}
