package br.recettes.repositories;

import br.recettes.entities.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 @Repository
 public interface CategoriesRepository extends JpaRepository<CategoriesEntity, Long> {}

