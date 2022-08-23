package Projeto_2B;

public class Metodos {
	public void MenuConsulta() {
		System.out.println("---------Consulta--------");
		System.out.println("| 1.  Marcar Consulta   |");
		System.out.println("| 2.  Listar Consultas  |");
		System.out.println("| 3.     Cadastros      |");
		System.out.println("| 0.        Sair        |");
		System.out.println("-------------------------");
	}
	public void MenuCadastro(){
		System.out.println("---------Cadastro--------");
		System.out.println("| 1.     Cadastrar      |");
		System.out.println("| 2.  Consultar Dados   |");
		System.out.println("| 3.   Alterar Dados    |");
		System.out.println("| 4.  Excluir Cadastro  |");
		System.out.println("| 0.   Menu Anterior    |");
		System.out.println("-------------------------");
	}
	public void MenuPessoa() {
		System.out.println("--------------------");
		System.out.println("| 1.   Paciente    |");
		System.out.println("| 2.    Médico     |");
		System.out.println("| 0. Menu Anterior |");
		System.out.println("--------------------");
	}
	public void MenuAlterarPaciente() {
		System.out.println("-------Alterar-----");
		System.out.println("|1.      CPF      |");
		System.out.println("|2.      Nome     |");
		System.out.println("|3.    Telefone   |");
		System.out.println("|4.    Endereço   |");
		System.out.println("|0. Menu Anterior |");
		System.out.println("-------------------");
	}
	public void MenuAlterarMedico() {
		System.out.println("-------Alterar------");
		System.out.println("| 1.     CPF       |");
		System.out.println("| 2.     Nome      |");
		System.out.println("| 3.     Área      |");
		System.out.println("| 0. Menu Anterior |");
		System.out.println("--------------------");
	}
}