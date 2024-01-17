package Br.mesRecettes.services;

import Br.mesRecettes.entities.RecettesEntity;
import Br.mesRecettes.repositories.RecettesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecettesService {
    private final RecettesRepository recettesRepository;

    public List<RecettesEntity> findAll() {
        return recettesRepository.findAll();
    }

    public ResponseEntity<RecettesEntity> findByID(long id) {
        Optional<RecettesEntity> recette = recettesRepository.findById(id);
        if (recette.isPresent()) return ResponseEntity.ok().body(recette.get());
        else {
            return ResponseEntity.notFound().build();
        }
    }


    public RecettesEntity save(RecettesEntity r) {
        RecettesEntity recette = new RecettesEntity();
        recette.setTitre(r.getTitre());
        recette.setPreparation(r.getPreparation());
        recette.setImageTitre(r.getImageTitre());


        return recettesRepository.save(recette);
    }

    //TODO modifier l'update pour le rendre plus efficient (DTO et Mapper pour éviter d'update tous les champs)

    public RecettesEntity update(RecettesEntity r) {
        return recettesRepository.save(r);
    }

    public void delete(long id) {
        recettesRepository.deleteById(id);
    }
}
