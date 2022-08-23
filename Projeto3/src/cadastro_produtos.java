package Cliente;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class cadastro_produtos {

	
	private String nomeProduto;
	private String precoCompra;
	private String precoVenda;
	private String descricao;
	private String quantidade;
	
	private int cd;
	
	public String getQuantidade() {
		return quantidade;
	}



	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	private String codigo;
	
	

	public String getCodigo() {
		return codigo;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public void salvarDados() throws IOException {

		FileWriter arquivoFisico = new FileWriter("Produtos.txt", true);
		PrintWriter aql = new PrintWriter(arquivoFisico);
		
	
		aql.println(nomeProduto);
		aql.println(descricao);
		aql.println(quantidade);
		aql.println(precoCompra);
		aql.println(precoVenda);
		aql.printf("%07d",cd = Integer.parseInt(codigo));
		aql.println();
		
		aql.close();
		arquivoFisico.close();
		
			}
		
		
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getPrecoCompra() {
		return precoCompra;
	}
	public void setPrecoCompra(String precoCompra) {
		this.precoCompra = precoCompra;
	}
	public String getPrecoVenda() {
		return precoVenda;
	}
	public void setPrecoVenda(String precoVenda) {
		this.precoVenda = precoVenda;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}