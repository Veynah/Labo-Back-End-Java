package laboratoire.spring.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "joueur_id")
    private Joueur joueur;

    @ManyToOne
    @JoinColumn(name = "tournoi_id")
    private Tournoi tournoi;

    private Date dateInscription;
}
