package Br.mesRecettes.services;

import Br.mesRecettes.entities.RecettesEntity;
import Br.mesRecettes.repositories.RecettesRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

    public RecettesEntity save(@Valid @RequestBody RecettesEntity r) {
        RecettesEntity recette = new RecettesEntity();
        recette.setTitre(r.getTitre());
        recette.setPreparation(r.getPreparation());
        recette.setImageTitre(r.getImageTitre());

        return recettesRepository.save(recette);
    }
}
