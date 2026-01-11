package SistemaEstoque;

import java.util.Scanner;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);

        ArrayList<Produto> listaDeProdutos = new ArrayList<>();

        Produto p1 = new Produto("Cadeira", 450, 30);
        Produto p2 = new Produto("Tapete", 200, 10);
        Produto p3 = new Produto("Mesa", 1000, 15);
        Produto p4 = new Produto("Sofá", 2000, 5);
        Produto p5 = new Produto("Cortina", 150, 13);

        listaDeProdutos.add(p1);
        listaDeProdutos.add(p2);
        listaDeProdutos.add(p3);
        listaDeProdutos.add(p4);
        listaDeProdutos.add(p5);

        int opcao = 0;
        while (opcao != 6) {
            exibirOpcoes();
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    exibirRelatorio(listaDeProdutos);
                    break;

                case 2:
                    realizarBusca(listaDeProdutos, leitura);
                    break;

                case 3:
                    removerProduto(listaDeProdutos, leitura);
                    break;

                case 4:
                    cadastrarProduto(listaDeProdutos, leitura);
                    break;

                case 5:
                    calcularPatrimonio(listaDeProdutos);
                    break;

                case 6:
                    System.out.println("Encerrando programa.");
                    break;

                default:
                    System.out.println("Opção Inválida.");
            }
        }

        // System.out.println("---DESCONTO DE 50%---");

        // double somaTotalPosDesconto = 0;

        // for (Produto p : listaDeProdutos) {
        // if (p.getPreco() > 500) {
        // p.reajustarPreco(-50);
        // System.out.println("Desconto aplicado em: " + p.getNome());
        // p.exibirInformações();
        // }
        // somaTotalPosDesconto += (p.getPreco() * p.getQuantidadeEstoque());
        // }
        // System.out.println("Valor total do estoque após desconto de 50%: R$" +
        // somaTotalPosDesconto);
    }

    public static void exibirOpcoes() {
        System.out.println("\n--- SISTEMA DE ESTOQUE ---");
        System.out.println("1. Ver relatório");
        System.out.println("2. Buscar produto");
        System.out.println("3. Remover produto");
        System.out.println("4. Adicionar produto");
        System.out.println("5. Patrimônio total");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
        System.out.println();
    }

    public static void exibirRelatorio(ArrayList<Produto> lista) {
        System.out.println("RELATÓRIO");
        for (Produto p : lista) {
            p.exibirInformações();
            System.out.println();
        }
    }

    public static void realizarBusca(ArrayList<Produto> lista, Scanner sc) {
        System.out.print("Nome para busca: ");
        String nome = sc.nextLine();

        for (Produto p : lista) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                p.exibirInformações();
                return;
            }
        }
        System.out.println("Não encontrado.");
    }

    public static void removerProduto(ArrayList<Produto> lista, Scanner sc) {
        System.out.println("Qual item deseja remover?");
        String remover = sc.nextLine();
        lista.removeIf(p -> p.getNome().equalsIgnoreCase(remover));
        System.out.println("Item removido.");
    }

    public static void cadastrarProduto(ArrayList<Produto> lista, Scanner sc) {
        System.out.println("Nome do produto: ");
        String nomeNovo = sc.nextLine();

        System.out.println("Preço: R$");
        double precoNovo = sc.nextDouble();

        System.out.println("Quantidade em estoque: ");
        int qtdNovo = sc.nextInt();

        sc.nextLine();

        Produto pNovo = new Produto(nomeNovo, precoNovo, qtdNovo);
        lista.add(pNovo);

        System.out.println("Produto cadastrado.");
    }

    public static void calcularPatrimonio(ArrayList<Produto> lista) {
        double total = 0;
        for (Produto p : lista) {
            total += (p.getPreco() * p.getQuantidadeEstoque());
        }
        System.out.println("O valor total do estoque é: R$" + total);
    }

}
