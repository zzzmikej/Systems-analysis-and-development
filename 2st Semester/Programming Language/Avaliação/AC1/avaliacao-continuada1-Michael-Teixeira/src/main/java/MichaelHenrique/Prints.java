package MichaelHenrique;

public class Prints {
    static void bemVindo(){
        System.out.println("*--------------------------------------*");
        System.out.println("|        Bem Vindo a Café Tech !       |");
        System.out.println("*--------------------------------------*\n");

    }
    static void menu(){
        System.out.println("*--------------------------------------*");
        System.out.println("| Digite a Opcao desejada:             |");
        System.out.println("| 1) Registrar Pontos                  |");
        System.out.println("| 2) Trocar Pontos por Café            |");
        System.out.println("| 3) Simular Recarga Programada        |");
        System.out.println("| 4) Sair                              |");
        System.out.println("*--------------------------------------*");
    }
    static void registrarPontos(){
        System.out.println("Quantos pontos deseja cadastrar:");
    }
    static void pontosCafe(){
        System.out.println("Informe a quantidade de cafés desejadas:");
    }
    static void simularRecarga(){
        System.out.println("Informe a quantidade mensal de pontos: ");
    }
    static void simularRecarga1(){
        System.out.println("Por quantos meses deseja realizar essa recarga? ");
    }
}
