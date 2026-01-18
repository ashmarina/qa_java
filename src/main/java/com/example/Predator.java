package com.example;

import java.util.List;

public interface Predator {
    List<String> eatMeat() throws Exception;
    int getKittens();
    default String getFamily() {
        return "Неизвестное семейство";
    }
}
