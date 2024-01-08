package Br.mesRecettes.repositories;

import Br.mesRecettes.entities.Recettes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecettesRepository extends CrudRepository<Recettes, Long> {
}
