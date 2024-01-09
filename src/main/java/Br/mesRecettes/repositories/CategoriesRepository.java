package Br.mesRecettes.repositories;

import Br.mesRecettes.entities.CategoriesEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
 @Repository
 public interface CategoriesRepository extends ListCrudRepository<CategoriesEntity, Long> {}

