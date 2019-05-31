package testesUnitarios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import aluno.Aluno;

/**
 * Classe que tem a responsabilidadende testar a classe Aluno.
 * 
 * @author jhonathan da Silva Alves; Matr�cula: 117210430
 *
 */
class TestAluno {
	private Aluno aluno;

	/**
	 * Cria um aluno do tipo Aluno que ser� usado na classeTest;
	 */
	@Before
	public void testAluno() {
		this.aluno = new Aluno("Giordano bruno", "0101", "Ci�ncia da Computa��o");
	}

	/**
	 * Testa aluno com nome null;
	 */
	@Test
	public void testAlunoNomeNull() {
		new Aluno(null, "1034", "Engenharia Qu�mica");
	}

	/**
	 * Testa aluno com matr�cula null;
	 */
	@Test
	public void testAlunoMatriculaNull() {
		new Aluno("Giordano bruno", null, "computa��o");
	}

	/**
	 * Testa aluno com curso null;
	 */
	@Test
	public void testAlunoCursoNull() {
		new Aluno("Giordano bruno", "1235", null);
	}

	/**
	 * Test aluno com nome inv�lido;
	 */
	public void testAlunoNomeVazio() {
		new Aluno(" ", "1432", "engenharia quinima");
	}

	/**
	 * Test aluno com matr�cula inv�lida;
	 */
	@Test
	public void testAlunoMatriculaVazia() {
		new Aluno("Giordano bruno", " ", "Computa��o");
	}

	/**
	 * Test equals (objetos iguais) de aluno;
	 */
	@Test
	public void testEqualsIgual() {
		Aluno aluno1 = new Aluno("Bruce wayne", "0101", "Ci�ncia da Computa��o");
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
		String result = ("Aluno: 2431 - Giordano - Ci�ncia da Computa��o");
		assertEquals(result, this.aluno.toString());
	

	}
}