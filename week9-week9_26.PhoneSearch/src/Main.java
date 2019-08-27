
import java.util.Scanner;
import phoneSearch.UserInterface;
import phoneSearch.phoneSearch;

public class Main {

    public static void main(String[] args) {
        String test = "4\n" + "pekka\n"
                + "mannerheimintie\n"
                + "helsinki\n"
                + "5\n"
                + "pekka\n"
                + "x\n";
        Scanner reader = new Scanner(System.in);
        UserInterface u = new UserInterface(reader);
        u.start();

    }
}
