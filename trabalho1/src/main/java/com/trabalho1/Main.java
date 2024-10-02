package com.trabalho1;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        CalculaTarifa c = new CalculaTarifa();

        System.out.println(c.calculaTarifa(LocalDateTime.of(2024, 9, 17, 13, 30, 0), LocalDateTime.now(), false));
    }
}