
import containers.ProductContainer;
import containers.ProductContainerRecorder;

public class Main {

    public static void main(String[] args) {
        // the well known way:
        ProductContainerRecorder juice = new ProductContainerRecorder("Juice", 1000.0, 5.0);
        juice.addToTheContainer(2);
        juice.takeFromTheContainer(9);
        juice.addToTheContainer(5);
        juice.takeFromTheContainer(3);
        juice.addToTheContainer(15);
        juice.takeFromTheContainer(16);
        juice.addToTheContainer(6);
        juice.takeFromTheContainer(3);
        juice.addToTheContainer(11);
        juice.takeFromTheContainer(12);
        juice.addToTheContainer(1);
//System.out.println(juice.history()); // [1000.0, 988.7, 989.7]

        juice.printAnalysis(); // [1000.0]

    }
}
