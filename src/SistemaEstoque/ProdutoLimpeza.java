package SistemaEstoque;

public class ProdutoLimpeza extends Produto {

    public ProdutoLimpeza(String nome, double preco, int quantidadeEstoque) {
        super(nome, preco, quantidadeEstoque);
    }

    @Override
    public double calcularImposto() {
        return this.getPreco() * 0.12;
    }
}
