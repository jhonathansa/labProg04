package aluno;

/**
 * Classe respons�vel pelos dados que comp�e um aluno;
 * 
 * @author jhonathan da Silva Alves; Laborat�rio 4 programa��o;
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
		 * exce��es dos atributos da Classse Aluno;
		 */
		if (nomeAluno == null) {
			throw new NullPointerException("Nome inv�lido");
		}
		if (nomeAluno.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome inv�lido");
		}
		if (matricula == null) {
			throw new NullPointerException("Matr�cula inv�lida");
		}
		if (matricula.trim().isEmpty()) {
			throw new IllegalArgumentException("Matr�cula inv�lida");
		}
		if (curso == null) {
			throw new NullPointerException("Curso inv�lido");
		}
		if (curso.trim().isEmpty()) {
			throw new IllegalArgumentException("Curso inv�lido");

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