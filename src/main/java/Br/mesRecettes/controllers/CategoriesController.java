package Br.mesRecettes.controllers;

import Br.mesRecettes.entities.Categories;
import Br.mesRecettes.repositories.CategoriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoriesController {

    private final CategoriesRepository categoriesRepository;

    @GetMapping("/all")
    public List<Categories> findAllCategories() {
        return (List<Categories>) categoriesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categories> findCategpryByID(@PathVariable(value = "id") long id) {
        Optional<Categories> categorie = categoriesRepository.findById(id);
        if(categorie.isPresent()) return ResponseEntity.ok().body(categorie.get());
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Categories saveCategorie(@Validated @RequestBody Categories categorie) {
        return categoriesRepository.save(categorie);
    }
}
