package Br.mesRecettes.services;

import Br.mesRecettes.entities.CategoriesEntity;
import Br.mesRecettes.repositories.CategoriesRepository;
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

    public CategoriesEntity save(CategoriesEntity c) {
        CategoriesEntity categorie = new CategoriesEntity();
        categorie.setCategorie(c.getCategorie());
        return categoriesRepository.save(categorie);
    }

    public CategoriesEntity update(CategoriesEntity c) {
        return categoriesRepository.save(c);
    }

    public void delete(long id){
        categoriesRepository.deleteById(id);
    }


}
