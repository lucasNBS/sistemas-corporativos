package projeto.atividade2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import projeto.atividade2.entities.Emprestimo;
import projeto.atividade2.entities.Livro;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
public class ItemEmprestimo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JsonIgnore
  @ManyToOne
  private Emprestimo emprestimo;

  @ManyToOne
  private Livro livro;
}