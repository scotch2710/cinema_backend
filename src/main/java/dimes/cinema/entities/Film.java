package dimes.cinema.entities;

import jakarta.persistence.*;
import lombok.Data; // Lombok serve per generare automaticamente getter, setter, etc.

@Data // Annotazione di Lombok
@Entity // Dice a JPA: "Questa classe è un'entità e rappresenta una tabella nel database"
@Table(name = "films") // Specifica che il nome della tabella nel DB sarà "films"
public class Film {

    @Id // Marca questo campo come Chiave Primaria (PK)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Dice al DB di generare l'ID automaticamente (auto-incremento)
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