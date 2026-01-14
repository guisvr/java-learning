package SistemaEstoque;

public class ProdutoComum extends Produto{

    public ProdutoComum (String nome, double preco, int quantidadeEstoque){

    super(nome, preco, quantidadeEstoque);
    }

    @Override
    public double calcularImposto() {
        return this.getPreco() * 0.10;
    }
}
