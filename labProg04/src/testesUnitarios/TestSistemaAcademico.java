package testesUnitarios;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sistemaAcademico.SistemaAcademico;

/**
 * Classe respons�vel por testar a classe SistemaAcademico
 * 
 * @author Jhonathan a Silva Alves;
 *
 */
class TestSistemaAcademico {
	private SistemaAcademico sistemaAcademico;

	/**
	 * Cria o sistema academico do tipoSistemaAcademico;
	 * 
	 * @return
	 */
	@Test
	public void testSistemaAcademico() {
		this.sistemaAcademico = new SistemaAcademico();
	}

	/**
	 * Testa (para verdadeiro) o m�todo cadastraAluno;
	 */
	@Test
	public void testCadastroAluno() {
		assertTrue(this.sistemaAcademico.cadastraAluno("Giordano Bruno", "3215", "Engenharia Agr�cola"));
	}

	/**
	 * Testa (para verdadeiro) o m�todo cadastraGrupo;
	 */
	@Test
	public void testCadastraGrupo() {
		assertTrue(this.sistemaAcademico.cadastraGrupoEstudos("Matem�tica"));
	}

	/**
	 * Testa m�todo consultaAluno; se � poss�vel verificar as informa��es de um
	 * aluno;
	 * 
	 */
	@Test
	public void testConsultaAluno() {
		String result = ("Aluno: 1234 - Aramis - Medicina");
		this.sistemaAcademico.cadastraAluno("1234", "Aramis", "Medicina");
		assertEquals(this.sistemaAcademico.consultaAluno("1234"), result);

	}

	/**
	 * Testa m�todo consultaAluno que n�o existe;
	 */
	@Test
	public void testConsulAlunoNaoExistente() {
		this.sistemaAcademico.cadastraAluno("2457", "Aramis", "Medicina");
		this.sistemaAcademico.consultaAluno("2333");

	}

	/**
	 * Testa m�todo alocaAluno para verdade;
	 * 
	 */
	@Test
	public void testAlocaAluno() {
		this.sistemaAcademico.cadastraAluno("987", "D'artagnan", "Arquiologia");
		this.sistemaAcademico.cadastraGrupoEstudos("Hist�ria da arte");
		assertEquals(this.sistemaAcademico.alocaAluno("987", "Hist�ria da arte"), "ALUNO ALOCADO");
	}

	/**
	 * Testa m�todo alocaAluno para falso;
	 */
	@Test
	public void testAlocaAlunoFalse() {
		this.sistemaAcademico.cadastraAluno("987", "D'artagnan", "Arquiologia");
		this.sistemaAcademico.cadastraGrupoEstudos("historia da arte");
		assertEquals(this.sistemaAcademico.alocaAluno("02", "hisia are"), "Aluno n�o cadastrado");
	}

	/**
	 * Testa m�todo que imprimeGruposEstudo para verdade;
	 */
	@Test
	public void testImprimirGruposEstudo() {
		String result = ("Alunos do grupo de estudo FMCC");
		this.sistemaAcademico.cadastraAluno("0202", "Porthos", "Computa��o");
		this.sistemaAcademico.cadastraGrupoEstudos("FMCC");
		this.sistemaAcademico.alocaAluno("0202", "Computa��o");
		assertEquals(this.sistemaAcademico.imprimeGrupos("FMCC"), result);
	}

	/**
	 * Testa m�todo que registra os alunos que responderam no quadro;
	 */
	@Test
	public void testcadastraAlunoRespondao() {
		this.sistemaAcademico.cadastraAluno("1234", "Atos", "Biologia");
		assertTrue(this.sistemaAcademico.cadastraAlunoRespondao("1234"));

	}

	/**
	 * Testa m�todo listaAlunosQueResponderam;
	 */
	@Test
	public void testListaAlunosQueResponderam() {
		this.sistemaAcademico.cadastraAluno("0101", "Aramis", "Computa��o");
		this.sistemaAcademico.cadastraAluno("2020", "Atos", "Engenharia Mecanica");
		this.sistemaAcademico.cadastraAluno("0303", "Portos", "Engenharia Quimica");

		this.sistemaAcademico.cadastraAlunoRespondao("0101");
		this.sistemaAcademico.cadastraAlunoRespondao("2020");
		this.sistemaAcademico.cadastraAlunoRespondao("0303");

		String toString = "Alunos:" + System.lineSeparator() + "1. 0101 - Aramis - Computa��o"
				+ "2. 2020 - Atos - Engenharia Mecanica" + "3. 03030 - Portos - Engenharia Quimica";
		assertEquals(toString, this.sistemaAcademico.listaAlunosQueResponderam());
	}

}
