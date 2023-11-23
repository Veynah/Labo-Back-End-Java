package laboratoire.spring.services;

import laboratoire.spring.models.entities.Joueur;

import java.util.List;

public interface JoueurService {
    Joueur saveJoueur(Joueur joueur);
    List<Joueur> getAllJoueurs();
    Joueur getJoueurById(Long id);
    Joueur updateJoueur(Joueur joueur, Long id);
    void deleteJoueur(Long id);
}
