package laboratoire.spring.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Tournoi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String lieu;
    private int nombreMinJoueurs;
    private int nombreMaxJoueurs;
    private Integer eloMinimum;
    private Integer eloMaximum;
    private String categorie;
    private String statut;
    private int rondeCourante;
    private boolean womenOnly;
    private Date dateFinInscription;
    private Date dateCreation;
    private Date dateMiseAJour;

    @OneToMany(mappedBy = "tournoi")
    private Set<Inscription> inscriptions;

    @OneToMany(mappedBy = "tournoi")
    private Set<Rencontre> rencontres;
}
