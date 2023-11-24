package laboratoire.spring.repositories;

import laboratoire.spring.models.entities.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
    List<Score> findByJoueurId(Long joueurId);
    List<Score> findByTournoiId(Long tournoiId);


}
