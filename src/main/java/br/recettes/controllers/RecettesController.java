package br.recettes.controllers;

import br.recettes.entities.RecettesEntity;
import br.recettes.services.RecettesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recettes")
@RequiredArgsConstructor
public class RecettesController {

    private final RecettesService recettesService;

    @GetMapping
    public List<RecettesEntity> findAllRecettes() {
        return recettesService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<RecettesEntity> findRecetteByID(@PathVariable Long id) {
        return recettesService.findByID(id);
    }

    @PostMapping
    public RecettesEntity addRecette(@Valid @RequestBody RecettesEntity recette) {
        return recettesService.save(recette);
    }

    @PostMapping("{id}")
    public RecettesEntity updateRecette(@Valid @RequestBody RecettesEntity recette, @PathVariable Long id) {
        return recettesService.update(recette, id);
    }

    @DeleteMapping("{id}")
    public void deleteRecette(@PathVariable Long id) {
        recettesService.delete(id);
    }
}
