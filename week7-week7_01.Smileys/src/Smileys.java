
public class Smileys {

    public static void main(String[] args) {
        // Test your method at least with the following
        printWithSmileys("Method");
        // printWithSmileys("Beerbottle");
        // printWithSmileys("Interface");
    }

    private static void printWithSmileys(String characterString) {
        characterString = " "+ characterString + " ";
        if (characterString.length() % 2 == 1) {
            characterString += " ";
        }
        
        printLine(characterString);
        printLineWithCharacterString(characterString);
        printLine(characterString);

    }

    static void printSmile(){
        System.out.print(":)");
    }
    static void printLine(String characterString) {
        int length = characterString.length() / 2 + 2;

        for (int i = 0; i < length; i++) {
            printSmile();
        }
        System.out.println();
    }
    
    static void printLineWithCharacterString(String characterString){
        printSmile();
        System.out.print(characterString);
        printSmile();
        System.out.println();
    }

}
