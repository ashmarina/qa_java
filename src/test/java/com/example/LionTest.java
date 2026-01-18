package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    private Predator predator;

    @Test
    void lionConstructorShouldSetManeForMale() throws Exception {
        Lion lion = new Lion("Самец", predator);

        assertTrue(lion.doesHaveMane());
    }

    @Test
    void lionConstructorShouldNotSetManeForFemale() throws Exception {
        Lion lion = new Lion("Самка", predator);

        assertFalse(lion.doesHaveMane());
    }

    @Test
    void lionConstructorShouldThrowExceptionForInvalidSex() {
        Exception exception = assertThrows(Exception.class,
                () -> new Lion("Неизвестный", predator));

        assertEquals("Используйте допустимые значения пола животного - самец или самка",
                exception.getMessage());
    }

    @Test
    void getKittensShouldCallPredatorGetKittens() throws Exception {
        Lion lion = new Lion("Самец", predator);
        int expectedKittens = 3;

        when(predator.getKittens()).thenReturn(expectedKittens);

        int actualKittens = lion.getKittens();

        assertEquals(expectedKittens, actualKittens);
        verify(predator, times(1)).getKittens();
    }

    @Test
    void getFoodShouldCallPredatorEatMeat() throws Exception {
        Lion lion = new Lion("Самка", predator);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        when(predator.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = lion.getFood();

        assertEquals(expectedFood, actualFood);
        verify(predator, times(1)).eatMeat();
    }
}
