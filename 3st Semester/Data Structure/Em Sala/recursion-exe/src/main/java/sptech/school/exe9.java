package sptech.school;

import java.util.Scanner;

public class exe9 {
    static StringBuilder binary = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha um número:");
        int n = scanner.nextInt();
        System.out.println("Representação binária de " + n + ": " + binary(n));    }

    public static String binary(int number){
        if (number > 0) {
            int resto = number % 2;
            binary.insert(0, resto);
            number /= 2;
            binary(number);
        }
        return binary.toString();
    }
}
