import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SomaDeElementos {
    public static void main(String[] args) {
        Integer numeros;
        Integer soma = 0;

        List<Integer> listaInteiros = new ArrayList();

        for (int i = 0; i < 10; i++) {
            numeros = ThreadLocalRandom.current().nextInt(1, 100);
            listaInteiros.add(numeros);
            System.out.println("Numero adicionado ao Array: " + numeros );

        }

        for (int i = 0; i < 10; i++){
            System.out.println(i+1 + ". " + listaInteiros.get(i));

            soma += listaInteiros.get(i);
        }

        System.out.println("Soma dos numeros aleatorios: " + soma);
    }


}
// Soma de Elementos
//Escreva um programa que cria uma lista de inteiros e calcula a soma de
// todos os elementos presentes na lista, exiba a soma.