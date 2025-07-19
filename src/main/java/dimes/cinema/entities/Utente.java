package dimes.cinema.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "utenti")
public class Utente {

    @Id // è la chiave primaria ma non è auto-generata, è l'id dell'utente su keycloak
    @Column(length = 36) // id di keycloak è una stringa di 36 caratteri
    private String id;

    @Column(unique = true, nullable = false) // username dovrebbe essere unico
    private String username;

    @Column(unique = true, nullable = true)
    private String email;

    
}