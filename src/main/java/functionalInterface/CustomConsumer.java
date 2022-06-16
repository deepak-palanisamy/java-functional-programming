package functionalInterface;

import lombok.AllArgsConstructor;
import lombok.Data;

public class CustomConsumer {

    public static void main(String[] args) {
        greet(new Customer("Deepak", "+91 9489954765"));
    }

    static void greet(Customer customer) {
        System.out.printf("Hi %s, your phone number is %s", customer.getName(), customer.getPhoneNumber());
    }

    @Data
    @AllArgsConstructor
    static class Customer {
        private final String name;
        private final String phoneNumber;
    }
}
