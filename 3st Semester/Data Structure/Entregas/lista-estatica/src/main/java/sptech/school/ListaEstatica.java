package sptech.school;

import java.util.Arrays;

public class ListaEstatica {
    private static int[] v;
    private static int nroElem;

    public static void createVetor(int length){
        v = new int[length];
        System.out.println("Vetor criado com o tamanho " + length);
    }

    public static void addElement(int num, int i){
        if ( i < v.length){
            v[i] = num;
        } else{
            System.out.println("Lista cheia");
        }
    }

    public static void showVetor(int i){
        if (v.length != -1){
            System.out.println(Arrays.toString(v));
        } else {
            System.out.println("Lista vazia");
        }
    }

    public static int search(int i){
        for (int j = 0; j < v.length; j++){
            if (v[j] == i){
                System.out.println("O indice do número " + i + " é " + j);
                return j;
            }
        }
        return -1;
    }

    public static boolean removeByID(int i) {
        if (i > v.length) {
            System.out.println("Indice acima do permitido");
            return false;
        }
        System.out.println("O valor " + v[i] + " foi removido com sucesso");
        v[i] = 0;
        return true;
    }

    public static boolean removeByElement(int i) {
        for (int j = 0; j < v.length; j++){
            if (v[j] == i){
                System.out.println("O valor " + v[j] + " foi removido com sucesso");
                v[j] = 0;
                return true;
            }
        }
        System.out.println("Valor não encontrado");
        return false;
    }
}
