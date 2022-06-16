package functionalInterface;

import java.util.regex.Pattern;

import static functionalInterface.CustomPredicate.EmailStatus.VALID;
import static functionalInterface.CustomPredicate.EmailStatus.INVALID;

public class CustomPredicate {

    public static void main(String[] args) {

        String email1 = "deepak@breezeware.net";
        String email2 = "deepak@breezeware.";
        String email3 = "deepak@.net";
        String email4 = "deepak@breezeware.n";
        String email5 = "@breezeware.ne";
        String email6 = "de@breezeware.ne";

        System.out.printf("Email %s is %s\n", email1, isEmailValid(email1) ? VALID : INVALID);
        System.out.printf("Email %s is %s\n", email2, isEmailValid(email2) ? VALID : INVALID);
        System.out.printf("Email %s is %s\n", email3, isEmailValid(email3) ? VALID : INVALID);
        System.out.printf("Email %s is %s\n", email4, isEmailValid(email4) ? VALID : INVALID);
        System.out.printf("Email %s is %s\n", email5, isEmailValid(email5) ? VALID : INVALID);
        System.out.printf("Email %s is %s\n", email6, isEmailValid(email6) ? VALID : INVALID);

    }

    static boolean isEmailValid(String email) {
        String emailPattern = "[\\w\\d]{2,}@[\\w\\d]+.\\w{2,}";
        return Pattern.matches(emailPattern, email);
    }

    enum EmailStatus {
        VALID, INVALID
    }
}
