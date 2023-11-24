package laboratoire.spring.repositories;

import laboratoire.spring.models.entities.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Long> {

    Optional<Inscription> findByJoueurIdAndTournoiId(Long joueurId, Long tournoiId);
    List<Inscription> findByTournoiId(Long tournoiId);
}
