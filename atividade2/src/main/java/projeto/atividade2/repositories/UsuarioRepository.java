package projeto.atividade2.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import projeto.atividade2.entities.Usuario;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
  List<Usuario> findByNomeContaining(@Param("nome") String nome);
}
