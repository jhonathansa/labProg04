package aluno;

/**
 * Classe responsável pelos dados que compõe um aluno;
 * 
 * @author jhonathan da Silva Alves; Laboratório 4 programação;
 * Matricula: 117210430;
 *
 */

public class Aluno {

	/**
	 * Atributos da Classe Aluno;
	 */
	private String matricula;
	private String nomeAluno;
	private String curso;

	public Aluno(String nomeAluno, String matricula, String curso) {
		/**
		 * exceções dos atributos da Classse Aluno;
		 */
		if (nomeAluno == null) {
			throw new NullPointerException("Nome inválido");
		}
		if (nomeAluno.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome inválido");
		}
		if (matricula == null) {
			throw new NullPointerException("Matrícula inválida");
		}
		if (matricula.trim().isEmpty()) {
			throw new IllegalArgumentException("Matrícula inválida");
		}
		if (curso == null) {
			throw new NullPointerException("Curso inválido");
		}
		if (curso.trim().isEmpty()) {
			throw new IllegalArgumentException("Curso inválido");

		}
		this.matricula = matricula;
		this.nomeAluno = nomeAluno;
		this.curso = curso;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aluno: 	" + this.matricula + "-" + this.nomeAluno + "-" + this.curso;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public String getCurso() {
		return curso;
	}

}