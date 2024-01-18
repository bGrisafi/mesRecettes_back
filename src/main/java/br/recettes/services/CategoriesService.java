package br.recettes.services;

import br.recettes.entities.CategoriesEntity;
import br.recettes.repositories.CategoriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

//Tout ce que je fais ici me semble bien générique, il y a un "crudService" ou autre déjà fait dont je peux venir hériter ? Voir faire la mienne si elle existe pas
public class CategoriesService {
    private final CategoriesRepository categoriesRepository;

    public List<CategoriesEntity> findAll() {
        return categoriesRepository.findAll();
    }

    //TODO refactor pour pouvoir passer les erreurs proprement au front / handler d'exception
    public ResponseEntity<CategoriesEntity> findByID(long id) {
        return categoriesRepository
                .findById(id)
                .map(entity -> ResponseEntity.ok().body(entity))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public CategoriesEntity save(CategoriesEntity categories) {
        CategoriesEntity categorie = new CategoriesEntity();
        categorie.setCategorie(categories.getCategorie());
        return categoriesRepository.save(categorie);
    }


    public CategoriesEntity update(CategoriesEntity categories, Long id) {
        categories.setId(id);
        return categoriesRepository.save(categories);
    }

    public void delete(long id) {
        categoriesRepository.deleteById(id);
    }


}
