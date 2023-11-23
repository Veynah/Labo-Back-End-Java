package laboratoire.spring.services;

import laboratoire.spring.models.entities.Tournoi;

import java.util.List;

public interface TournoiService {

    Tournoi saveTournoi(Tournoi tournoi);
    List<Tournoi> getAllTournois();
    Tournoi getTournoiById(Long id);
    Tournoi updateTournoi(Tournoi tournoi, Long id);
    void deleteTournoi(Long id);
}
