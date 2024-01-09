package Br.mesRecettes.repositories;

import Br.mesRecettes.entities.RecettesEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecettesRepository extends ListCrudRepository<RecettesEntity, Long> {
}
