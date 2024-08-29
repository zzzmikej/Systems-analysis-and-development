import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int tamanho = 0;
        int[] vetor1 = {100,200,300,400,500};

        System.out.println("\nDigite os valores:");
        do{
            tamanho = (new Main().tamanhoLista());
        } while(tamanho < 3);

        int[] vetor = new int[tamanho];

        lerVetor(vetor);
        exibeVetor(vetor, vetor1);

    }

    public static void exibeVetor(int[] v,int[] w){
        for (int i = 0; i < v.length; i++) {
            System.out.println("""
                    vetor[%d] = %d 
                    """.formatted(i, v[i]));
        }
        System.out.println("\nVetor 2:");
        for (int i = 0; i < w.length; i++) {
            System.out.println("""
                    vetor[%d] = %d 
                    """.formatted(i, w[i]));
        }
    }

    public static void lerVetor(int[] v){
        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < v.length; i++) {
            System.out.println("\nDigite o valor "+(i+1)+":");
            v[i] = scanner.nextInt();
        }
    }

    public int tamanhoLista(){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        if (t < 3){
            return t;
        } else {
            System.out.println("Lista muito grande!");
            return 0;
        }

    }
}
