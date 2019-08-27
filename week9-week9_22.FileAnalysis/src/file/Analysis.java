package file;
 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
 
public class Analysis {
 
    private File file;
 
    public Analysis(File file) {
        this.file = file;
    }
 
    public int lines() {
        String content = readFile();
        return content.split("\n").length;
    }
 
    public int characters() {
        String content = readFile();
        return content.length();
    }
 
    private String readFile() {
        try {
            String str = "";
 
            Scanner reader = new Scanner(file);
 
            while (reader.hasNextLine()) {
                str += reader.nextLine();
                str += "\n";
            }
 
            return str;
        } catch (FileNotFoundException ex) {
            return "";
        }
    }
}
 