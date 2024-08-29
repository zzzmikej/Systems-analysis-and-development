package sptech.school;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class exe7 {
    private static int a = 0;
    private static int b = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o tamanho do vetor:");
        n = scanner.nextInt();
        int[] v = new int[n];
        for (int i = 0; i < v.length; i++) {
            v[i] = ThreadLocalRandom.current().nextInt(0, 10);
            System.out.println("""
                    v[%d] = %d""".formatted(i,v[i]));
        }
        maxValue(v);
        System.out.println("O maior valor no vetor é: " + maxValue(v));
    }

    public static int maxValue(int[] v) {
        if (a < v.length) {
            if (v[a] > b) {
                b = v[a];
            }
            a++;
            maxValue(v);
        }
        return b;
    }
}
