package projeto.atividade2.entities;

import projeto.atividade2.entities.Usuario;
import projeto.atividade2.entities.ItemEmprestimo;
import projeto.atividade2.StatusEmprestimo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
public class Emprestimo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JsonIgnore
  @ManyToOne
  private Usuario usuario;

  private LocalDate dataEmprestimo;

  private LocalDate dataDevolucaoPrevista;

  private LocalDate dataDevolucaoEfetiva;

  @Enumerated(EnumType.STRING)
  private StatusEmprestimo status;

  private BigDecimal valorMulta;

  @OneToMany(mappedBy = "emprestimo")
  private List<ItemEmprestimo> itens;
}


