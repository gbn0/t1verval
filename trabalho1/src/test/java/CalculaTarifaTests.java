import java.time.LocalDateTime;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

import com.trabalho1.CalculaTarifa;

public class CalculaTarifaTests {

    private final CalculaTarifa calculaTarifa = new CalculaTarifa();

    @ParameterizedTest
    @CsvSource({
            "2024-09-17T13:30:00, 2024-09-17T13:31:00, false, 0.0",
            "2024-09-17T13:30:00, 2024-09-17T13:44:59, false, 0.0",
    })
    void testaTarifaGratisNormal(String entrada, String saida, boolean vip, double valorEsperado) {
        LocalDateTime horarioEntrada = LocalDateTime.parse(entrada);
        LocalDateTime horarioSaida = LocalDateTime.parse(saida);
        assertEquals(valorEsperado, calculaTarifa.calculaTarifa(horarioEntrada, horarioSaida, vip));
    }

    @ParameterizedTest
    @CsvSource({
            "2024-09-17T13:30:00, 2024-09-17T13:31:00, true, 0.0",
            "2024-09-17T13:30:00, 2024-09-17T13:44:59, true, 0.0",
    })
    void testaTarifaGratisVip(String entrada, String saida, boolean vip, double valorEsperado) {
        LocalDateTime horarioEntrada = LocalDateTime.parse(entrada);
        LocalDateTime horarioSaida = LocalDateTime.parse(saida);
        assertEquals(valorEsperado, calculaTarifa.calculaTarifa(horarioEntrada, horarioSaida, vip));
    }

    @ParameterizedTest
    @CsvSource({
            "2024-09-17T13:30:00, 2024-09-17T13:45:00, false, 5.9",
            "2024-09-17T13:30:00, 2024-09-17T14:29:59, false, 5.9",
    })

    void testaTarifaUmaHoraNormal(String entrada, String saida, boolean vip, double valorEsperado) {
        LocalDateTime horarioEntrada = LocalDateTime.parse(entrada);
        LocalDateTime horarioSaida = LocalDateTime.parse(saida);
        assertEquals(valorEsperado, calculaTarifa.calculaTarifa(horarioEntrada, horarioSaida, vip));
    }

    @ParameterizedTest
    @CsvSource({
            "2024-09-17T13:30:00, 2024-09-17T13:45:00, true, 2.95",
            "2024-09-17T13:30:00, 2024-09-17T14:29:59, true, 2.95",
    })
    void testaTarifaUmaHoraVip(String entrada, String saida, boolean vip, double valorEsperado) {
        LocalDateTime horarioEntrada = LocalDateTime.parse(entrada);
        LocalDateTime horarioSaida = LocalDateTime.parse(saida);
        assertEquals(valorEsperado, calculaTarifa.calculaTarifa(horarioEntrada, horarioSaida, vip));
    }

    @ParameterizedTest
    @CsvSource({
            "2024-09-17T13:30:00, 2024-09-17T15:30:00, false, 8.4",
            "2024-09-17T13:30:00, 2024-09-17T16:29:59, false, 8.4",

    })
    void testaTarifaMaisUmaHoraSemPernoite(String entrada, String saida, boolean vip, double valorEsperado) {
        LocalDateTime horarioEntrada = LocalDateTime.parse(entrada);
        LocalDateTime horarioSaida = LocalDateTime.parse(saida);
        assertEquals(valorEsperado, calculaTarifa.calculaTarifa(horarioEntrada, horarioSaida, vip));
    }

    @ParameterizedTest
    @CsvSource({
            "2024-09-17T13:30:00, 2024-09-17T15:30:00, true, 4.2",
            "2024-09-17T13:30:00, 2024-09-17T16:29:59, true, 4.2",

    })
    void testaTarifaMaisUmaHoraSemPernoiteVip(String entrada, String saida, boolean vip, double valorEsperado) {
        LocalDateTime horarioEntrada = LocalDateTime.parse(entrada);
        LocalDateTime horarioSaida = LocalDateTime.parse(saida);
        assertEquals(valorEsperado, calculaTarifa.calculaTarifa(horarioEntrada, horarioSaida, vip));
    }

    @ParameterizedTest
    @CsvSource({
            "2024-09-17T13:30:00, 2024-09-18T13:30:00, false, 50.0",
            "2024-09-17T13:30:00, 2024-09-19T13:29:59, false, 100.0",
    })
    void testaTarifaPernoiteNormal(String entrada, String saida, boolean vip, double valorEsperado) {
        LocalDateTime horarioEntrada = LocalDateTime.parse(entrada);
        LocalDateTime horarioSaida = LocalDateTime.parse(saida);
        assertEquals(valorEsperado, calculaTarifa.calculaTarifa(horarioEntrada, horarioSaida, vip));
    }

    @ParameterizedTest
    @CsvSource({
            "2024-09-17T13:30:00, 2024-09-18T13:30:00, true, 25.0",
            "2024-09-17T13:30:00, 2024-09-19T13:29:59, true, 50.0",
    })
    void testaTarifaPernoiteVip(String entrada, String saida, boolean vip, double valorEsperado) {
        LocalDateTime horarioEntrada = LocalDateTime.parse(entrada);
        LocalDateTime horarioSaida = LocalDateTime.parse(saida);
        assertEquals(valorEsperado, calculaTarifa.calculaTarifa(horarioEntrada, horarioSaida, vip));
    }
}
