
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class estoque {

	private String nomeProduto;
	private String precoCompra;
	private String precoVenda;
	private String descricao;
	
	
	public estoque(String nomeProduto, String precoCompra, String precoVenda, String descricao, String quantidade,
			String codigo, String pesquisa, int posicao) {
		super();
		this.nomeProduto = nomeProduto;
		this.precoCompra = precoCompra;
		this.precoVenda = precoVenda;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.codigo = codigo;
		this.pesquisa = pesquisa;
		this.posicao = posicao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	private String quantidade;
	private String codigo;
	String pesquisa;
	private int posicao;
	private String nomepes;
	ArrayList<String> dados = new ArrayList<String>();

	public void pesquisar() throws IOException {

		
		String linha;
		ArrayList<String> Estoque = new ArrayList<String>();
		FileReader arquivoFisico = new FileReader("Produtos.txt");
		BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);
		linha = arquivoLogico.readLine();

		while (linha != null) {
			Estoque.add(linha);
			linha = arquivoLogico.readLine();
		}
		for(int i=0; i < Estoque.size(); i++ ) {
		if(Estoque.get(i).equalsIgnoreCase(pesquisa)) {
		posicao=i;
	}}
		nomeProduto = Estoque.get(posicao);
		precoCompra = Estoque.get(posicao+3);
		precoVenda = Estoque.get(posicao+4);
		descricao = Estoque.get(posicao+1);
		quantidade = Estoque.get(posicao+2);
		codigo = Estoque.get(posicao+5);
	}

	public estoque() {
		super();
		this.nomeProduto = nomeProduto;
		this.precoCompra = precoCompra;
		this.precoVenda = precoVenda;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.pesquisa = pesquisa;
		this.posicao = posicao;
		this.dados = dados;
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
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

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
}
