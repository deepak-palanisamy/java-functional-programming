package functionalInterface;

import java.util.function.Supplier;

public class CustomSupplier {
    public static void main(String[] args) {
        System.out.printf("Getting org name '%s' using conventional method\n", getOrgName());
        System.out.printf("Getting org name '%s' using FunctionalInterface method", getOrgNameUsingFI.get());
    }

    static String getOrgName() {
        return "Breezeware";
    }

    static Supplier<String> getOrgNameUsingFI = () -> "Breezeware";
}
