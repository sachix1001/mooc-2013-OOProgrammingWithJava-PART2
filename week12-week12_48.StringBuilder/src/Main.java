
public class Main {

    public static void main(String[] args) {
        int[] t = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(build(t));
    }

    public static String build(int[] t) {
        StringBuilder str = new StringBuilder();
        str.append(" ");
        int count = 1;

        for (int i = 0; i < t.length - 1; i++) {

            str.append(t[i] + ", ");
            if (count % 4 == 0) {
                str.append("\n ");
            }
            count++;
        }
        str.append(t[t.length-1]);

        return "{\n" + str + "\n}";
    }
}
