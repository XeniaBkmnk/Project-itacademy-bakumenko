package by.itacademy.bakumenko.domain;

import com.github.javafaker.Faker;

public class User {
    public static String getRandomNonCorrectEmail() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    public static String getRandomCorrectEmail() {
        Faker faker = new Faker();
        return faker.internet().safeEmailAddress(faker.name().firstName());
    }

    public static String getRandomPassword() {
        Faker faker = new Faker();
        return faker.internet().password();
    }

}