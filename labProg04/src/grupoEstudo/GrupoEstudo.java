package grupoEstudo;

import java.util.HashSet;

import aluno.Aluno;

/**
 * Classe responsável pelos dados que compõe um grupo de alunos;
 * 
 * @author jhonathan da Silva Alves; Laboratório 4 programação; 
 * Matricula:  117210430;
 *
 */

public class GrupoEstudo {

	/**
	 * Atributos da classe Grupo;
	 */
	private String nomeGrupo; // descrição de um grupo de estudos;
	private HashSet<Aluno> alunos; // conjunto de alunos, que não pode ter elemnetos repetidos;

	public GrupoEstudo(String nomeGrupo) {
		/**
		 * exceções do atributo da classe Grupo;
		 */
		if (nomeGrupo == null) {
			throw new NullPointerException("Nome do grupo não pode ser null");
		}
		if (nomeGrupo.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome do grupo inválido");
		}

		this.nomeGrupo = nomeGrupo;
		this.alunos = new HashSet<Aluno>();
	}

	/**
	 * Método booleano que adiciona um aluno no grupo de estudos;
	 */

	public boolean adicionaAlunos(Aluno aluno) {
		return this.alunos.add(aluno);
	}

	public String getNomeGrupo() {
		return nomeGrupo;
	}

	@Override
	public String toString() {
		String result = "Alunos do grupo" + this.nomeGrupo + ":" + System.lineSeparator();
		for (Aluno aluno : alunos) {
			result += "* " + aluno.toString() + System.lineSeparator();
		}

		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeGrupo == null) ? 0 : nomeGrupo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrupoEstudo other = (GrupoEstudo) obj;
		if (nomeGrupo == null) {
			if (other.nomeGrupo != null)
				return false;
		} else if (!nomeGrupo.equals(other.nomeGrupo))
			return false;
		return true;
	}

}
