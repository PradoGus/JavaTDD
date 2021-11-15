package main.java.br.com.alura.tdd.service;

import java.math.BigDecimal;

import main.java.br.com.alura.tdd.modelo.Desempenho;
import main.java.br.com.alura.tdd.modelo.Funcionario;

public class Reajuste {

	public void reajustar(Funcionario funcionario, Desempenho desempenho) {
		
		if (desempenho == null) {
			throw new NullPointerException("Deve haver um desempenho");
		} else {
			BigDecimal percentual = desempenho.percentualReajuste();
			BigDecimal ajuste = funcionario.getSalario().multiply(percentual);
			funcionario.ajustaSalario(ajuste);
		}
	}
}
