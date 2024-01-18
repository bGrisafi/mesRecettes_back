package br.recettes.controllers;

import br.recettes.entities.CategoriesEntity;
import br.recettes.services.CategoriesService;
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
    public ResponseEntity<CategoriesEntity> findCategoryByID(@PathVariable Long id) {
        return categoriesService.findByID(id);
    }

    @PostMapping
    public CategoriesEntity saveCategorie(@Valid @RequestBody CategoriesEntity categories) {
        return categoriesService.save(categories);
    }

    @PutMapping("{id}")
    public CategoriesEntity updateCategorie(@Valid @RequestBody CategoriesEntity categories, @PathVariable Long id){
        return categoriesService.update(categories, id);
    }

    @DeleteMapping("{id}")
    public void deleteCategorie(@PathVariable long id){
        categoriesService.delete(id);
    }
}
