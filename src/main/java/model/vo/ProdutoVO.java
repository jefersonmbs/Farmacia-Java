package model.vo;

public class ProdutoVO {
	
	private int idProduto;
	private String nome;
	private double preco;
	private int estoqueAtual;
	private int estoqueMinimo;
	public ProdutoVO(int idProduto, String nome, double preco, int estoqueAtual, int estoqueMinimo) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
		this.preco = preco;
		this.estoqueAtual = estoqueAtual;
		this.estoqueMinimo = estoqueMinimo;
	}
	public ProdutoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getEstoqueAtual() {
		return estoqueAtual;
	}
	public void setEstoqueAtual(int estoqueAtual) {
		this.estoqueAtual = estoqueAtual;
	}
	public int getEstoqueMinimo() {
		return estoqueMinimo;
	}
	public void setEstoqueMinimo(int estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}
	
	
	
}