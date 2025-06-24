package dimes.cinema.repositories;


import dimes.cinema.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, String> {
    // Nota che il tipo dell'ID qui è String, non Long o Integer.
}