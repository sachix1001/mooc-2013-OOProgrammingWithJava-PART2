
import java.util.ArrayList;
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
public class Flight {

    private ArrayList<String> flights;
    private Airplane airplanes;

    public Flight(Airplane airplanes) {
        flights = new ArrayList<String>();
        this.airplanes = airplanes;
    }

    public void addFlight(String name, String fromAirport, String toAirport) {
        String flight = airplanes.getAirplane(name) + " (" + fromAirport + "-" + toAirport + ")";
        flights.add(flight);
    }

    public void printFlight() {
        for (String flight : this.flights) {
            System.out.println(flight);
        }
    }
}
