package dimes.cinema.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class SpettacoloRequestDTO {

    @NotNull(message = "L'ID del film è obbligatorio.")
    private Long filmId;

    @NotNull(message = "L'ID della sala è obbligatorio.")
    private Integer salaId;

    @NotNull(message = "La data e l'ora di inizio sono obbligatorie.")
    @Future(message = "La data dello spettacolo deve essere nel futuro.")
    private LocalDateTime dataOraInizio;

    @NotNull(message = "Il prezzo del biglietto è obbligatorio.")
    @Positive(message = "Il prezzo del biglietto deve essere positivo.")
    private BigDecimal prezzoBiglietto;
}