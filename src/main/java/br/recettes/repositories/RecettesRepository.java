package br.recettes.repositories;

import br.recettes.entities.RecettesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecettesRepository extends JpaRepository<RecettesEntity, Long> {
}
