package SistemaEstoque;

public class ProdutoPerecivel extends Produto{

    private String dataValidade;

    public ProdutoPerecivel(String nome, double preco, int quantidadeEstoque, String dataValidade){
        super(nome, preco, quantidadeEstoque);
        this.dataValidade = dataValidade;
    }

    @Override
    public void exibirInformações(){
        super.exibirInformações();
        System.out.println("Data de validade: " + dataValidade);
    }

}