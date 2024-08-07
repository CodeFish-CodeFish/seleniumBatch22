package gitForClass;

import com.github.javafaker.Faker;

public class JavaFakeClass {
    public static void main(String[] args) {
        Faker faker = new Faker();
        String firstName1 = faker.name().fullName();

        System.out.println(firstName1);
        System.out.println(faker.address().city());
        System.out.println(faker.address().country());

    }
}
