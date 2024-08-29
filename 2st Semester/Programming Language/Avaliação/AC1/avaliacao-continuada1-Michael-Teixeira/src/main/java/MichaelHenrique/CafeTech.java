package MichaelHenrique;

import java.util.Scanner;

public class CafeTech {
    Scanner scanner = new Scanner(System.in);

    Integer pontos = 0;

    public void exibirMenu() {
        boolean sair = false;

        while (!sair) {
            Prints.menu();
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    registrarPontos();
                    break;
                case 2:
                    pontosCafe();
                    break;
                case 3:
                    simularRecarga();
                    break;
                case 4:
                    sair = true;
                    break;
                default:
            }
        }
    }

    public void registrarPontos() {
        Prints.registrarPontos();
        int cadPontos = scanner.nextInt();
        if (cadPontos > 0) {
            pontos += cadPontos;
            System.out.printf("Recarga efetuada com sucesso!\n Quantidade atual de pontos: %d\n\n", pontos);
        } else {
            System.out.println("A quantidades de pontos inseridas está inválidas\n");
        }
    }

    public void pontosCafe() {
        Prints.pontosCafe();
        int cafes = scanner.nextInt();
        if ((cafes * 10) <= pontos) {
            pontos -= (cafes * 10);
            System.out.printf("\n Preparando Café! \n Saldo atual de pontos: %d\n\n", pontos);
        } else {
            System.out.print("\n*---------------Atenção----------------*\n");
            System.out.printf("Pontos insuficientes para comprar %d cafés \nPontos Necessarios: %d \nSaldo de Pontos " +
                    "Atuais: %d\n\n", cafes, (cafes * 10), pontos);

        }
    }

    public void simularRecarga(){
        Prints.simularRecarga();
        int simulacao = scanner.nextInt();
        Prints.simularRecarga1();
        int meses = scanner.nextInt();
        int simu = pontos;
        int day = 0;
        System.out.println("*--------------------------------------*");
        System.out.printf("Saldo atual de pontos: %d\n", pontos);
        for (int i = 0; i < meses; i++){
            simu += simulacao;
            day++;
            System.out.println("*--------------------------------------*");
            System.out.printf("Saldo no %dº Mês = %d\n", day, simu);
        }
        System.out.printf("\nCom esse saldo você consegue tomar %d cafés\n\n", ((simu*10)/pontos));
    }
}
