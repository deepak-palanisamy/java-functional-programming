package functionalInterface;

public class CustomFunction {

    public static void main(String[] args) {
        System.out.printf("Incremented number is %d", increment(0));
    }

    static int increment(int number) {
        return number + 1;
    }

}
