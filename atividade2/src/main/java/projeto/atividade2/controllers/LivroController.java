package projeto.atividade2.controllers;

import projeto.atividade2.entities.Livro;
import projeto.atividade2.repositories.LivroRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    private final LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {
      this.livroRepository = livroRepository;
    }

    @GetMapping("/disponiveis/{quantidade}")
    public List<Livro> buscarDisponiveis(@PathVariable String quantidade) {
        return livroRepository.findByQuantidadeDisponivelGreaterThanOrderByTituloAsc(Integer.parseInt(quantidade));
    }

    @GetMapping("/categoria/{nome}")
    public List<Livro> buscarPorCategoria(@PathVariable String nome) {
      return livroRepository.findByCategoriaNome(nome);
    }

    @GetMapping("/autor/{nome}")
    public List<Livro> buscarPorAutor(@PathVariable String nome) {
      return livroRepository.buscarPorAutor(nome);
    }

    @GetMapping("/quantidade-por-categoria")
    public List<Object[]> quantidadePorCategoria() {
      return livroRepository.contarLivrosPorCategoria();
    }
}
