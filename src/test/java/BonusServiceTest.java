package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import main.java.br.com.alura.tdd.modelo.Funcionario;
import main.java.br.com.alura.tdd.service.BonusService;

class BonusServiceTest {

	@Test
	void bonusDeveSerZeroParaFuncionarioSalarioMuitoAlto() {
		LocalDate dataAdmissao = LocalDate.of(2021, 04, 15);
		BonusService service = new BonusService();
		
		assertThrows(IllegalArgumentException.class, 
				() -> service.calcularBonus(new Funcionario("Gustavo", dataAdmissao, new BigDecimal("20000"))));
				
	}

	@Test
	void bonusDeveSerDezPorCentoDoSalario() {
		LocalDate dataAdmissao = LocalDate.of(2021, 04, 15);
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Gustavo", dataAdmissao, new BigDecimal("2500")));
		
		assertEquals(new BigDecimal("250.00"), bonus);
		
	}
	
	@Test
	void bonusDeveSerDezPorCentoDoSalarioParaFuncionarioSalarioDezMilExato() {
		LocalDate dataAdmissao = LocalDate.of(2021, 04, 15);
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Gustavo", dataAdmissao, new BigDecimal("10000")));
		
		assertEquals(new BigDecimal("1000.00"), bonus);
		
	}
	
}
