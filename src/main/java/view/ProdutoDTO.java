package view;

public class ProdutoDTO {

    private int idProduto;
    private String nome;
    private double preco;
    private int estoqueAtual;
    private int estoqueMinimo;


    public ProdutoDTO(int idProduto, String nome, double preco, int estoqueAtual, int estoqueMinimo) {
        super();
        this.idProduto = idProduto;
        this.nome = nome;
        this.preco = preco;
        this.estoqueAtual = estoqueAtual;
        this.estoqueMinimo = estoqueMinimo;
    }


    public int getIdProduto() {
        return idProduto;
    }


    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }


    public ProdutoDTO() {
        super();
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


    public void imprimir() {

        System.out.printf("\n%3d  %-20s  %4d %5d %6d  \n",
                this.getIdProduto(), this.getNome(), this.getEstoqueAtual(), this.getEstoqueMinimo()
                , this.getPreco());

    }


}
