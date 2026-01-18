package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ParametrizedFelineTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 5, 10, 100})
    void getKittensShouldReturnSpecifiedCount(int kittensCount) {
        Feline feline = new Feline();

        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 1",
            "5, 5",
            "10, 10"
    })
    void getKittensWithParameterShouldReturnCorrectValue(int input, int expected) {
        Feline feline = new Feline();

        assertEquals(expected, feline.getKittens(input));
    }
}