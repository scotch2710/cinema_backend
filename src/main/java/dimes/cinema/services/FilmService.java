package dimes.cinema.services;

import dimes.cinema.entities.Film;
import dimes.cinema.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service // registra questa classe come un Service di Spring
public class FilmService {

    // Spring "inietterà" automaticamente un'istanza del FilmRepository
    @Autowired
    private FilmRepository filmRepository;

    @Transactional(readOnly = true)
    public Optional<Film> trovaFilmPerId(Long id) {
       return filmRepository.findById(id);
    }

    /**
     * Restituisce la lista di tutti i film presenti nel database.
     * @return una lista di oggetti Film.
     */
    @Transactional(readOnly = true)
     public List<Film> trovaTuttiIFilm() {
        return filmRepository.findAll();
    }

    /**
     * Aggiunge un nuovo film al database.
     * @param film l'oggetto Film da salvare.
     * @return il film salvato, completo di ID generato dal database.
     */
    @Transactional
     public Film aggiungiFilm(Film film) {

        return filmRepository.save(film);
    }
}