package dimes.cinema.repositories;

import dimes.cinema.entities.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Integer> {
    // JpaRepository fornisce già tutti i metodi di base.
}