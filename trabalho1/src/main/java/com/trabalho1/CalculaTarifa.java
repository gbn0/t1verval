package com.trabalho1;

import java.time.Duration;
import java.time.LocalDateTime;

public class CalculaTarifa {

    public CalculaTarifa() {

    }

    public double calculaTarifa(LocalDateTime entrada, LocalDateTime saida, boolean vip) {
        // if(entrada == null || saida == null) {
        // System.out.println("Data de entrada ou saída não pode ser nula");
        // return 0;
        // } else if(entrada.isAfter(saida)) {
        // System.out.println("Data de entrada não pode ser depois da data de saída");
        // return 0;
        // }

        Duration duracao = Duration.between(entrada, saida);
        double tarifa = 0;
        boolean pernoite = saida.isAfter(entrada.plusDays(1).withHour(8).withMinute(0).withSecond(0));

        // 15 min de permanência
        if (saida.isBefore(entrada.plusMinutes(15))) {
            return tarifa;
        }

        // acima de 1h sem pernoite
        if (!pernoite) {
            tarifa = 5.9 + (duracao.toHours() - 1) * 2.5;
        }

        // pernoite
        if (pernoite) {
            tarifa = 50 * (saida.getDayOfMonth() - entrada.getDayOfMonth());
        }
        // 1h ou menos de permanência
        if (saida.isBefore(entrada.plusHours(1))) {
            tarifa = 5.9;
        }

        return vip ? tarifa * 0.5 : tarifa;
    }
}
