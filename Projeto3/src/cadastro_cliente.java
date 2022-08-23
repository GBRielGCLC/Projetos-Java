package Cliente;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class cadastro_cliente {
	
	private String nome;
	private String email;
	private String cpf;
	private String fone;
	private String data;
	private String senha;
	private String pesquisa;
	public int posicao;
	ArrayList<String> Cadastro = new ArrayList<String>();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getPesquisa() {
		return pesquisa;
	}
	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}
	
	public int getPosicao() {
		return posicao;
	}
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	
	public void salvarDados() throws IOException {
		FileWriter arquivoFisico = new FileWriter("Clientes.txt",true);
		PrintWriter aql = new PrintWriter(arquivoFisico);

		aql.println(email);
		aql.println(senha);
		aql.println(cpf);
		aql.println(nome);
		aql.println(fone);
		aql.println(data);
		
		aql.close();
	}
	
	public void alterarDados() throws IOException {
		FileWriter arquivoFisico = new FileWriter("Clientes.txt",true);
		PrintWriter aql = new PrintWriter(arquivoFisico);
		String linha;
		FileReader aqf = new FileReader("Clientes.txt");
		BufferedReader arquivoLogico = new BufferedReader(aqf);
		linha = arquivoLogico.readLine();

		while (linha != null) {
			Cadastro.add(linha);
			linha = arquivoLogico.readLine();
		}
		for(int i=0; i < Cadastro.size(); i++ ) {
			if(Cadastro.get(i).equalsIgnoreCase(pesquisa)) {
				posicao=i;
			}
		}
		
		email = Cadastro.get(posicao);
		senha = Cadastro.get(posicao+1);
		cpf = Cadastro.get(posicao+2);
		nome = Cadastro.get(posicao+3);
		fone = Cadastro.get(posicao+4);
		data = Cadastro.get(posicao+5);
		
	}
	
	public void login() throws IOException {
		String linha;
		FileReader arquivoFisico = new FileReader("Clientes.txt");
		BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);
		linha = arquivoLogico.readLine();

		while (linha != null) {
			Cadastro.add(linha);
			linha = arquivoLogico.readLine();
		}
		for(int i=0; i < Cadastro.size(); i++ ) {
			if(Cadastro.get(i).equalsIgnoreCase(pesquisa)) {
				posicao=i;
			}
		}
		
		email = Cadastro.get(posicao);
		senha = Cadastro.get(posicao+1);
		cpf = Cadastro.get(posicao+2);
		nome = Cadastro.get(posicao+3);
		fone = Cadastro.get(posicao+4);
		data = Cadastro.get(posicao+5);
		
	}
}

