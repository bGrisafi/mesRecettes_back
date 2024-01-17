package Br.mesRecettes.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @ManyToMany(mappedBy = "categories")
    @JsonIgnoreProperties("categories")
    private List<RecettesEntity> recettes;


}
