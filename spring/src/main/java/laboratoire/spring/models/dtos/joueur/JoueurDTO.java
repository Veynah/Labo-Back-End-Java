package laboratoire.spring.models.dtos.joueur;

import lombok.Data;

import java.util.Date;

@Data
public class JoueurDTO {

    private Long id;
    private String pseudo;
    private String email;
    private Date dateDeNaissance;
    private String genre;
    private int elo;
}
