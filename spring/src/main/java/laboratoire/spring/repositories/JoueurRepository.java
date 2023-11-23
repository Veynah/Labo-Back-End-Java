package laboratoire.spring.repositories;

import laboratoire.spring.models.entities.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur, Long> {

    @Query("select count(b) > 0 from Joueur b where b.pseudo like :pseudo")
    boolean existByPseudo(String pseudo);

    @Query("select count(t) > 0 from Joueur t where t.email like :email")
    boolean existByEmail(String email);

}
