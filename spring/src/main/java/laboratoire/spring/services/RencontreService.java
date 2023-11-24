package laboratoire.spring.services;

import laboratoire.spring.models.entities.Rencontre;

import java.util.List;

public interface RencontreService {
    Rencontre saveRencotre(Rencontre rencontre);
    List<Rencontre> getAllRencontres();
    Rencontre getRencontreById(Long id);
    Rencontre updateRencontre(Rencontre rencontre, Long id);
    void deleteRencontre(Long id);
}
