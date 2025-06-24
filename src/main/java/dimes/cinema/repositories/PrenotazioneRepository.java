package dimes.cinema.repositories;


import dimes.cinema.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    // Qui potresti aggiungere un metodo per trovare tutte le prenotazioni di un utente:
    // List<Prenotazione> findByUtenteId(String utenteId);
}