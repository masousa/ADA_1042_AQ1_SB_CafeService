package tech.ada.bootcamp.arquitetura.cafeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.ada.bootcamp.arquitetura.cafeservice.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}
