package dimes.cinema.controllers;

import dimes.cinema.entities.Spettacolo;
import dimes.cinema.services.SpettacoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/spettacoli")
@CrossOrigin(origins = "http://localhost:4200")
public class SpettacoloController {

    @Autowired
    private SpettacoloService spettacoloService;

    // --- ENDPOINT PUBBLICO: Ottenere gli spettacoli per un dato film ---
    // Esempio di chiamata dal frontend: /api/spettacoli?filmId=1
    @GetMapping
    public ResponseEntity<List<Spettacolo>> trovaSpettacoliPerFilm(@RequestParam Long filmId) {
        List<Spettacolo> spettacoli = spettacoloService.trovaSpettacoliPerFilm(filmId);
        return ResponseEntity.ok(spettacoli);
    }
}