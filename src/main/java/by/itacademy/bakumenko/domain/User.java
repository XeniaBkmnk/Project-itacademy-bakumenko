package by.itacademy.bakumenko.domain;

import com.github.javafaker.Faker;

public class User {
    public static String getRandomNonCorrectEmail() {
        Faker faker = new Faker();
        return faker.name().firstName()
                + "@test";
    }

    public static String getRandomCorrectEmail() {
        Faker faker = new Faker();
        return faker.internet().safeEmailAddress(faker.name().firstName());
    }
}