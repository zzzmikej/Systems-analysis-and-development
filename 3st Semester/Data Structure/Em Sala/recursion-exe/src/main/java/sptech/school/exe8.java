package sptech.school;

import java.util.Scanner;

public class exe8 {
    private static int sum = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha um número:");
        int n = scanner.nextInt();
        calcDigits(n);
        System.out.println("""
                Total da soma dos digitos %d
                """.formatted(sum));
    }

    public static void calcDigits(int n){
        if (n > 0){
            int digits = n % 10;
            sum += digits;
            n /= 10;
            calcDigits(n);
        }
    }
}
