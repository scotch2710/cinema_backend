package dimes.cinema.controllers;

import dimes.cinema.dto.SpettacoloRequestDTO;
import dimes.cinema.entities.Spettacolo;
import dimes.cinema.services.SpettacoloService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/spettacoli")
@CrossOrigin(origins = "http://localhost:4200")
public class SpettacoloController {

    @Autowired
    private SpettacoloService spettacoloService;

    // ottenere gli spettacoli per un dato film 
    
    @GetMapping
    public ResponseEntity<List<Spettacolo>> trovaSpettacoliPerFilm(@RequestParam Long filmId) {
        List<Spettacolo> spettacoli = spettacoloService.trovaSpettacoliPerFilm(filmId);
        return ResponseEntity.ok(spettacoli);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')") // solo gli admin possono aggiungere spettacoli
    public ResponseEntity<Spettacolo> creaSpettacolo(@Valid @RequestBody SpettacoloRequestDTO requestDTO) {
        Spettacolo nuovoSpettacolo = spettacoloService.creaSpettacolo(requestDTO);
        return new ResponseEntity<>(nuovoSpettacolo, HttpStatus.CREATED);
    }

}