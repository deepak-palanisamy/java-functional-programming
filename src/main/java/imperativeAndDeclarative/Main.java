package imperativeAndDeclarative;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static imperativeAndDeclarative.Main.Gender.MALE;
import static imperativeAndDeclarative.Main.Gender.FEMALE;

public class Main {

    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person("Deepak", MALE),
                new Person("Ava", FEMALE),
                new Person("Murali", MALE),
                new Person("Wiki", MALE),
                new Person("Kamala", FEMALE)
        );

        System.out.println("## imperative");
        List<Person> females = new ArrayList<>();
        for (Person female : persons) {
            if (FEMALE.equals(female.getGender())) {
                females.add(female);
            }
        }

    }

    @Data
    @AllArgsConstructor
    static class Person {
        private final String name;
        private final Gender gender;
    }

    enum Gender {
        MALE, FEMALE
    }

}
