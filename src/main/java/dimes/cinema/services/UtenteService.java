package dimes.cinema.services;

import dimes.cinema.entities.Utente;
import dimes.cinema.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    /**
     * Cerca un utente nel database locale tramite il suo ID di Keycloak.
     * Se non lo trova, lo crea. Questo garantisce che abbiamo sempre un riferimento
     * locale per ogni utente che interagisce con funzioni importanti come le prenotazioni.
     * @param id L'ID dell'utente fornito da Keycloak.
     * @param username Lo username fornito da Keycloak.
     * @param email L'email fornita da Keycloak.
     * @return L'utente trovato o appena creato.
     */
    @Transactional
    public Utente trovaOcreaUtente(String id, String username, String email) {
        Optional<Utente> utenteEsistente = utenteRepository.findById(id);

        if (utenteEsistente.isPresent()) {
            // se l'utente esiste già nel DB, restituisce quello.
            return utenteEsistente.get();
        } else {
            // se è la prima volta che vediamo questo utente, creiamo un nuovo utente
            Utente nuovoUtente = new Utente();
            nuovoUtente.setId(id);
            nuovoUtente.setUsername(username);
            nuovoUtente.setEmail(email);
            return utenteRepository.save(nuovoUtente);
        }
    }
}
