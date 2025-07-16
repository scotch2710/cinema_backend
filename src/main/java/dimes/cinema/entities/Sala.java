package dimes.cinema.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sala")
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Integer perché l'ID della sala potrebbe non essere un numero enorme

    @Column(name = "nome_sala", nullable = false)
    private String nomeSala;

    @Column(name = "capacita_totale")
    private int capacitaTotale;
}