package projeto.atividade2.entities;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
public class Usuario {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  @Column(nullable = false, unique = true)
  private String cpf;

  @Column(nullable = false, unique = true)
  private String email;

  private String telefone;

  private LocalDate dataCadastro;

  private String endereco;

  private Boolean ativo;
}
