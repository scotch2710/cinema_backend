package dimes.cinema.controllers;

import dimes.cinema.entities.Film;
import dimes.cinema.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import java.util.List;

@RestController // Indica che questa classe gestirà richieste REST
@RequestMapping("/api/films") // Tutte le richieste a questa classe inizieranno con /api/films
@CrossOrigin(origins = "http://localhost:4200") // Permette le chiamate dal frontend Angular
public class FilmController {

    @Autowired
    private FilmService filmService;

    // Dentro la classe FilmController

    // Questo endpoint risponde a URL come /api/films/1, /api/films/2, ecc.
    @GetMapping("/{id}")
    public ResponseEntity<Film> trovaFilmPerId(@PathVariable Long id) {
        // Chiama il service per trovare il film
        Optional<Film> filmOptional = filmService.trovaFilmPerId(id);

        // Usa un modo funzionale per gestire la risposta
        return filmOptional
                .map(film -> ResponseEntity.ok(film)) // Se il film esiste (isPresent), restituisce 200 OK con il film
                .orElse(ResponseEntity.notFound().build()); // Altrimenti, restituisce 404 Not Found
    }
    // --- ENDPOINT PUBBLICO: Ottenere tutti i film ---
    // Questo servirà per la tua home page
    @GetMapping
    public ResponseEntity<List<Film>> trovaTuttiIFilm() {
        List<Film> films = filmService.trovaTuttiIFilm();
        return ResponseEntity.ok(films); // Risponde con status 200 OK e la lista di film
    }

    // --- ENDPOINT PROTETTO: Aggiungere un nuovo film ---
    // Questo servirà per il pannello di amministrazione
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')") // Solo gli utenti con ruolo ADMIN possono accedere
    public ResponseEntity<Film> aggiungiFilm(@RequestBody Film film) {
        Film nuovoFilm = filmService.aggiungiFilm(film);
        // Risponde con status 201 Created e il film appena creato
        return new ResponseEntity<>(nuovoFilm, HttpStatus.CREATED);
    }
}