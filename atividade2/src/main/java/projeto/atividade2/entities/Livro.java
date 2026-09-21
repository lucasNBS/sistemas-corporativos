package projeto.atividade2.entities;

import projeto.atividade2.entities.Autor;
import projeto.atividade2.entities.Categoria;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
public class Livro {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String isbn;

  @Column(nullable = false)
  private String titulo;

  private String editora;

  private Integer anoPublicacao;

  private Integer numeroPaginas;

  private Integer quantidadeTotal;

  private Integer quantidadeDisponivel;

  @ManyToOne
  private Categoria categoria;

  @ManyToMany
  @JoinTable(name = "livro_autor", joinColumns = @JoinColumn(name = "livro_id"), inverseJoinColumns = @JoinColumn(name = "autor_id"))
  private List<Autor> autores;
}