package dimes.cinema.entities;

import jakarta.persistence.*;
import lombok.Data; // Lombok serve per generare automaticamente getter, setter, etc.

@Data 
@Entity // indica che questa classe è un'entità
@Table(name = "films") // indica il nome della tabella
public class Film {

    @Id // id sarà la chiava primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // genera l'id automaticamente
    private Long id;

    @Column(name = "titolo", nullable = false, length = 255) 
    private String titolo;

    @Column(name = "trama", columnDefinition = "TEXT") 
    private String trama; 

    @Column(name = "durata_minuti")
    private int durataMinuti; 

    @Column(name = "percorso_locandina", length = 255)
    private String percorsoLocandina;
}