package dimes.cinema.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "utenti")
public class Utente {

    @Id // È la chiave primaria, ma non è auto-generata
    @Column(length = 36) // L'ID di Keycloak è una stringa di 36 caratteri
    private String id;

    @Column(unique = true, nullable = false) // Lo username dovrebbe essere unico
    private String username;

    @Column(unique = true, nullable = true)
    private String email;

    
}