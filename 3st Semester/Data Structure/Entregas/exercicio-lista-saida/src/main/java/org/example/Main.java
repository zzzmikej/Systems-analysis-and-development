package org.example;
import org.example.utils.Bebida;
import org.example.utils.ListaObj;

    import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            ListaObj<Bebida> lista = new ListaObj<>(5);
            Scanner scanner = new Scanner(System.in);

            int opcao = 0;
            while (opcao != 3) {
                System.out.println("===== SEJA BEM VINDO =====");
                System.out.println("1 - Adicionar uma bebida no estoque");
                System.out.println("2 - Exibir estoque de bebidas cadastradas");
                System.out.println("3 - Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o ID do produto: ");
                        int id = scanner.nextInt();

                        System.out.print("Digite o nome do produto: ");
                        String nome = scanner.next();

                        System.out.print("Digite o preço: ");
                        double preco = scanner.nextDouble();

                        System.out.print("Digite o tipo: ");
                        String tipo = scanner.next();

                        System.out.print("A bebida é alcoólica? (true/false): ");
                        boolean alcoolica = scanner.nextBoolean();

                        System.out.print("Digite a marca da bebida: ");
                        String marca = scanner.next();

                        System.out.print("Digite a quantidade em estoque da bebida: ");
                        int quantidadeEstoque = scanner.nextInt();

                        Bebida bebida = new Bebida(id, nome, preco, tipo, alcoolica, marca, quantidadeEstoque);
                        lista.adiciona(bebida);
                        System.out.println("Produto cadastrado com sucesso!\n");
                        break;
                    case 2:
                        System.out.println("===== Bebidas no estoque =====");
                        System.out.printf("%-5s %-20s %-10s %-15s %-8s %-15s %-10s\n", "ID", "Nome", "Preço", "Tipo", "Alcoólica", "Marca", "Estoque");
                        for (int i = 0; i < lista.getTamanho(); i++) {
                            Bebida estoque = lista.getElemento(i);
                            System.out.println(estoque);
                        }
                        System.out.println();
                        break;
                    case 3:
                        System.out.println("Encerrando...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            }

            scanner.close();
        }
    }