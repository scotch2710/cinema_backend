package dimes.cinema.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PrenotazioneRequestDTO {

    @NotNull(message = "L'ID dello spettacolo non può essere nullo.")
    private Long spettacoloId;

    @Min(value = 1, message = "Devi prenotare almeno 1 posto.")
    private int numeroPosti;
    
}