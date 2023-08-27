package tech.ada.bootcamp.arquitetura.cafeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.ada.bootcamp.arquitetura.cafeservice.model.Combo;

@Repository
public interface ComboRepository extends JpaRepository<Combo, Long> {
    boolean existsByDescricao(String descricao);
}