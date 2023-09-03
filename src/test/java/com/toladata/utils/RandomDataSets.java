package com.toladata.utils;

import com.github.javafaker.Faker;

public class RandomDataSets {
    public static String randomProjectNames() {
        Faker faker = new Faker();

        return "Project" + " " + faker.animal().name();
    }

    public static String randomPhaseNames() {
        Faker faker = new Faker();

        return "Phase" + " " + faker.number().randomNumber();
    }
}
