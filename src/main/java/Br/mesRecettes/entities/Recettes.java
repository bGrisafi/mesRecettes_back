package Br.mesRecettes.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "recettes")
public class Recettes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column (name = "titre")
    private String titre;

    @Column(name = "preparation")
    private String preparation;

    @Column(name = "imageTitre")
    private String imageTitre;
}
