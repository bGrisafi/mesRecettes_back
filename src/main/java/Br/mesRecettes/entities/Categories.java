package Br.mesRecettes.entities;


import jakarta.persistence.*;


@Entity
@Table(name = "categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "categorie")
    private String categorie;

    public void setId(long id) {
        this.id = id;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public long getId() {
        return id;
    }

    public String getCategorie() {
        return categorie;
    }
}
