package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CatTest {

    @Mock
    private Predator predator;

    @Test
    void getSoundShouldReturnMeow() {
        Cat cat = new Cat(predator);

        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void getFoodShouldCallEatMeatOnPredator() throws Exception {
        Cat cat = new Cat(predator);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        when(predator.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = cat.getFood();

        assertEquals(expectedFood, actualFood);
        verify(predator, times(1)).eatMeat();
    }

    @Test
    void getFoodShouldPropagateException() throws Exception {
        Cat cat = new Cat(predator);
        Exception expectedException = new Exception("Ошибка получения еды");

        when(predator.eatMeat()).thenThrow(expectedException);

        Exception actualException = assertThrows(Exception.class, cat::getFood);

        assertEquals(expectedException, actualException);
        verify(predator, times(1)).eatMeat();
    }
}