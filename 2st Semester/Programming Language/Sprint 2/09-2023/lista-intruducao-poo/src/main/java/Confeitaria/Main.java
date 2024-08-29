package Confeitaria;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Bolo bolo = new Bolo();
        Impressao imp = new Impressao();

        boolean sair = false;


        while (!sair) {
            imp.menu();

            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Quantidade de bolo:");
                    int qtdDesejada = scanner.nextInt();
                    if (qtdDesejada <= 100) {
                        System.out.println("Sabor do bolo:");
                        scanner.nextLine();
                        String sabor = scanner.nextLine();
                        if (sabor.equalsIgnoreCase("chocolate") || sabor.equalsIgnoreCase("morango") || sabor.equalsIgnoreCase("abacaxi")) {
                            System.out.println("Valor do bolo:");
                            int valorBolo = scanner.nextInt();
                            if (valorBolo >= 30 && valorBolo <= 50) {
                                bolo.comprarBolo(qtdDesejada, sabor, valorBolo);
                            } else {
                                System.out.printf("\nPreço inválido para o bolo\n");
                            }
                        } else {
                            System.out.printf("\nSabor não disponível\n");
                        }
                    } else {
                        System.out.printf("\nSeu pedido ultrapassou nosso limite diário para esse bolo\n");
                    }

                    break;
                case 2:
                    bolo.exibirRelatorio();
                    break;
                case 0:
                    sair = true;
                    System.out.println("Saindo do Programa");
                    break;
                default:
                    System.out.println("Coloque uma opção válida!!");
            }
        }
    }
}