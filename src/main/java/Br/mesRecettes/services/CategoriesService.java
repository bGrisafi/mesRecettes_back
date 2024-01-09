package Br.mesRecettes.services;

import Br.mesRecettes.entities.CategoriesEntity;
import Br.mesRecettes.repositories.CategoriesRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

//Tout ce que je fais ici me semble bien générique, il y a un "crudService" ou autre déjà fait dont je peux venir hériter ? Voir faire la mienne si elle existe pas
public class CategoriesService {
    private final CategoriesRepository categoriesRepository;
    public List<CategoriesEntity> findAll(){
        return categoriesRepository.findAll();
    }

    //TODO refactor pour pouvoir passer les erreurs proprement au front
    public ResponseEntity<CategoriesEntity> findByID(long id) {
        Optional<CategoriesEntity> categorie = categoriesRepository.findById(id);
        if (categorie.isPresent()) return ResponseEntity.ok().body(categorie.get());
        else {
            return ResponseEntity.notFound().build();
        }
    }

    public CategoriesEntity save(@Valid @RequestBody CategoriesEntity categorie) {
        return categoriesRepository.save(categorie);
    }
}