package functionalInterface;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static java.lang.Boolean.TRUE;
import static java.lang.Boolean.FALSE;

public class CustomConsumer {

    public static void main(String[] args) {
        greet(new Customer("Deepak", "+91 9489954765"));
        greetUsingConsumerFI.accept(new Customer("Naresh", "+91 8489308909"));
        greetUsingBiConsumerFI.accept(new Customer("Wiki", "+91 9988776655"), TRUE);
        greetUsingBiConsumerFI.accept(new Customer("Wiki", "+91 9988776655"), FALSE);
    }

    static void greet(Customer customer) {
        System.out.printf("Hi %s, your phone number is %s\n", customer.getName(), customer.getPhoneNumber());
    }

    static Consumer<Customer> greetUsingConsumerFI = (customer) -> System.out.printf("Hi %s, your phone number is %s\n",
            customer.getName(), customer.getPhoneNumber());

    static BiConsumer<Customer, Boolean> greetUsingBiConsumerFI = (customer, showPhoneNumber) -> System.out.printf("Hi %s, your phone number is %s\n",
            customer.getName(), showPhoneNumber ? customer.getPhoneNumber() : "**********");

    @Data
    @AllArgsConstructor
    static class Customer {
        private final String name;
        private final String phoneNumber;
    }
}
