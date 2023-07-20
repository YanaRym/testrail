package utilities;

import com.github.javafaker.Faker;

public class TestDataGenerator {
    private static Faker faker = new Faker();

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomPassword() {
        return faker.internet().password();
    }

    public static String getRandomAddress() {
        return faker.bothify("##?#??");
    }

    public static String getRandomFullName() {
        return faker.name().fullName();
    }

}

