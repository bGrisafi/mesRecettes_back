package Br.mesRecettes.controllers;

import Br.mesRecettes.entities.CategoriesEntity;
import Br.mesRecettes.services.CategoriesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoriesController {

    private final CategoriesService categoriesService;

    @GetMapping
    public List<CategoriesEntity> findAllCategories() {
        return categoriesService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoriesEntity> findCategoryByID(@PathVariable long id) {
        return categoriesService.findByID(id);
    }

    @PostMapping
    public CategoriesEntity saveCategorie(@Valid @RequestBody CategoriesEntity categorie) {
        return categoriesService.save(categorie);
    }
}
