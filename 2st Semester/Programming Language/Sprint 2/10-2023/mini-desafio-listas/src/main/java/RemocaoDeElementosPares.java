import java.util.ArrayList;
import java.util.List;

public class RemocaoDeElementosPares {
    public static void main(String[] args){
        List<Integer> listaNumeros = new ArrayList();
        for (int i = 0; i <= 100; i++) {
            listaNumeros.add(i);
        }
        for (int j = 0; j <= listaNumeros.size(); j++) {
            if (listaNumeros.get(j) % 2 == 0){
                listaNumeros.remove(j);
            }
        }
        System.out.println(listaNumeros);
    }
}
//Remoção de Elementos Pares
//Dada uma lista de inteiros, escreva um programa que remova todos
// os elementos pares da lista e exiba a lista resultante.