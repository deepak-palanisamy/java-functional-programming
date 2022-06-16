package functionalInterface;

import java.util.function.Predicate;
import java.util.regex.Pattern;

import static functionalInterface.CustomPredicate.EmailStatus.VALID;
import static functionalInterface.CustomPredicate.EmailStatus.INVALID;

public class CustomPredicate {

    public static final String EMAIL_PATTERN1 = "[\\w\\d]{2,}@[\\w\\d]+.\\w{2,}";
    public static final String EMAIL_PATTERN2 = "[\\w\\d]{2,}@breezeware.\\w{2,}";
    public static final String EMAIL_PATTERN3 = "[\\w\\d]{2,}@[\\w\\d]+.net";

    public static void main(String[] args) {

        String email1 = "deepak@breezeware.net";
        String email2 = "deepak@breezeware.";
        String email3 = "deepak@.net";
        String email4 = "deepak@breezeware.n";
        String email5 = "@breezeware.ne";
        String email6 = "de@breezeware.ne";

        System.out.printf("Using Conventional method. Email '%s' is %s\n", email1, isEmailValid(email1) ? VALID : INVALID);
        System.out.printf("Using Conventional method. Email '%s' is %s\n", email2, isEmailValid(email2) ? VALID : INVALID);
        System.out.printf("Using Conventional method. Email '%s' is %s\n", email3, isEmailValid(email3) ? VALID : INVALID);
        System.out.printf("Using Conventional method. Email '%s' is %s\n", email4, isEmailValid(email4) ? VALID : INVALID);
        System.out.printf("Using Conventional method. Email '%s' is %s\n", email5, isEmailValid(email5) ? VALID : INVALID);
        System.out.printf("Using Conventional method. Email '%s' is %s\n", email6, isEmailValid(email6) ? VALID : INVALID);
        System.out.println();

        System.out.printf("Using FunctionalInterface's Predicate method. Email '%s' is %s\n", email1, isEmailValidUsingFI.test(email1) ? VALID : INVALID);
        System.out.printf("Using FunctionalInterface's Predicate method. Email '%s' is %s\n", email2, isEmailValidUsingFI.test(email2) ? VALID : INVALID);
        System.out.printf("Using FunctionalInterface's Predicate method. Email '%s' is %s\n", email3, isEmailValidUsingFI.test(email3) ? VALID : INVALID);
        System.out.printf("Using FunctionalInterface's Predicate method. Email '%s' is %s\n", email4, isEmailValidUsingFI.test(email4) ? VALID : INVALID);
        System.out.printf("Using FunctionalInterface's Predicate method. Email '%s' is %s\n", email5, isEmailValidUsingFI.test(email5) ? VALID : INVALID);
        System.out.printf("Using FunctionalInterface's Predicate method. Email '%s' is %s\n", email6, isEmailValidUsingFI.test(email6) ? VALID : INVALID);
        System.out.println();

        boolean isEmailValidAndContainsTextBreezeware = isEmailValidUsingFI.and(containsTextBreezewareUsingFI).test(email1);
        System.out.printf("Using FunctionalInterface's Predicate method. Email '%s' is %s %s\n", email1,
                isEmailValidAndContainsTextBreezeware ? VALID : INVALID,
                (isEmailValidAndContainsTextBreezeware) ? "and contains text 'breezeware'" : "");

        boolean isEmailValidOrEndsWithTextNet = isEmailValidUsingFI.or(endsWithTextNetUsingFI).test(email3);
//        System.out.printf("Using FunctionalInterface's Predicate method. Email '%s' is %s or %s with text 'net'\n", email1,
//                isEmailValidOrEndsWithTextNet ? VALID : INVALID, isEmailValidOrEndsWithTextNet ? "ends" : "not ends");
        System.out.printf("Using FunctionalInterface's Predicate method. Either email '%s' is VALID or ends with text 'net", email3);

    }

    static boolean isEmailValid(String email) {
        return Pattern.matches(EMAIL_PATTERN1, email);
    }

    static Predicate<String> isEmailValidUsingFI = (email) -> Pattern.matches(EMAIL_PATTERN1, email);
    static Predicate<String> containsTextBreezewareUsingFI = (email) -> Pattern.matches(EMAIL_PATTERN2, email);
    static Predicate<String> endsWithTextNetUsingFI = (email) -> Pattern.matches(EMAIL_PATTERN3, email);

    enum EmailStatus {
        VALID, INVALID
    }
}
