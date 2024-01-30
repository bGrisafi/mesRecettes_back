package br.recettes.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "images")
public class ImagesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "image")
    private String image;

    @ManyToOne
    @JoinColumn(name="recettes_id", insertable = false, updatable = false)
    private RecettesEntity recette;

    //TODO create custom code in postman to mimic frontend recette create/add behaviour (will result in removing recettesId and use recette to create the DB entry)
    @Column(name ="recettes_id")
    private Long recettesId;
}
