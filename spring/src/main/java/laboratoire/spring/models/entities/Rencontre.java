package laboratoire.spring.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Rencontre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tournoi_id")
    private Tournoi tournoi;

    @ManyToOne
    @JoinColumn(name = "joueur_blanc_id")
    private Joueur joueurBlanc;

    @ManyToOne
    @JoinColumn(name = "joueur_noir_id")
    private Joueur joueurNoir;

    private int numeroRonde;
    private String resultat;
}
