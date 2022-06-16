package functionalInterface;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.Consumer;

public class CustomConsumer {

    public static void main(String[] args) {
        greet(new Customer("Deepak", "+91 9489954765"));
        greetUsingConsumerFI.accept(new Customer("Naresh", "+91 8489308909"));
    }

    static void greet(Customer customer) {
        System.out.printf("Hi %s, your phone number is %s\n", customer.getName(), customer.getPhoneNumber());
    }

    static Consumer<Customer> greetUsingConsumerFI = (customer) -> System.out.printf("Hi %s, your phone number is %s",
            customer.getName(), customer.getPhoneNumber());

    @Data
    @AllArgsConstructor
    static class Customer {
        private final String name;
        private final String phoneNumber;
    }
}
