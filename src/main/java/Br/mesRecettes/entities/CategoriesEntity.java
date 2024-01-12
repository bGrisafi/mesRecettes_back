package Br.mesRecettes.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "categories")
public class CategoriesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "categorie")
    private String categorie;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "recettes_has_categories",
        joinColumns = @JoinColumn(name="categories_id",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="recettes_id", referencedColumnName = "id"))
    private List<RecettesEntity> recettes;


}
