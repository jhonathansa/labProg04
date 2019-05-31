package testesUnitarios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import aluno.Aluno;

/**
 * Classe que tem a responsabilidadende testar a classe Aluno.
 * 
 * @author jhonathan da Silva Alves; Matrícula: 117210430
 *
 */
class TestAluno {
	private Aluno aluno;

	/**
	 * Cria um aluno do tipo Aluno que será usado na classeTest;
	 */
	@Before
	public void testAluno() {
		this.aluno = new Aluno("Giordano bruno", "0101", "Ciência da Computação");
	}

	/**
	 * Testa aluno com nome null;
	 */
	@Test
	public void testAlunoNomeNull() {
		new Aluno(null, "1034", "Engenharia Química");
	}

	/**
	 * Testa aluno com matrícula null;
	 */
	@Test
	public void testAlunoMatriculaNull() {
		new Aluno("Giordano bruno", null, "computação");
	}

	/**
	 * Testa aluno com curso null;
	 */
	@Test
	public void testAlunoCursoNull() {
		new Aluno("Giordano bruno", "1235", null);
	}

	/**
	 * Test aluno com nome inválido;
	 */
	public void testAlunoNomeVazio() {
		new Aluno(" ", "1432", "engenharia quinima");
	}

	/**
	 * Test aluno com matrícula inválida;
	 */
	@Test
	public void testAlunoMatriculaVazia() {
		new Aluno("Giordano bruno", " ", "Computação");
	}

	/**
	 * Test equals (objetos iguais) de aluno;
	 */
	@Test
	public void testEqualsIgual() {
		Aluno aluno1 = new Aluno("Bruce wayne", "0101", "Ciência da Computação");
		assertTrue(this.aluno.equals(aluno1));
	}

	/**
	 * Test equals (objetos diferentes) de aluno;
	 */
	@Test
	public void testEqualsDiferente() {
		Aluno aluno1 = new Aluno("Bruce wanyne", "1029", "Engenharia Quimica");
		assertFalse(this.aluno.equals(aluno1));
	}
	
	/**
	 * Test toString de aluno;
	 */
	@Test
	public void testToString() {
		String result = ("Aluno: 2431 - Giordano - Ciência da Computação");
		assertEquals(result, this.aluno.toString());
	

	}
}