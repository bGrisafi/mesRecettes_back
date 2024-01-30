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
    @JoinColumn(name="recette_id", nullable = false)
    private RecettesEntity recette;
}
