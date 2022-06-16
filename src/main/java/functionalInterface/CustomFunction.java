package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class CustomFunction {

    public static void main(String[] args) {
        System.out.printf("Using Conventional Method. Incremented number is %d\n", incrementByOneUsingConventionalMethod(0));

        int incrementedNumber = incrementByOneUsingFunctionalInterface.apply(0);
        System.out.printf("Using Functional Interface Method. Incremented number is %d\n", incrementedNumber);

        int multipliedNumber = multiplyByTenUsingFunctionalInterface.apply(incrementedNumber);
        System.out.printf("Using Functional Interface Method. Multiplied number is %d\n", multipliedNumber);

        int incrementedAndMultipliedNumber = incrementBy1AndMultiplyBy10UsingFunctionalInterface.apply(0);
        System.out.printf("Using Functional Interface Method. Incremented and Multiplied number is %d\n", incrementedAndMultipliedNumber);

        int incrementedAndMultipliedNumberByBiFunction = incrementBy1AndMultiplyBy10UsingBiFunction.apply(1, 20);
        System.out.printf("Using BiFunction Functional Interface Method. Incremented and Multiplied number is %d", incrementedAndMultipliedNumberByBiFunction);

    }

    static Function<Integer, Integer> incrementByOneUsingFunctionalInterface = (number) -> number + 1;
    static Function<Integer, Integer> multiplyByTenUsingFunctionalInterface = (number) -> number * 10;
    static Function<Integer, Integer> incrementBy1AndMultiplyBy10UsingFunctionalInterface = incrementByOneUsingFunctionalInterface.andThen(multiplyByTenUsingFunctionalInterface);

    static BiFunction<Integer, Integer, Integer> incrementBy1AndMultiplyBy10UsingBiFunction = (numberToBeIncremented, numberToBeMultiplied) -> (numberToBeIncremented + 1) * numberToBeMultiplied;

    static int incrementByOneUsingConventionalMethod(int number) {
        return number + 1;
    }

}
