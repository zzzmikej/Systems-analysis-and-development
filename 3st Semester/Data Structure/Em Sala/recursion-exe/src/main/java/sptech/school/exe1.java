package sptech.school;

import java.util.Scanner;

public class exe1 {
    private static int n;
    private static int m = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha um número para a soma");
        n = scanner.nextInt();
        somaCrescente(n);

    }

    public static void somaCrescente( int n ){
        if (n >= 0 && m <= n){
            m++;
            somaCrescente(n);
        }
    }
}
