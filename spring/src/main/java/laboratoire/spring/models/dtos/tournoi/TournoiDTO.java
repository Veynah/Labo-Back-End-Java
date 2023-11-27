package laboratoire.spring.models.dtos.tournoi;

import lombok.Data;

import java.util.List;

@Data
public class TournoiDTO {
    private Long id;
    private String nom;
    private String lieu;
    private int nombreMinJoueurs;
    private int nombreMaxJoueurs;
    private Integer ELOMin; // Nullable
    private Integer ELOMax; // Nullable
    private List<String> categories;
    private String statut;
}
