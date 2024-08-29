package sptech.school;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class exe5 {
    private static int m, n, o;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o tamanho do vetor:");
        n = scanner.nextInt();
        int[] v = new int[n];
        System.out.println("""
                Todos os números de dentro do vetor:
                """);
        for (int i = 0; i < v.length; i++) {
            v[i] = ThreadLocalRandom.current().nextInt(0, 10);
            System.out.println("""
                    v[%d] = %d
                    """.formatted(i, v[i]));
        }
        System.out.println("Escolha um número para procurar na lista:");
        o = scanner.nextInt();
        qtdAparece(v, 0, o);
    }

    public static void qtdAparece(int[] v, int index, int number) {
        if (index < v.length) {
            if (v[index] == number) {
                m++;
            }
            qtdAparece(v, (index + 1), number);
        } else {
            System.out.println("""
                    O valor %d ocorre %d vezes.
                    """.formatted(number,m));
        }
    }
}