package laboratoire.spring.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "joueur_id")
    private Joueur joueur;

    @ManyToOne
    @JoinColumn(name = "tournoi_id")
    private Tournoi tournoi;

    private int nombreVictoires;
    private int nombreDefaites;
    private int nombreEgalites;
    private double points;
}
