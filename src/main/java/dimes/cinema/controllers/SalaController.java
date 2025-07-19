package dimes.cinema.controllers;

import dimes.cinema.entities.Sala;
import dimes.cinema.repositories.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sale")
@CrossOrigin(origins = "http://localhost:4200") 
public class SalaController {

    @Autowired
    private SalaRepository salaRepository;

    /**
     * @return Una lista di tutte le sale.
     */
    @GetMapping
    public ResponseEntity<List<Sala>> getAllSale() {
        List<Sala> sale = salaRepository.findAll();
        return ResponseEntity.ok(sale);
    }
}