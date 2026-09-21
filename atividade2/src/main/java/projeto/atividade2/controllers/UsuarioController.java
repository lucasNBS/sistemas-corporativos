package projeto.atividade2.controllers;

import projeto.atividade2.entities.Usuario;
import projeto.atividade2.repositories.UsuarioRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
  private final UsuarioRepository usuarioRepository;

  public UsuarioController(UsuarioRepository usuarioRepository) {
    this.usuarioRepository = usuarioRepository;
  }

  @GetMapping("/nome/{nome}")
  public List<Usuario> buscarPorNome(@PathVariable String nome) {
    return usuarioRepository.findByNomeContaining(nome);
  }
}
