
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        
        
        Round round = new Round();
        Scanner reader = new Scanner(System.in);
        UserInterface me = new UserInterface(reader, round);
        me.start();
        
        
        
    }
}
