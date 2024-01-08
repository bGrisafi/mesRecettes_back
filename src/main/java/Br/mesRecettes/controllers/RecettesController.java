package Br.mesRecettes.controllers;

import Br.mesRecettes.entities.Recettes;
import Br.mesRecettes.repositories.RecettesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recettes")
@RequiredArgsConstructor
public class RecettesController
{
    private final RecettesRepository recettesRepository;

    @GetMapping("/all")
    public List<Recettes> findAllRecettes () { return (List<Recettes>) recettesRepository.findAll();}

    @GetMapping("/{id}")
    public ResponseEntity<Recettes> findRecetteByID (@PathVariable(value = "id") long id) {
        Optional<Recettes> recette = recettesRepository.findById(id);

        if(recette.isPresent()){
            return ResponseEntity.ok().body(recette.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public void addRecette (@RequestBody Recettes r){
        Recettes recette = new Recettes();
        recette.setTitre(r.getTitre());
        recette.setPreparation(r.getPreparation());
        recette.setImageTitre(r.getImageTitre());

        recettesRepository.save(recette);
    }

}
