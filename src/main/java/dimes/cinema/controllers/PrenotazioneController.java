package dimes.cinema.controllers;

import dimes.cinema.dto.PrenotazioneRequestDTO;
import dimes.cinema.entities.Prenotazione;
import dimes.cinema.services.PrenotazioneService;
import jakarta.validation.Valid; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/prenotazioni")
@CrossOrigin(origins = "http://localhost:4200")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Prenotazione> creaPrenotazione(
            @Valid @RequestBody PrenotazioneRequestDTO request, // <-- Usa @Valid per attivare la validazione
            Authentication authentication) {
        
        // Otteniamo i dati dell'utente in modo sicuro dal token di autenticazione
        String utenteId = authentication.getName(); 
        
        // Estraiamo i dati necessari dal DTO in modo pulito e sicuro
        Long spettacoloId = request.getSpettacoloId();
        int numeroPosti = request.getNumeroPosti();
        
        // Dati fittizi per ora, da estrarre realmente dal token in un secondo momento
        String username = "username_placeholder"; 
        String email = "email_placeholder@example.com";

        Prenotazione nuovaPrenotazione = prenotazioneService.creaPrenotazione(
                utenteId,
                username,
                email,
                spettacoloId,
                numeroPosti
        );
        
        return new ResponseEntity<>(nuovaPrenotazione, HttpStatus.CREATED);
    }
}