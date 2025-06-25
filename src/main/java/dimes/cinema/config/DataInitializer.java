package dimes.cinema.config; // O dove l'hai messo

import dimes.cinema.entities.Film;
import dimes.cinema.repositories.FilmRepository;
import dimes.cinema.entities.Sala;
import dimes.cinema.repositories.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private SalaRepository salaRepository;

    @Override
    public void run(String... args) throws Exception {
        // Esegui questo codice solo se la tabella dei film è vuota
        if (filmRepository.count() == 0) {
            System.out.println(">>> Database vuoto. Inserimento dei film di prova...");

            Film film1 = new Film();
            film1.setTitolo("Dune: Parte Due");
            film1.setTrama("Paul Atreides si unisce ai Fremen e intraprende un viaggio spirituale...");
            film1.setDurataMinuti(166);
            film1.setPercorsoLocandina("/images/dune_part_two.jpg");

            Film film2 = new Film();
            film2.setTitolo("Inside Out 2");
            film2.setTrama("Il film Pixar torna nella mente dell'adolescente Riley...");
            film2.setDurataMinuti(100);
            film2.setPercorsoLocandina("/images/inside_out_2.jpg");

            Film film3 = new Film();
            film3.setTitolo("Oppenheimer");
            film3.setTrama("La storia del ruolo del fisico J. Robert Oppenheimer nel Progetto Manhattan...");
            film3.setDurataMinuti(180);
            film3.setPercorsoLocandina("/images/oppenheimer.jpg");

            // Salva tutti i film in una sola operazione
            filmRepository.saveAll(List.of(film1, film2, film3));
            
            System.out.println(">>> " + filmRepository.count() + " film inseriti con successo.");
        } else {
            System.out.println(">>> Database già popolato. Nessun film di prova inserito.");
        }
        if (salaRepository.count() == 0){
            Sala sala1= new Sala();
            sala1.setNomeSala("Sala 1");
            sala1.setCapacitaTotale(100);
            salaRepository.save(sala1);
            System.out.println("Ho aggiunto Sala 1");
        }
    }
}