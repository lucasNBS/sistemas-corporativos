package projeto.atividade1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/calculadora")
public class Calculator {
  @GetMapping("/somar/{numero1}/{numero2}")
  public int sum(@PathVariable int numero1, @PathVariable int numero2) {
    return numero1 + numero2;
  }

  @GetMapping("/subtrair")
  public int subtract(@RequestParam int numero1, @RequestParam int numero2) {
    return numero1 - numero2;
  }

  @GetMapping("/par-ou-impar/{numero}")
  public String isEven(@PathVariable int numero) {
    return numero % 2 == 0 ? "PAR" : "ÍMPAR";
  }

  @GetMapping("/analisar/{numero}")
  public String analysis(@PathVariable int numero) {
    return """
      Número: %d
      Par ou ímpar: %s
      Positivo, negativo ou zero: %s
      Dobro: %d
      Metade: %d
      Quadrado: %d
    """.formatted(
      numero,
      numero % 2 == 0 ? "PAR" : "ÍMPAR",
      numero > 0 ? "POSITIVO" : (numero < 0 ? "NEGATIVO" : "ZERO"),
      numero * 2,
      numero / 2,
      numero * numero
    );
  }

  @GetMapping("/media")
  public String average(@RequestParam int numero1, @RequestParam int numero2, @RequestParam int numero3) {
    double average = (numero1 + numero2 + numero3) / 3.0;
    String situation = average >= 7 ? "APROVADO" : (average > 4 ? "RECUPERAÇÃO" : "REPROVADO");
    return """
      Média: %.2f
      Situação: %s
    """.formatted(average, situation);
  }

  @GetMapping("/calcular/{operacao}")
  public String average(
    @PathVariable String operacao,
    @RequestParam int numero1,
    @RequestParam int numero2,
    @RequestParam(defaultValue = "2") int casasDecimais
  ) {
    double resultado = 0;

    switch (operacao) {
      case "soma" -> {
        resultado = numero1 + numero2;
      }
      case "subtracao" -> {
        resultado = numero1 - numero2;
      }
      case "multiplicacao" -> {
        resultado = numero1 * numero2;
      }
      case "divisao" -> {
        if (numero2 == 0) {
          return "Erro: Divisão por zero não é permitida.";
        }
        resultado = numero1 / (double) numero2;
      }
      default -> {
        return "Erro: Operação inválida.";
      }
    }

    String formato = "%." + casasDecimais + "f";

    return """
      Operação: %s
      Número 1: %d
      Número 2: %d
      Resultado: %s
    """.formatted(operacao, numero1, numero2, String.format(formato, resultado));
  }
}