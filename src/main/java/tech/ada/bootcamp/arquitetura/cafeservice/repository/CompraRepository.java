package tech.ada.bootcamp.arquitetura.cafeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.ada.bootcamp.arquitetura.cafeservice.model.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {
}