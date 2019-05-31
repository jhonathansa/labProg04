package testesUnitarios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import aluno.Aluno;
import grupoEstudo.GrupoEstudo;
/**
 * Classe que tem a responsabilidadende testar a classe GrupoEstudo;
 * 
 * @author jhonathan da Silva Alves; Matrícula: 117210430;
 *
 */
class TestGrupo {
	private GrupoEstudo grupo;
	
	/**
	 * Cria um grupo do tipo GrupoEstudo
	 */
	@Test
	public void testGrupoEstudo() {
		this.grupo = new GrupoEstudo("Exatas");
	}
	/**
	 * Testa grupo de estudo com nome vazio;
	 */
	@Test
	public void testGrupoEstudoNomeVazio() {
		new GrupoEstudo("");
	}
	/**
	 * Testa grupo de estudos com nome null;
	 */
	@Test
	public void testGrupoEstudoNomeNull() {
		new GrupoEstudo(null);
	}
	/**
	 * Testa grupos de estudo nome igual;
	 */
	@Test
	public void testEqualsIgual() {
		GrupoEstudo grupo1 = new GrupoEstudo("exatas");
		assertTrue(this.grupo.equals(grupo1));
	}
	/**
	 * Testa grupos de estudo nome diferente;
	 */
	@Test
	public void testGrupoEstudoDiferente() {
		GrupoEstudo grupo1 = new GrupoEstudo("Humanas");
		assertFalse(this.grupo.equals(grupo1));
	}
	/**
	 * Testa metodo adicionaAlunos;
	 */
	@Test
	public void testAdicionaAluno() {
		Aluno aluno1 = new Aluno("Giordano bruno", "0101", "Ciência da Computação");
		this.grupo.adicionaAlunos(aluno1);
		String toString = "Alunos do grupo Exatas: " + System.lineSeparator() + "* " + aluno1.toString() + System.lineSeparator();
		assertEquals(this.grupo.toString(), toString);
	}
	/**
	 * Testa o toString da classe GrupoEstudo;
	 */
	@Test
	public void testToString() {
		Aluno aluno1 = new Aluno("Giordano bruno", "0101", "Ciência da Computação");
		this.grupo.adicionaAlunos(aluno1);
		String result = ("Alunos do grupo Exatas- Aluno: 1029 - Giordano Bruno - computação");
		assertEquals(this.grupo.toString(), result);
	}
	

}
