package Empresa;

import java.util.Scanner;

public class TesteColaborador {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        RecursosHumanos rh01 = new RecursosHumanos();
        Colaborador colaborador01 = new Colaborador("Michael", "Estagiário", 3100.0);
        colaborador01.exibirDados();

        Colaborador colaborador02 = new Colaborador("Marcos", "Analista Jr.", 6000.0);
        colaborador02.exibirDados();

        rh01.promoverColaborador(colaborador01, "Desenvolvedor Jr.", 6400.0);

        rh01.reajustarSalario(colaborador01, 6500.0);

        rh01.exibirInfosRH();
    }
}
