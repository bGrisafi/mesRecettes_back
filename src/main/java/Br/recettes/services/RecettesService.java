package br.recettes.services;

import br.recettes.entities.RecettesEntity;
import br.recettes.repositories.RecettesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecettesService {

    private final RecettesRepository recettesRepository;

    public List<RecettesEntity> findAll(){
        return recettesRepository.findAll();
    }

    public ResponseEntity<RecettesEntity> findByID(long id) {
        Optional<RecettesEntity> recette = recettesRepository.findById(id);
        if (recette.isPresent()) return ResponseEntity.ok().body(recette.get());
        else {
            return ResponseEntity.notFound().build();
        }
    }

    public RecettesEntity save(RecettesEntity recette) {
        return recettesRepository.save(recette);
    }

    //TODO modifier l'update pour le rendre plus efficient (DTO et Mapper pour éviter d'update tous les champs)
    public RecettesEntity update(RecettesEntity recette){
        return recettesRepository.save(recette);
    }

    public void delete(Long id){
        recettesRepository.deleteById(id);
    }
}
