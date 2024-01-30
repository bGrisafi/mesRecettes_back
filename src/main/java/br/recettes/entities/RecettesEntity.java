package br.recettes.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private Long id;

    @Column(name = "titre")
    private String titre;

    @Column(name = "preparation")
    private String preparation;

    @Column(name = "imageTitre")
    private String imageTitre;

    @OneToMany(mappedBy = "recette")
    private List<ImagesEntity> images;

    @ManyToMany
    @JoinTable(name = "recettes_has_categories",
            joinColumns = @JoinColumn(name = "recettes_id"),
            inverseJoinColumns = @JoinColumn(name = "categories_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"recettes_id", "categories_id"}))
    @JsonIgnoreProperties("recettes")
    private List<CategoriesEntity> categories;


}
