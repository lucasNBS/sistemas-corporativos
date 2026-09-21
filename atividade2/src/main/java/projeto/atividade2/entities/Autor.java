package projeto.atividade2.entities;

import projeto.atividade2.entities.Livro;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
public class Autor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String nome;

  private LocalDate dataNascimento;

  private String nacionalidade;

  @Lob
  @Column(columnDefinition = "TEXT")
  private String biografia;

  @JsonIgnore
  @ManyToMany(mappedBy = "autores")
  private List<Livro> livros;
}

