package laboratoire.spring.services.impl;

import laboratoire.spring.exceptions.UniqueJoueurException;
import laboratoire.spring.models.entities.Joueur;
import laboratoire.spring.repositories.JoueurRepository;
import laboratoire.spring.services.JoueurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoueurServiceImpl implements JoueurService {

    private final JoueurRepository joueurRepository;

    @Autowired
    public JoueurServiceImpl(JoueurRepository joueurRepository) {
        this.joueurRepository = joueurRepository;
    }

    @Override
    public Joueur saveJoueur(Joueur joueur){
        if(joueurRepository.existByPseudo(joueur.getPseudo()) || joueurRepository.existByEmail(joueur.getEmail())){
            throw new UniqueJoueurException();
        }
        return joueurRepository.save(joueur);
    }

    @Override
    public List<Joueur> getAllJoueurs() {
        return joueurRepository.findAll();
    }

    @Override
    public Joueur getJoueurById(Long id) {
        return joueurRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Joueur updateJoueur(Joueur joueur, Long id) {
        if(joueurRepository.existByPseudo(joueur.getPseudo()) || joueurRepository.existByEmail((joueur.getEmail()))){
            throw new UniqueJoueurException();
        }
        Joueur existingJoueur = getJoueurById(id);
        existingJoueur.setPseudo(joueur.getPseudo());
        existingJoueur.setEmail(joueur.getEmail());
        existingJoueur.setMotDePasse(joueur.getMotDePasse());
        existingJoueur.setDateDeNaissance(joueur.getDateDeNaissance());
        existingJoueur.setGenre(joueur.getGenre());
        existingJoueur.setElo(joueur.getElo());
        existingJoueur.setRole(joueur.getRole());
        return joueurRepository.save(existingJoueur);
    }

    @Override
    public void deleteJoueur(Long id) {
        joueurRepository.deleteById(id);
    }

}
