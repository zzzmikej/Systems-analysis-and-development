package sptech.school;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class exe2 {
    private static int[] v;
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
        somaVetores(v, 0);
    }

    public static void somaVetores(int[] v, int index){
        if (index < v.length){
            m += v[index];
            somaVetores(v, (index +1));
        } else {
            System.out.println("""
                    A soma total é:
                    %d
                    """.formatted(m));
        }
    }
}
