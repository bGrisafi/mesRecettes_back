package Br.mesRecettes.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "recettes")
public class RecettesEntity {
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

    @ManyToMany(mappedBy = "recettes")
    private List<CategoriesEntity> categories;
}
