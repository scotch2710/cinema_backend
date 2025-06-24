package dimes.cinema.services;

import dimes.cinema.entities.Spettacolo;
import dimes.cinema.repositories.SpettacoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SpettacoloService {

    @Autowired
    private SpettacoloRepository spettacoloRepository;

    /**
     * Trova tutti gli spettacoli programmati per un film specifico.
     * @param filmId L'ID del film di cui cercare gli spettacoli.
     * @return Una lista di oggetti Spettacolo.
     */
    public List<Spettacolo> trovaSpettacoliPerFilm(Long filmId) {
        return spettacoloRepository.findByFilmId(filmId);
    }

    // Qui in futuro potresti aggiungere altri metodi, come "creaNuovoSpettacolo",
    // che sarebbe un'operazione da amministratore.
}
