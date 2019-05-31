package menu;

import java.util.Scanner;

import sistemaAcademico.SistemaAcademico;

/**
 * Classe Menu responsável pela gerencia das opções no sistema academico;
 * 
 * @author Jhonathan da Silva Alves;
 *
 */
public class Menu {
	private static SistemaAcademico sistemaAcademico = new SistemaAcademico();

	private static Scanner sc = new Scanner(System.in);

	/**
	 * Todas as opções que o Menu possue;
	 * 
	 * (C)adastrar Aluno;
	 * (E)xibir Aluno; 
	 * (N)ovo Grupo; 
	 * (A)locar Aluno no Grupo ou Imprimir Grupos; 
	 * (R)egistrar Aluno que Respondeu; 
	 * (I)mprimir Alunos que Responderam; 
	 * (O)ra, vamos fechar o programa!
	 */

	public static void main(String[] args) {
		exibeMenu();
		String opcao = sc.nextLine();

		while (!opcao.equals("O")) {
			switch (opcao) {
			case "C":
				cadastraAluno();
				break;

			case "E":
				System.out.print("Matricula: ");
				;
				String matricula = sc.nextLine();
				System.out.println(sistemaAcademico.consultaAluno(matricula));
				break;

			case "N":
				cadastraGrupoEstudos();
				break;

			case "A":
				alocarImprimirGrupo();
				break;

			case "R":
				System.out.print("Matricula: ");
				matricula = sc.nextLine();
				System.out.print(sistemaAcademico.cadastraAlunoRespondao(matricula));
				break;

			case "I":
				System.out.print(sistemaAcademico.listaAlunosQueResponderam());
				break;

			default:
				System.out.println("A opição é inválida");
				break;
			}
			exibeMenu();
			opcao = sc.nextLine();

		}

	}

	/**
	 * Função estatica que exibe o menu com as suas opções;
	 */
	private static void exibeMenu() {
		System.out.println("(C)adastra um aluno.");
		System.out.println("(E)xibir um aluno.");
		System.out.println("(N)ovo grupo.");
		System.out.println("(A)loca um aluno em um grupo e imprimir grupos.");
		System.out.println("(R)egistra aluno que respondeu.");
		System.out.println("(I)mprimir alunos que responderam.");
		System.out.println("(O)ra, vamos fechar o programa!");
		System.out.println("Opcao> ");

	}

	/**
	 * Função responsável por cadastrar um aluno no sistema;
	 */
	private static void cadastraAluno() {
		try {
			System.out.print("Matriula: ");
			String matricula = sc.nextLine().trim();
			System.out.print("Nome: ");
			String nomeAluno = sc.nextLine().trim();
			System.out.print("Curso: ");
			String curso = sc.nextLine().trim();

			if (Menu.sistemaAcademico.cadastraAluno(nomeAluno, matricula, curso)) {
				System.out.println("CADASTRO REALIZADO!");
			} else {
				System.out.println("MATRICULA JÁ CADASTRADA NO SISTEMA!");
			}
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());

		}

	}

	/**
	 * Função responsável por cadastar um grupo de estudos no sistema;
	 */
	private static void cadastraGrupoEstudos() {
		try {
			System.out.print("Grupo: ");
			String nomeGrupo = sc.nextLine().trim();

			if (Menu.sistemaAcademico.cadastraGrupoEstudos(nomeGrupo))
				System.out.println("CADASTRO REALIZADO!");

		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());

		}
	}

	/**
	 * Função responsável por imprimir grupos ou alocar alunos;
	 */
	private static void alocarImprimirGrupo() {
		System.out.print("(A)locar aluno ou (I)mprimir grupo ?");
		String opcaoLocal = sc.nextLine();
		
		if(opcaoLocal.equals("I")){
			System.out.print("Grupo: ");
			String nomeGrupo = sc.nextLine().trim();
			System.out.println(sistemaAcademico.imprimeGrupos(nomeGrupo));
		} 
		if(opcaoLocal.equals("A")) {
			System.out.print("Matricula: ");
			String matricula = sc.nextLine().trim();
			System.out.print("Grupo: ");
			String nomeGrupo = sc.nextLine().trim();

			System.out.println(sistemaAcademico.alocaAluno(matricula, nomeGrupo.toLowerCase()));
		}
	}

	/**
	 * Função responsável por registar alunos que responderam no quadro;
	 */
	@SuppressWarnings("unused")
	private void cadastraAlunoRespondao() {
		try {
			System.out.print("Matrícula: ");
			String matricula = sc.nextLine().trim();

			if (Menu.sistemaAcademico.cadastraAlunoRespondao(matricula)) {
				System.out.println("ALUNO REGISTRADO!");
			}
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
		}
	}

	/**
	 * Função responsável por listar alunos que responderam no quadro;
	 */
	@SuppressWarnings("unused")
	private void listaAlunosQueResponderam() {
		System.out.println(Menu.sistemaAcademico.listaAlunosQueResponderam());
	}

}
