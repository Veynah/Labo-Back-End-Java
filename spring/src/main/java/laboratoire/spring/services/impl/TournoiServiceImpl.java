package laboratoire.spring.services.impl;

import laboratoire.spring.models.entities.Tournoi;
import laboratoire.spring.repositories.TournoiRepository;
import laboratoire.spring.services.TournoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournoiServiceImpl implements TournoiService {
    private final TournoiRepository tournoiRepository;

    @Autowired
    public TournoiServiceImpl(TournoiRepository tournoiRepository) {
        this.tournoiRepository = tournoiRepository;
    }

    @Override
    public Tournoi saveTournoi(Tournoi tournoi) {
        return tournoiRepository.save(tournoi);
    }

    @Override
    public List<Tournoi> getAllTournois() {
        return tournoiRepository.findAll();
    }

    @Override
    public Tournoi getTournoiById(Long id){
        return tournoiRepository.findById(id).orElse(null);
    }

    @Override
    public Tournoi updateTournoi(Tournoi tournoi, Long id) {
        Tournoi existingTournoi = tournoiRepository.findById(id).orElse(null);
        if (existingTournoi != null) {

            existingTournoi.setNom(tournoi.getNom());
            existingTournoi.setLieu(tournoi.getLieu());
            existingTournoi.setNombreMinJoueurs(tournoi.getNombreMinJoueurs());
            existingTournoi.setNombreMaxJoueurs(tournoi.getNombreMaxJoueurs());
            existingTournoi.setEloMinimum(tournoi.getEloMinimum());
            existingTournoi.setEloMaximum(tournoi.getEloMaximum());
            existingTournoi.setCategorie(tournoi.getCategorie());
            existingTournoi.setStatut(tournoi.getStatut());
            existingTournoi.setRondeCourante(tournoi.getRondeCourante());
            existingTournoi.setWomenOnly(tournoi.isWomenOnly());
            existingTournoi.setDateFinInscription(tournoi.getDateFinInscription());
            existingTournoi.setDateCreation(tournoi.getDateCreation());
            existingTournoi.setDateMiseAJour(tournoi.getDateMiseAJour());
            return tournoiRepository.save(existingTournoi);
        }
        return null;
    }

    @Override
    public void deleteTournoi(Long id) {
        tournoiRepository.deleteById(id);
    }

}