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

    

    @ManyToOne                     // molti spettacoli possono essere associati ad un unico film
    @JoinColumn(name = "film_id", nullable = false)             // colonna FK nel database
    private Film film;

    @ManyToOne                     // molti spettacoli possono tenersi in una sala
    @JoinColumn(name = "sala_id", nullable = false) 
    private Sala sala;

    

    @Column(name = "data_ora_inizio", nullable = false)
    private LocalDateTime dataOraInizio;

    @Column(name = "prezzo_biglietto", nullable = false)
    private BigDecimal prezzoBiglietto;

    @Column(name = "posti_disponibili")
    private int postiDisponibili;
}