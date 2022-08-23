package Projeto_2B;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
static ArrayList <String> cpfPaciente = new ArrayList <String>(); 
static ArrayList <String> nomePaciente = new ArrayList <String>(); 
static ArrayList <String> fone = new ArrayList <String>(); 
static ArrayList <String> endere�o = new ArrayList <String>(); 

static ArrayList <String> cpfMedico = new ArrayList <String>();
static ArrayList <String> area = new ArrayList <String>();
static ArrayList <String> nomeMedico = new ArrayList <String>();
	
static String procurador; 
static Scanner line = new Scanner(System.in);
static int pos=0,paciente=0,medico=0;
static boolean achou = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pessoa p = new Pessoa();
		Metodos m = new Metodos();
		
		Scanner l = new Scanner(System.in);
		
		ArrayList <String> mensagem = new ArrayList <String>();
		String hora, data;
		int opCons,op,opAl,opP,msg=0;
		int opPac,opMed;
		boolean find = false;int posCons=0;
		
		m.MenuConsulta();opCons = l.nextInt();
		
		while(opCons<0 || opCons>3) {
			 System.out.println("Digite SOMENTE alguma das op��es abaixo:\n");
			 m.MenuConsulta();opCons = l.nextInt();
		}
		while(opCons!=0) {
			if(opCons==1) {
				if(paciente==0 || medico==0) {
					System.out.println("N�o h� pacientes/m�dicos cadastrados!! Cadastre algum. ");
					opCons=3;
				}
				else {
					System.out.printf("\n%10s %18s","CPF","Nome\n");
					for(int list=0;list<paciente;list++) {
						System.out.printf("%d. %-12s | %s\n",(list+1),cpfPaciente.get(list),nomePaciente.get(list));
					}
					System.out.print("\nPaciente que ir� se consultar(Digite o n�mero): ");
					opPac = l.nextInt();
					System.out.print("Data da consulta (dd/mm/aaaa): ");data = line.nextLine();
					System.out.print("Hora da consulta (hh:mm):");hora = line.nextLine();
					System.out.printf("\n%10s %18s","CPF","Nome\n");
					for(int list=0;list<medico;list++) {
						System.out.printf("%d. %-12s | %s\n",(list+1),cpfMedico.get(list),nomeMedico.get(list));
					}
					System.out.print("\nM�dico que ir� consultar o paciente:(Digite o n�mero): ");
					opMed = l.nextInt();
					mensagem.add("Nome: "+nomePaciente.get((opPac-1))+"\nCPF: "+cpfPaciente.get((opPac-1))+"\n"+hora+" "+data+" Dr�/� "+nomeMedico.get((opMed-1)));
					msg++;
				}
			}
			if(opCons==2) {
				if(msg==0) {
					System.out.println("N�o h� consultas marcadas!!\n");
				}
				else {
					for(int proc=0; proc<mensagem.size(); proc++) {
						System.out.println(mensagem.get(proc)+"\n");
					}
				}
			}
			if(opCons==3) {
				m.MenuCadastro();op = l.nextInt();
				while(op<0 || op>4){
					
					m.MenuCadastro();op = l.nextInt();
				}
				while(op!=0) {
					if(op==1) {
						m.MenuPessoa();opP = l.nextInt();
						while(opP<0 || opP>2) {
							System.out.println("Digite SOMENTE alguma das op��es abaixo:\n");
							m.MenuPessoa();opP = l.nextInt();
						}
						while(opP!=0){
							if(opP==1) {
								System.out.println("--------Cadastro--------");
								System.out.printf("CPF %6s ",":");
								p.setCpfPaciente(line.nextLine());cpfPaciente.add(p.getCpfPaciente());
								System.out.printf("Nome %5s ",":");
								p.setNomePaciente(line.nextLine());nomePaciente.add(p.getNomePaciente());
								System.out.printf("Telefone %1s ",":");
								p.setFone(line.nextLine());fone.add(p.getFone());
								System.out.printf("Endere�o %1s ",":");
								p.setEndere�o(line.nextLine());endere�o.add(p.getEndere�o());
								System.out.println();paciente++;
							}
							if(opP==2) {
								System.out.println("--------Cadastro--------");
								System.out.printf("CPF %13s ",":");
								p.setCpfMedico(line.nextLine());cpfMedico.add(p.getCpfMedico());
								System.out.printf("Nome %12s ",":");
								p.setNomeMedico(line.nextLine());nomeMedico.add(p.getNomeMedico());
								System.out.printf("Area de atua��o %1s ",":");
								p.setArea(line.nextLine());area.add(p.getArea());
								System.out.println();medico++;
							}
							m.MenuPessoa();opP = l.nextInt();
						}
					}
					if(op==2) {
						m.MenuPessoa();opP = l.nextInt();
						while(opP<0 || opP>2) {
							System.out.println("Digite SOMENTE alguma das op��es abaixo:\n");
							m.MenuPessoa();opP = l.nextInt();
						}
						while(opP!=0) {
							if(opP==1) {
								ProcuradorPaciente();
							}
							if(opP==2) {
								ProcuradorMedico();
							}
							m.MenuPessoa();opP = l.nextInt();
						}
					}
					if(op==3) {
						m.MenuPessoa();opP = l.nextInt();
						while(opP<0 || opP>2) {
							System.out.println("Digite SOMENTE alguma das op��es abaixo:\n");
							m.MenuPessoa();opP = l.nextInt();
						}
						while(opP!=0) {
							if(opP==1) {
								ProcuradorPaciente();
								if(achou==true){
									System.out.println("Qual dado ser� alterado?:");
									m.MenuAlterarPaciente();opAl = l.nextInt();
									if(opAl==1) {
										System.out.println("Digite o novo CPF");
										cpfPaciente.add(pos, line.next());
									}
									if(opAl==2) {
										System.out.println("Digite o novo nomePaciente");
										nomePaciente.add(pos, line.nextLine());
									}
									if(opAl==3) {
										System.out.println("Digite o novo telefone");
										fone.add(pos, line.nextLine());
									}
									if(opAl==4) {
										System.out.println("Digite o novo endere�o");
										endere�o.add(pos, line.nextLine());
									}
								}
							}
							if(opP==2) {
								ProcuradorMedico();
								if(achou=true) {
									System.out.println("Qual dado ser� alterado?:");
									m.MenuAlterarMedico();opAl = l.nextInt();
									if(opAl==1) {
										System.out.println("Digite o novo CPF");
										cpfMedico.add(pos, line.next());
									}
									if(opAl==2) {
										System.out.println("Digite o novo nomePaciente");
										nomeMedico.add(pos, line.nextLine());
									}
									if(opAl==3) {
										System.out.println("Digite a nova �rea");
										area.add(pos, line.nextLine());
									}
									if(opAl==0){
										
									}
								}
								else {
									
								}
							}
							m.MenuPessoa();opP = l.nextInt();
						}
					}
					if(op==4) {
						m.MenuPessoa();opP = l.nextInt();
						while(opP<0 || opP>2) {
							System.out.println("Digite SOMENTE alguma das op��es abaixo:\n");
							m.MenuPessoa();opP = l.nextInt();
						}
						while(opP!=0) {
							if(opP==1) {
								ProcuradorPaciente();
								if(achou==true){
									System.out.println("Deseja mesmo escluir?(s/n): ");
									String sn = l.next();
									if(sn.equalsIgnoreCase("s") || sn.equalsIgnoreCase("sim")) {
										cpfPaciente.remove(pos);
										nomePaciente.remove(pos);
										fone.remove(pos);
										endere�o.remove(pos);
										System.out.println("Cadastro exclu�do com sucesso!!");
										paciente--;
									}
									else {
										System.out.println("Opera��o cancelada");
									}
								}
							}
							if(opP==2) {
								ProcuradorMedico();
								if(achou==true){
									System.out.println("Deseja mesmo escluir?(s/n): ");
									String sn = l.next();
									if(sn.equalsIgnoreCase("s") || sn.equalsIgnoreCase("sim")) {
										cpfMedico.remove(pos);
										nomeMedico.remove(pos);
										area.remove(pos);
										System.out.println("Cadastro exclu�do com sucesso!!");
										medico--;
									}
									else {
										System.out.println("Opera��o cancelada");
									}
								}
								else {
									
								}
							}
							m.MenuPessoa();opP = l.nextInt();
						}
					}
					achou = false;find=false;
					pos=0;
					m.MenuCadastro();
					op = l.nextInt();
					while(op<0 || op>4){
						System.out.println("Digite SOMENTE alguma das op��es abaixo:\n");
						m.MenuCadastro();op = l.nextInt();
					}
				}
			}
			m.MenuConsulta();opCons = l.nextInt();
		}
	}
	public static void ProcuradorPaciente() {
		if(paciente==0) {
			System.out.println("N�o h� cadastros");
		}
		else {
			System.out.print("Informe o CPF: ");
			procurador = line.nextLine();
			for(int i=0;i<paciente;i++){
				if(cpfPaciente.get(i).contains(procurador)){
					achou = true;
					pos = i;
				}
			}
			if(achou==true){
				System.out.println("\n------Dados do Cliente------");
				System.out.printf("CPF %6s %s \n",":",cpfPaciente.get(pos));
				System.out.printf("Nome %5s %s \n",":",nomePaciente.get(pos));
				System.out.printf("Telefone %1s %s \n",":",fone.get(pos));
				System.out.printf("Endere�o %1s %s \n",":",endere�o.get(pos));
				System.out.println("----------------------------\n");
			}
			else {
				System.out.println("Cadastro n�o encontrado");
			}
		}
	}
	public static void ProcuradorMedico() {
		if(medico==0) {
			System.out.println("N�o h� cadastros");
		}
		else {
			System.out.print("Informe o CPF: ");
			procurador = line.nextLine();
			for(int r=0;r<medico;r++){
				if(cpfMedico.get(r).contains(procurador)){
					achou = true;
					pos = r;
				}
			}
			if(achou==true){
				System.out.println("\n------Dados do Medico------");
				System.out.printf("CPF %13s %s \n",":",cpfMedico.get(pos));
				System.out.printf("Nome %12s %s \n",":",nomeMedico.get(pos));
				System.out.printf("Area de atua��o %1s %s \n",":",area.get(pos));
				System.out.println("---------------------------");
			}
			else {
				System.out.println("Cadastro n�o encontrado");
			}
		}
	}
}