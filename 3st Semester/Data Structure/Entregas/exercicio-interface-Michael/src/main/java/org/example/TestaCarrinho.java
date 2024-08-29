package org.example;

import java.util.Scanner;

public class TestaCarrinho {
    public static void main(String[] args) {
        int opcao;
        Carrinho carrinho = new Carrinho();
        do {
            System.out.println("""
                    *---------------------------------------*
                    | 1 - Adicionar Livro                   |
                    | 2 - Adicionar DVD                     |
                    | 3 - Adicionar Servico                 |
                    | 4 - Exibir Itens do Carrinho          |
                    | 5 - Exibir Total da Venda             |
                    | 6 - Sair                              |
                    *---------------------------------------*
                    """);
            Scanner numero = new Scanner(System.in);
            opcao = numero.nextInt();
            Scanner texto = new Scanner(System.in);
            switch (opcao) {
                case 1:
                    System.out.println("Digite o código do livro:");
                    Integer codigo = numero.nextInt();
                    System.out.println("Digite o preço de custo do livro:");
                    Double precoCusto = numero.nextDouble();
                    System.out.println("Digite o nome do livro:");
                    String nome = texto.next();
                    System.out.println("Digite o autor do livro:");
                    String autor = texto.next();
                    System.out.println("Digite o ISBN do livro:");
                    String isbn = texto.next();
                    Livro livro = new Livro(codigo, precoCusto, nome, autor, isbn);
                    carrinho.adicionarVendavel(livro);
                    break;
                case 2:
                    System.out.println("Digite o código do DVD:");
                    Integer codigoDVD = numero.nextInt();
                    System.out.println("Digite o preço de custo do DVD:");
                    Double precoCustoDVD = numero.nextDouble();
                    System.out.println("Digite o nome do DVD:");
                    String nomeDVD = texto.next();
                    System.out.println("Digite a gravadora do DVD:");
                    String gravadora = texto.next();
                    DVD dvd = new DVD(codigoDVD, precoCustoDVD, nomeDVD, gravadora);
                    carrinho.adicionarVendavel(dvd);
                    break;
                case 3:
                    System.out.println("Digite o código do serviço:");
                    Integer codigoServico = numero.nextInt();
                    System.out.println("Digite a descrição do serviço:");
                    String descricao = texto.next();
                    System.out.println("Digite a quantidade de horas do serviço:");
                    Integer quantHoras = numero.nextInt();
                    System.out.println("Digite o valor da hora do serviço:");
                    Double valorHora = numero.nextDouble();
                    Servico servico = new Servico( descricao,codigoServico, quantHoras, valorHora);
                    servico.setCodigo(codigoServico);
                    servico.setDescricao(descricao);
                    servico.setQuantHoras(quantHoras);
                    servico.setValorHora(valorHora);
                    carrinho.adicionarVendavel(servico);
                    break;
                case 4:
                    carrinho.exibeItensCarrinho();
                    break;
                case 5:
                    System.out.println("Total da venda: " + carrinho.calcularTotalVenda());
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida");
            }

        } while (opcao != 6);
    }
}
