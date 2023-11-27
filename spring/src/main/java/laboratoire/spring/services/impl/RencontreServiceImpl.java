package laboratoire.spring.services.impl;

import laboratoire.spring.models.entities.Joueur;
import laboratoire.spring.models.entities.Rencontre;
import laboratoire.spring.models.entities.Tournoi;
import laboratoire.spring.repositories.RencontreRepository;
import laboratoire.spring.services.InscriptionService;
import laboratoire.spring.services.RencontreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class RencontreServiceImpl implements RencontreService {

    private final RencontreRepository rencontreRepository;
    private final InscriptionService inscriptionService;

    @Autowired
    public RencontreServiceImpl(RencontreRepository rencontreRepository, InscriptionService inscriptionService) {
        this.rencontreRepository = rencontreRepository;
        this.inscriptionService = inscriptionService;
    }

    @Override
    public Rencontre saveRencontre(Rencontre rencontre) {

        assignerJoueurs(rencontre);
        return rencontreRepository.save(rencontre);
    }

    private void assignerJoueurs(Rencontre rencontre) {
        List<Joueur> joueursInscrits = InscriptionService.getJoueursInscritsAuTournoi(rencontre.getTournoi().getId());

        if (joueursInscrits.size() >=2) {
            Random random = new Random();
            int indexJoueurBlanc = random.nextInt(joueursInscrits.size());
            Joueur joueurBlanc = joueursInscrits.get(indexJoueurBlanc);

            Joueur joueurNoir;
            do {
                int indexJoueurNoir = random.nextInt(joueursInscrits.size());
                joueurNoir = joueursInscrits.get(indexJoueurNoir);

            } while (joueurNoir.equals(joueurBlanc));

            rencontre.setJoueurBlanc(joueurBlanc);
            rencontre.setJoueurNoir(joueurNoir);
        } else {
            throw new IllegalStateException("Pas assez de joueurs pour une rencontre");
        }
    }

    @Override
    public List<Rencontre> getAllRencontres() {return rencontreRepository.findAll();}

    @Override
    public Rencontre getRencontreById(Long id) {
        return  rencontreRepository.findById(id).orElse(null);
    }

    @Override
    public Rencontre updateRencontre(Rencontre rencontre, Long id) {
        Rencontre existingRencontre = rencontreRepository.findById(id).orElse(null);
        if (existingRencontre != null) {

            existingRencontre.setNumeroRonde(rencontre.getNumeroRonde());
            existingRencontre.setResultat(rencontre.getResultat());
            return rencontreRepository.save(existingRencontre);
        }
        return null;

    }

    @Override
    public void deleteRencontre(Long id) {
        rencontreRepository.deleteById(id);
    }
}
