package functionalInterface;

import java.util.function.Function;

public class CustomFunction {

    public static void main(String[] args) {
        System.out.printf("Using Conventional Method. Incremented number is %d\n", incrementByOneUsingConventionalMethod(0));
        int incrementedNumber = incrementByOneUsingFunctionalInterface.apply(0);
        System.out.printf("Using Functional Interface Method. Incremented number is %d\n", incrementedNumber);

        int multipliedNumber = multiplyByTenUsingFunctionalInterface.apply(incrementedNumber);
        System.out.printf("Using Functional Interface Method. Multiplied number is %d", multipliedNumber);
    }

    static Function<Integer, Integer> incrementByOneUsingFunctionalInterface = (number) -> number + 1;
    static Function<Integer, Integer> multiplyByTenUsingFunctionalInterface = (number) -> number * 10;

    static int incrementByOneUsingConventionalMethod(int number) {
        return number + 1;
    }

}
