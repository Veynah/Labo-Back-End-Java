package laboratoire.spring.repositories;

import laboratoire.spring.models.entities.Rencontre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RencontreRepository extends JpaRepository<Rencontre, Long> {


}
