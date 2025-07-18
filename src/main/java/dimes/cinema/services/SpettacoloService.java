package dimes.cinema.services;

import dimes.cinema.dto.SpettacoloRequestDTO;
import dimes.cinema.entities.Film;
import dimes.cinema.entities.Sala;
import dimes.cinema.entities.Spettacolo;
import dimes.cinema.repositories.FilmRepository;
import dimes.cinema.repositories.SalaRepository;
import dimes.cinema.repositories.SpettacoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SpettacoloService {

    @Autowired
    private SpettacoloRepository spettacoloRepository;
    
    
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private SalaRepository salaRepository;

    @Transactional(readOnly = true)
    public List<Spettacolo> trovaSpettacoliPerFilm(Long filmId) {
        return spettacoloRepository.findByFilmId(filmId);
    }
    
    @Transactional
    public Spettacolo creaSpettacolo(SpettacoloRequestDTO requestDTO) {
        // 1. Trova le entità collegate (Film e Sala) usando gli ID forniti.
        Film film = filmRepository.findById(requestDTO.getFilmId())
                .orElseThrow(() -> new RuntimeException("Film non trovato con id: " + requestDTO.getFilmId()));
        
        Sala sala = salaRepository.findById(requestDTO.getSalaId())
                .orElseThrow(() -> new RuntimeException("Sala non trovata con id: " + requestDTO.getSalaId()));

        // 2. Crea la nuova entità Spettacolo.
        Spettacolo nuovoSpettacolo = new Spettacolo();
        nuovoSpettacolo.setFilm(film);
        nuovoSpettacolo.setSala(sala);
        nuovoSpettacolo.setDataOraInizio(requestDTO.getDataOraInizio());
        nuovoSpettacolo.setPrezzoBiglietto(requestDTO.getPrezzoBiglietto());
        
        // 3. Logica di business: inizializza i posti disponibili con la capacità della sala.
        nuovoSpettacolo.setPostiDisponibili(sala.getCapacitaTotale());
        
        // 4. Salva il nuovo spettacolo nel database.
        return spettacoloRepository.save(nuovoSpettacolo);
    }
}