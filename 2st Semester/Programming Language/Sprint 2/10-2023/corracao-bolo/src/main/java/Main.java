import java.util.Scanner;

public class Main {
    private static String sabor;
    private static Double valorBolo;
    private static Integer qtdDesejada;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);


        Bolo bolo02 = new Bolo("Morango", 50.0, 40);

        boolean sair = false;


        while (!sair) {
            menu();
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Quantidade de bolo:");
                    qtdDesejada = scanner.nextInt();
                    if (qtdDesejada <= 100) {
                        System.out.println("Sabor do bolo:");
                        scanner.nextLine();
                        sabor = scanner.nextLine();
                        if (sabor.equalsIgnoreCase("chocolate") || sabor.equalsIgnoreCase("morango") || sabor.equalsIgnoreCase("abacaxi")) {
                            System.out.println("Valor do bolo:");
                            valorBolo = scanner.nextDouble();
                            if (valorBolo >= 30 && valorBolo <= 50) {
                                comprarBolo();
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

    static void menu() {
        System.out.println("*------------------------------------------*");
        System.out.println("| 1 - Comprar Bolo                         |");
        System.out.println("| 2 - Exibir Relatorio                     |");
        System.out.println("| 0 - Sair                                 |");
        System.out.println("*------------------------------------------*");
    }

    static void comprarBolo(){
        Bolo bolo01 = new Bolo(sabor, valorBolo, qtdDesejada);
    }
}
