package functionalInterface;

import java.util.function.Function;

public class CustomFunction {

    public static void main(String[] args) {
        System.out.printf("Using Conventional Method. Incrementing number is %d\n", incrementByOneUsingConventionalMethod(0));
        System.out.printf("Using Functional Interface Method. Incremented number is %d", incrementByOneUsingFunctionalInterface.apply(0));
    }

    static Function<Integer, Integer> incrementByOneUsingFunctionalInterface = (number) -> number + 1;

    static int incrementByOneUsingConventionalMethod(int number) {
        return number + 1;
    }

}
