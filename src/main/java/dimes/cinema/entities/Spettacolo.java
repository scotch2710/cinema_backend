package dimes.cinema.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "spettacoli")
public class Spettacolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    

    @ManyToOne // Molti spettacoli possono essere associati a un film
    @JoinColumn(name = "film_id", nullable = false) // Questa è la colonna FK nel database
    private Film film;

    @ManyToOne // Molti spettacoli possono tenersi in una sala
    @JoinColumn(name = "sala_id", nullable = false) // Colonna FK per la sala
    private Sala sala;

    

    @Column(name = "data_ora_inizio", nullable = false)
    private LocalDateTime dataOraInizio;

    @Column(name = "prezzo_biglietto", nullable = false)
    private BigDecimal prezzoBiglietto;

    @Column(name = "posti_disponibili")
    private int postiDisponibili;
}