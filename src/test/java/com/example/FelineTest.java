package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FelineTest {

    @Test
    @DisplayName("Тест eatMeat возвращает правильный список еды для хищника")
    void eatMeatShouldReturnPredatorFood() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        assertEquals(expectedFood, feline.eatMeat());
    }

    @Test
    @DisplayName("Тест getFamily возвращает 'Кошачьи'")
    void getFamilyShouldReturnFelidae() {
        Feline feline = new Feline();

        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    @DisplayName("Тест getKittens без параметра возвращает 1")
    void getKittensWithoutParametersShouldReturnOne() {
        Feline feline = new Feline();

        assertEquals(1, feline.getKittens());
    }

    @Test
    @DisplayName("Тест getKittens с параметром возвращает переданное значение")
    void getKittensWithParameterShouldReturnGivenValue() {
        Feline feline = new Feline();
        int kittensCount = 5;

        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }
}
