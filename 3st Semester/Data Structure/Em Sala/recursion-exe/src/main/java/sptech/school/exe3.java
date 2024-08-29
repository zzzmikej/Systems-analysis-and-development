package sptech.school;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class exe3 {
    private static int n, m;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o tamanho do vetor:");
        n = scanner.nextInt();
        int[] v = new int[n];
        System.out.println("""
                    Todos os números de dentro do vetor:
                    """);
        for (int i = 0; i < v.length;i++){
            v[i] = ThreadLocalRandom.current().nextInt(0, 10);
            System.out.println("""
                    v[%d] = %d
                    """.formatted(i, v[i]));
        }
        somaPares(v, 0);
    }

    public static void somaPares(int[] v, int index){
        if (index < v.length){
            if (v[index] % 2 == 0){
                m += v[index];
            }
            somaPares(v, (index +1));
        } else {
            System.out.println("""
                    A soma total é:
                    %d
                    """.formatted(m));
        }
    }
}