package laboratoire.spring.services.impl;

import laboratoire.spring.models.entities.Inscription;
import laboratoire.spring.models.entities.Joueur;
import laboratoire.spring.repositories.InscriptionRepository;
import laboratoire.spring.services.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InscriptionServiceImpl implements InscriptionService {

    private final InscriptionRepository inscriptionRepository;

    @Autowired
    public InscriptionServiceImpl(InscriptionRepository inscriptionRepository) {
        this.inscriptionRepository = inscriptionRepository;
    }

    @Override
    public Inscription saveInscription(Inscription inscription) {

        Optional<Inscription> existingInscription = inscriptionRepository.findByJoueurIdAndTournoiId(inscription.getJoueur().getId(), inscription.getTournoi().getId());

        if (existingInscription.isPresent()) {
            throw new IllegalStateException("le joueur est déjà inscrit à ce tournoi");
        }
        return inscriptionRepository.save(inscription);
    }

    @Override
    public List<Inscription> getAllInscription() {
        return inscriptionRepository.findAll();
    }

    @Override
    public Inscription getInscriptionById(Long id) {
        return inscriptionRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteInscription(Long id){
        inscriptionRepository.deleteById(id);
    }

    @Override
    public List<Joueur> getJoueursInscritsAuTournoi(Long tournoiId){
        List<Inscription> inscriptions = inscriptionRepository.findByTournoiId(tournoiId);
        return inscriptions.stream().map(Inscription::getJoueur).collect(Collectors.toList());
    }
}
