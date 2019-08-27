
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        Airplane airplane = new Airplane();
        Flight flight = new Flight(airplane);
        
        UserInterface user = new UserInterface(reader, flight, airplane);
        user.start();
    }
    
    
    
}
