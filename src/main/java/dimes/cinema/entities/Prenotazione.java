package dimes.cinema.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "prenotazioni")
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "spettacolo_id", nullable = false)
    private Spettacolo spettacolo;

    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente;

    @Column(name = "data_prenotazione", nullable = false)
    private LocalDateTime dataPrenotazione;

    @Column(name = "numero_biglietti")
    private int numeroBiglietti;

    //@Column(name = "numero_posto_fila")
    //private String numeroPostoFila;

    //@Column(name = "numero_posto_sedia")
    //private int numeroPostoSedia;
    
    @Column(name = "prezzo_pagato")
    private BigDecimal prezzoPagato;
}