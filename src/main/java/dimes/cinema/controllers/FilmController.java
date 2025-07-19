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

@RestController           // indica che questa classe gestirà richieste REST
@RequestMapping("/api/films")           // tutte le richieste a questa classe inizieranno con /api/films
@CrossOrigin(origins = "http://localhost:4200")      // permette le chiamate dal frontend Angular
public class FilmController {

    @Autowired
    private FilmService filmService;

    

    // questo endpoint risponde a URL come /api/films/1, /api/films/2 ...
    @GetMapping("/{id}")
    public ResponseEntity<Film> trovaFilmPerId(@PathVariable Long id) {
        
        Optional<Film> filmOptional = filmService.trovaFilmPerId(id);

        
        return filmOptional
                .map(film -> ResponseEntity.ok(film)) // se il film esiste (isPresent), restituisce 200 OK con il film
                .orElse(ResponseEntity.notFound().build()); // altrimenti restituisce 404 Not Found
    }

    @GetMapping
    public ResponseEntity<List<Film>> trovaTuttiIFilm() {
        List<Film> films = filmService.trovaTuttiIFilm();
        return ResponseEntity.ok(films); // risponde con status 200 OK e la lista di film
    }


    @PostMapping
    @PreAuthorize("hasRole('ADMIN')") // solo gli admin possono accedere
    public ResponseEntity<Film> aggiungiFilm(@RequestBody Film film) {
        Film nuovoFilm = filmService.aggiungiFilm(film);
        
        // risponde con status 201 Created ed il film appena creato
        return new ResponseEntity<>(nuovoFilm, HttpStatus.CREATED);
    }
}