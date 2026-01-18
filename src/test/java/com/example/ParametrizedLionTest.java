package com.example;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@ExtendWith(MockitoExtension.class)
class ParametrizedLionTest {

    @Mock
    private Predator predator;

    @ParameterizedTest
    @MethodSource("sexAndManeProvider")
    void lionShouldHaveCorrectManeForSex(String sex, boolean expectedHasMane) throws Exception {
        Lion lion = new Lion(sex, predator);

        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

    private static Stream<Arguments> sexAndManeProvider() {
        return Stream.of(
                arguments("Самец", true),
                arguments("Самка", false)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"Неизвестный", "", "Мужской", "Женский", "123"})
    void lionConstructorShouldThrowExceptionForInvalidSex(String invalidSex) {
        Exception exception = assertThrows(Exception.class,
                () -> new Lion(invalidSex, predator));

        assertEquals("Используйте допустимые значения пола животного - самец или самка",
                exception.getMessage());
    }
}
