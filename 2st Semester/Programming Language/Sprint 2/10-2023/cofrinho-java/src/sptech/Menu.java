package sptech;
			
import java.util.Scanner;

public class Menu {
    private Cofrinho cofrinho;
    private Scanner scanner;

    public Menu() {
        cofrinho = new Cofrinho();
        scanner = new Scanner(System.in);
    }

    public void exibirMenuPrincipal() { //Criando um Metodo para Mostrar um menu com as opcoes dadas

        boolean sair = false;
        while (!sair) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Adicionar Moeda");
            System.out.println("2 - Remover Moeda");
            System.out.println("3 - Listar Moeda");
            System.out.println("4 - Calcular Valor Total convertido");
            System.out.println("0 - Encerrar Programa");

            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("----------------------------------------------------");
                    System.out.println(" ");
        			System.out.println("            Adicionando Moeda         ");
        			System.out.println(" ");
                    adicionarMoeda();
                    break;
                case 2:
                    System.out.println("----------------------------------------------------");
                    System.out.println(" ");
        			System.out.println("            Removendo Moeda         ");
        			System.out.println(" ");
                    removerMoeda();
                    break;
                case 3:
                    System.out.println("----------------------------------------------------");
                    System.out.println(" ");
        			System.out.println("            Listando Moeda         ");
        			System.out.println(" ");
                    listarMoedas();
                    break;
                case 4:
                    System.out.println("----------------------------------------------------");
                    System.out.println(" ");
                	System.out.println("            Valor Total Convertido         ");
                	System.out.println(" ");
                    calcularValorTotal();
                    break;
                case 0:
                    sair = true;
                    System.out.println("Encerrando Sistema");
        			System.out.println(" ");
                    break;
                default:
        			System.out.println("Opção Inválida");
        			System.out.println(" ");
        			exibirMenuPrincipal();
        			break;
            }
        }

        scanner.close();
        System.out.println("Sistema Encerrado, Até Mais!!");
    }

    private void adicionarMoeda() {
        System.out.println("Digite o valor da moeda:");
        double valor = scanner.nextDouble();
        System.out.println("Digite o país da moeda (Real, Dolar, Euro):");
        String pais = scanner.next();
        Moeda moeda;
        if (pais.equalsIgnoreCase("Real")) {
            moeda = new Real(valor);
        } else if (pais.equalsIgnoreCase("Dolar")) {
            moeda = new Dolar(valor);
        } else if (pais.equalsIgnoreCase("Euro")) {
            moeda = new Euro(valor);
        } else {
            System.out.println("País inválido!");
            return;
        }
        cofrinho.adicionarMoeda(moeda);
        System.out.println("Moeda adicionada com sucesso!");
        System.out.println(" ");
        System.out.println("----------------------------------------------------");
    }

    private void removerMoeda() {
        System.out.println("Digite o índice da moeda a ser removida:");
        int indice = scanner.nextInt();
        cofrinho.removerMoeda(indice);
        System.out.println(" ");
        System.out.println("----------------------------------------------------");
    }

    private void listarMoedas() {
        System.out.println("Lista de Moedas:");
        cofrinho.listarMoedas();
        System.out.println(" ");
        System.out.println("----------------------------------------------------");
    }

    private void calcularValorTotal() {
        double total = cofrinho.calcularTotal();
        System.out.println("Valor total: " + total);
        System.out.println(" ");
        System.out.println("----------------------------------------------------");
    }
}
