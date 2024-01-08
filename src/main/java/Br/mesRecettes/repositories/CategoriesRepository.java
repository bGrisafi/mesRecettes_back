package Br.mesRecettes.repositories;

import Br.mesRecettes.entities.Categories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
 @Repository
 public interface CategoriesRepository extends CrudRepository<Categories, Long> {}

