package sistemaAcademico;

import java.util.ArrayList;
import java.util.HashMap;

import aluno.Aluno;
import grupoEstudo.GrupoEstudo;

/**
 * Classe respons�vel por gerenciar os alunos e os grupos;
 * 
 * @author jhonathan da Silva Alves; Laborat�rio 4 programa��o; 
 * Matricula: 117210430;
 *
 */

public class SistemaAcademico {
	/**
	 * Atributos da classe SistemaAcademico;
	 */
	private HashMap<String, Aluno> alunos;
	private HashMap<String, GrupoEstudo> gruposEstudo;
	private ArrayList<Aluno> alunosQueResponderam;
	
	/**
	 * Construtor da classe SistemaAcademico;
	 */
	public SistemaAcademico() {
		this.alunos = new HashMap<>();
		this.gruposEstudo = new HashMap<>();
		this.alunosQueResponderam = new ArrayList<>();
	}

	/**
	 * M�todo booleano que cadastra um aluno no sistema;
	 * @param Matricula do aluno;
	 * @param nome do aluno;
	 * @param curso do aluno;
	 * 
	 */
	public boolean cadastraAluno(String matricula, String nomeAluno, String curso ) {
		if(this.alunos.containsKey(matricula))
			throw new IllegalArgumentException("A matricula j� existe no sistema");
		Aluno aluno = new Aluno(matricula, nomeAluno, curso);
		this.alunos.put(matricula, aluno);
		return true;
	}
	
	/**
	 * M�todo que verifica se um aluno existe no sistema;
	 * @param matricula do aluno;
	 */
	public String consultaAluno(String matricula) {
		if(this.alunos.containsKey(matricula)) {
			return "Aluno: " + this.alunos.get(matricula).toString();
		}else {
			return ("O aluno n�o foi cadastrado");
		}
	}
	
	/**
	 * M�todo booleano que cadastra um grupo de estudos no sistema;
	 * @param tema do grupo de estudos;
	 */
	public boolean cadastraGrupoEstudos(String nomeGrupo) {
		if(this.gruposEstudo.containsKey(nomeGrupo))
			throw new IllegalArgumentException("O grupo de estudos j� existe no sistema");
		GrupoEstudo grupo = new GrupoEstudo(nomeGrupo);
		this.gruposEstudo.put(nomeGrupo.toLowerCase(), grupo);
		return true;
		
	}
	
	/**
	 * M�todo que aloca alunos em grupos (no sistema); 
	 *
	 */
	public String alocaAluno(String matricula, String nomeGrupo) {
		if(!this.alunos.containsKey(matricula)) {
			return "O aluno n�o foi cadastrado";
		}
		if(!this.gruposEstudo.containsKey(nomeGrupo)) {
			return "O grupo n�o foi cadastrado";
		}
		if(this.gruposEstudo.get(nomeGrupo.toLowerCase()).adicionaAlunos(this.alunos.get(matricula))) {
			return "ALUNO ALOCADO";
		}else {
			return "O ALUNO FOI ALOCADO NO GRUPO DE ESTUDOS"; 
		}
	
	}
	/**
	 * M�todo que imprime grupos de estudo;
	 * @param tema do grupo;
	 * @return a representa��o textual de um grupo grupo;
	 */
	public String imprimeGrupos(String nomeGrupo) {
		if(this.gruposEstudo.containsKey(nomeGrupo.toLowerCase())) {
			return this.gruposEstudo.get(nomeGrupo.toLowerCase()).toString();
		}
		return "O grupo n�o foi cadastrado";
	}

	/**
	 * M�todo que cadastra aluno (no sistema) que respondeu no quandro;
	 * @param matricula do aluno;
	 */
	public boolean cadastraAlunoRespondao(String matricula) {
		if(!this.alunos.containsKey(matricula)) 
			throw  new IllegalArgumentException("O aluno n�o foi cadastrado");
			return this.alunosQueResponderam.add(this.alunos.get(matricula));
				
		}
	/**
	 * M�todo que imprime alunos que responderam no quadro;
	 * @return A representa��o textual de todos os alunos que responderam no quadro;
	 */
	public String listaAlunosQueResponderam() {
		String result = "Alunos:" + System.lineSeparator();
		
		if(!(alunosQueResponderam.isEmpty())) {
			int pos = 0;
			for (Aluno aluno : this.alunosQueResponderam){
				result += (pos++) + ". " + aluno.toString(); 
				
			}
		}else {
			result += "Quantidade de alunos que responderam est� vazia";
			
		}
		return result;
	}
	
}
	
		