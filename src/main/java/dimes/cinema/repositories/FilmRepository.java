package dimes.cinema.repositories;

import dimes.cinema.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    // JpaRepository ci fornisce già tutti i metodi base come findAll(), findById(), save(), delete()
    // Per ora non serve aggiungere altro!
}