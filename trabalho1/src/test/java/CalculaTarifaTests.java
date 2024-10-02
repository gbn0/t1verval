import java.time.LocalDateTime;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

import com.trabalho1.CalculaTarifa;


public class CalculaTarifaTests {

    private final CalculaTarifa calculaTarifa = new CalculaTarifa();

    @ParameterizedTest
    @CsvSource({
        "2024-10-01T13:30:00, 2024-10-01T13:45:00, false, 0.0",
        "2024-10-01T13:30:00, 2024-10-01T13:40:00, true, 0.0",
        "2024-10-01T13:30:00, 2024-10-01T13:45:01, false, 5.9"
    })
    void testaTarifaGratis(String entrada, String saida, boolean vip, double valorEsperado) {
        LocalDateTime horarioEntrada = LocalDateTime.parse(entrada);
        LocalDateTime horarioSaida = LocalDateTime.parse(saida);
        assertEquals(valorEsperado, calculaTarifa.calculaTarifa(horarioEntrada, horarioSaida, vip));
    }

    @ParameterizedTest
    @CsvSource({
        "2024-09-17T13:30:00, 2024-09-17T14:30:00, false, 5.9",
        "2024-09-17T13:30:00, 2024-09-17T14:30:00, true, 2.95"
    })
    void testaTarifaGratisVip(String entrada, String saida, boolean vip, double valorEsperado) {
        LocalDateTime horarioEntrada = LocalDateTime.parse(entrada);
        LocalDateTime horarioSaida = LocalDateTime.parse(saida);
        assertEquals(valorEsperado, calculaTarifa.calculaTarifa(horarioEntrada, horarioSaida, vip));
    }

    @ParameterizedTest
    @CsvSource({
        "2024-09-17T13:30:00, 2024-09-17T14:30:00, false, 5.9",
        "2024-09-17T13:30:00, 2024-09-17T14:30:00, true, 2.95"
    })
    void testaTarifaUmaHora(String entrada, String saida, boolean vip, double valorEsperado) {
        LocalDateTime horarioEntrada = LocalDateTime.parse(entrada);
        LocalDateTime horarioSaida = LocalDateTime.parse(saida);
        assertEquals(valorEsperado, calculaTarifa.calculaTarifa(horarioEntrada, horarioSaida, vip));
    }

    @ParameterizedTest
    @CsvSource({
        "2024-09-17T13:30:00, 2024-09-17T14:30:00, false, 5.9",
        "2024-09-17T13:30:00, 2024-09-17T14:30:00, true, 2.95"
    })
    void testaTarifaMeiaHora(String entrada, String saida, boolean vip, double valorEsperado) {
        LocalDateTime horarioEntrada = LocalDateTime.parse(entrada);
        LocalDateTime horarioSaida = LocalDateTime.parse(saida);
        assertEquals(valorEsperado, calculaTarifa.calculaTarifa(horarioEntrada, horarioSaida, vip));
    }

    @ParameterizedTest
    @CsvSource({
        
    })
    void testaTarifaUmaHoraVip(String entrada, String saida, boolean vip, double valorEsperado) {
        LocalDateTime horarioEntrada = LocalDateTime.parse(entrada);
        LocalDateTime horarioSaida = LocalDateTime.parse(saida);
        assertEquals(valorEsperado, calculaTarifa.calculaTarifa(horarioEntrada, horarioSaida, vip));
    }
    
}
