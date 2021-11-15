package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;

import main.java.br.com.alura.tdd.modelo.Desempenho;
import main.java.br.com.alura.tdd.modelo.Funcionario;
import main.java.br.com.alura.tdd.service.Reajuste;

public class ReajusteTest {
	
	@Test	// anota��o para indicar o JUnit que este m�todo deve ser testado
	public void reajusteDeveSerTresPorCentoSalario() { //nome do m�todo teste deve indicar o que o m�todo real deve fazer
		Reajuste reajuste = new Reajuste();			//crio a classe que tem o m�todo de reajuste
		Funcionario funcionario = new Funcionario("Gustavo", LocalDate.now(), new BigDecimal("1000.00"));  //crio um funcion�rio com data de admissao e salario
		reajuste.reajustar(funcionario, Desempenho.A_DESEJAR);	//chamo o m�todo reajuste, passando um funcion�rio e um desempenho anual
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario()); //indico o JUnit qual valor deve ser esperado ap�s o m�todo e a compara��o
	}
	
	@Test
	public void reajusteDeveSerQuinzePorCentoSalario() {
		Reajuste reajuste = new Reajuste();
		Funcionario funcionario = new Funcionario("Gustavo", LocalDate.now(), new BigDecimal("1000.00"));
		reajuste.reajustar(funcionario, Desempenho.BOM);
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteDeveSerVintePorCentoSalario() {
		Reajuste reajuste = new Reajuste();
		Funcionario funcionario = new Funcionario("Gustavo", LocalDate.now(), new BigDecimal("1000.00"));
		reajuste.reajustar(funcionario, Desempenho.OTIMO);
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteDeveLancarExceptionPoisDesempenhoEhNull() {
		Reajuste reajuste = new Reajuste();
		Funcionario funcionario = new Funcionario("Gustavo", LocalDate.now(), new BigDecimal("1000.00"));
		try {
			reajuste.reajustar(funcionario, null);
			fail();
		} catch (Exception e) {
			assertEquals("Deve haver um desempenho", e.getMessage());
		}
	}
	
}











