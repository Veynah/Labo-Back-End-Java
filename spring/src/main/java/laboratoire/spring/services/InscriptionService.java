package laboratoire.spring.services;

import laboratoire.spring.models.entities.Inscription;
import laboratoire.spring.models.entities.Joueur;

import java.util.List;

public interface InscriptionService {

    Inscription saveInscription(Inscription inscription);
    List<Inscription> getAllInscription();
    Inscription getInscriptionById(Long id);
    void deleteInscription(Long id);
    List<Joueur> getJoueursInscritsAuTournoi(Long tournoiId);
}
