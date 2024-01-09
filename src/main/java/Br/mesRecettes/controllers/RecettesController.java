package Br.mesRecettes.controllers;

import Br.mesRecettes.entities.RecettesEntity;
import Br.mesRecettes.services.RecettesService;
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
    public ResponseEntity<RecettesEntity> findRecetteByID(@PathVariable long id) {
        return recettesService.findByID(id);
    }

    @PostMapping
    public RecettesEntity addRecette(@Valid @RequestBody RecettesEntity r) {
        return recettesService.save(r);
    }

}
