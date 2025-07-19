package dimes.cinema.services;

import dimes.cinema.entities.Prenotazione; 
import dimes.cinema.entities.Spettacolo;   
import dimes.cinema.entities.Utente;       
import dimes.cinema.repositories.PrenotazioneRepository; 
import dimes.cinema.repositories.SpettacoloRepository;   
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class PrenotazioneService {

    @Autowired
    private SpettacoloRepository spettacoloRepository;
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;
    
    
    @Autowired
    private UtenteService utenteService; 

    @Transactional
    public Prenotazione creaPrenotazione(String utenteId, String username, String email, Long spettacoloId, int numeroPosti) {
        
        
        Utente utente = utenteService.trovaOcreaUtente(utenteId, username, email);   //ottiene o crea l'utente

        
        Spettacolo spettacolo = spettacoloRepository.findById(spettacoloId)                   // trova lo spettacolo e verifica se ci sono posti 
                .orElseThrow(() -> new RuntimeException("Spettacolo non trovato con id: " + spettacoloId));

        if (spettacolo.getPostiDisponibili() < numeroPosti) {
            throw new RuntimeException("Posti non sufficienti per lo spettacolo: " + spettacolo.getFilm().getTitolo());
        }

        
        spettacolo.setPostiDisponibili(spettacolo.getPostiDisponibili() - numeroPosti);
        spettacoloRepository.save(spettacolo);

        Prenotazione nuovaPrenotazione = new Prenotazione();
        nuovaPrenotazione.setUtente(utente);
        nuovaPrenotazione.setSpettacolo(spettacolo);
        nuovaPrenotazione.setNumeroBiglietti(numeroPosti);
        nuovaPrenotazione.setDataPrenotazione(LocalDateTime.now());
        nuovaPrenotazione.setPrezzoPagato(spettacolo.getPrezzoBiglietto().multiply(new BigDecimal(numeroPosti)));
        

        return prenotazioneRepository.save(nuovaPrenotazione);
    }
}