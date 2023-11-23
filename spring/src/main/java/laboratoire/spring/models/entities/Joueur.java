package laboratoire.spring.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Joueur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String pseudo;

    @Column(unique = true)
    private String email;

    private String motDePasse;
    private Date dateDeNaissance;
    private String genre;
    private int elo;
    private String role;

    @OneToMany(mappedBy = "joueur")
    private Set<Inscription> inscriptions;
}
