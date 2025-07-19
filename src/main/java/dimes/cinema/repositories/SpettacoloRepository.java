package dimes.cinema.repositories;

import dimes.cinema.entities.Spettacolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SpettacoloRepository extends JpaRepository<Spettacolo, Long> {
    
    
    List<Spettacolo> findByFilmId(Long filmId);
}