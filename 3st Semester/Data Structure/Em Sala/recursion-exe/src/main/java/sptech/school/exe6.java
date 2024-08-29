package sptech.school;

import java.util.Scanner;

public class exe6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o valor para saber o qual máximo divisor:");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        mdc(a, b);
    }

    public static void mdc(int num1, int num2) {
        if (num2 == 0) {
            System.out.println("O máximo divisor comum é: " + num1);
        } else {
            int temp = num1;
            int n = num1 % num2;
            num1 = num2;
            num2 = n;
            System.out.printf("Divide-se %d por %d, obtendo-se quociente %d e resto %d.\n", temp, num1, temp / num1, n);
            mdc(num1, num2);
        }
    }
}
