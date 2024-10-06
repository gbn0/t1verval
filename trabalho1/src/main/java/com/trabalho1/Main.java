package com.trabalho1;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        CalculaTarifa c = new CalculaTarifa();

        LocalDateTime entrada = LocalDateTime.of(2024, 9, 17, 6, 30, 0);
        LocalDateTime saida = LocalDateTime.of(2024, 9, 17, 8, 30, 0);

        System.out.println(c.calculaTarifa(entrada, saida, false));
    }
}