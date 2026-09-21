package projeto.atividade2.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projeto.atividade2.entities.Livro;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
  List<Livro> findByQuantidadeDisponivelGreaterThanOrderByTituloAsc(@Param("quantidade") Integer quantidade);

  List<Livro> findByCategoriaNome(@Param("nome") String nome);

  @Query("""
    SELECT l
    FROM Livro l
    JOIN l.autores a
    WHERE a.nome = :nome
    ORDER BY l.anoPublicacao ASC
  """)
  List<Livro> buscarPorAutor(@Param("nome") String nome);

  @Query("""
    SELECT l.categoria.nome, COUNT(l)
    FROM Livro l
    GROUP BY l.categoria.nome
    ORDER BY COUNT(l) DESC
  """)
  List<Object[]> contarLivrosPorCategoria();
}
