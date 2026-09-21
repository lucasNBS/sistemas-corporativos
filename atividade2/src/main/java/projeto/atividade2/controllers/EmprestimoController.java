package projeto.atividade2.controllers;

import projeto.atividade2.StatusEmprestimo;
import projeto.atividade2.entities.Emprestimo;
import projeto.atividade2.repositories.EmprestimoRepository;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {
  private final EmprestimoRepository emprestimoRepository;

  public EmprestimoController(EmprestimoRepository emprestimoRepository) {
    this.emprestimoRepository = emprestimoRepository;
  }

  @GetMapping("/usuario/{usuarioId}/ativos")
  public List<Emprestimo> buscarAtivos(@PathVariable Long usuarioId) {
    return emprestimoRepository.buscarEmprestimosAtivosPorUsuario(usuarioId, StatusEmprestimo.ATIVO);
  }

  @GetMapping("/atrasados")
  public List<Emprestimo> buscarAtrasados() {
    return emprestimoRepository.buscarEmprestimosAtrasados(LocalDate.now());
  }
}
