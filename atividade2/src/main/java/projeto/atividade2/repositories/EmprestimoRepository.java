package projeto.atividade2.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projeto.atividade2.entities.Emprestimo;
import projeto.atividade2.StatusEmprestimo;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
  @Query("""
    SELECT DISTINCT e
    FROM Emprestimo e
    JOIN FETCH e.itens i
    JOIN FETCH i.livro
    WHERE e.usuario.id = :usuarioId
    AND e.status = :status
  """)
  List<Emprestimo> buscarEmprestimosAtivosPorUsuario(@Param("usuarioId") Long usuarioId, @Param("status") StatusEmprestimo status);

  @Query("""
    SELECT DISTINCT e
    FROM Emprestimo e
    JOIN FETCH e.usuario u
    JOIN FETCH e.itens i
    JOIN FETCH i.livro l
    WHERE e.dataDevolucaoPrevista < :dataAtual
    AND e.status = projeto.atividade2.StatusEmprestimo.ATIVO
  """)
  List<Emprestimo> buscarEmprestimosAtrasados(@Param("dataAtual") LocalDate dataAtual);
}
