
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] v = {5, 3, 8, 6, 2, 7, 1, 4};

        int[] mergeSort = mergeSort(Arrays.copyOf(v, v.length));
        int[] quickSortMeioPivo = quickSortMeioPivo(Arrays.copyOf(v, v.length));
        int[] quickSortUltimoPivo = quickSortUltimoPivo(Arrays.copyOf(v, v.length));

        System.out.println("Array original: " + Arrays.toString(v));
        System.out.println("MergeSort: " + Arrays.toString(mergeSort));
        System.out.println("QuickSort (Pivô como o elemento do meio): " + Arrays.toString(quickSortMeioPivo));
        System.out.println("QuickSort (Pivô como o último elemento do vetor): " + Arrays.toString(quickSortUltimoPivo));
    }

    public static int[] mergeSort(int[] v) {
        if (v.length <= 1) {
            return v;
        }
        int q = v.length / 2;
        int[] esquerda = Arrays.copyOfRange(v, 0, q);
        int[] direita = Arrays.copyOfRange(v, q, v.length);

        mergeSort(esquerda);
        mergeSort(direita);
        intercala(v, esquerda, direita);
        return v;
    }

    public static void intercala(int[] v, int[] esquerda, int[] direita) {
        int i = 0, j = 0, k = 0;

        while (i < esquerda.length && j < direita.length) {
            if (esquerda[i] <= direita[j]) {
                v[k++] = esquerda[i++];
            } else {
                v[k++] = direita[j++];
            }
        }

        while (i < esquerda.length) {
            v[k++] = esquerda[i++];
        }

        while (j < direita.length) {
            v[k++] = direita[j++];
        }
    }

    public static int[] quickSortMeioPivo(int[] v){
        quickSortMeioPivo(v, 0,v.length - 1);
        return v;
    }

    public static void quickSortMeioPivo(int[] v, int inicio, int fim){
        if (inicio < fim){
            int i = particionaMeioPivo(v, inicio, fim);
            quickSortMeioPivo(v, inicio, i - 1);
            quickSortMeioPivo(v, i + 1, fim);
        }
    }

    public static int particionaMeioPivo(int[] v, int inicio, int fim) {
        int meio = (inicio + fim) / 2;
        int pivo = v[meio];
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            if (v[j] < pivo) {
                i++;
                int t = v[i];
                v[i] = v[j];
                v[j] = t;
            }
        }

        int t = v[i + 1];
        v[i + 1] = v[meio];
        v[meio] = t;

        return i + 1;
    }
    public static int[] quickSortUltimoPivo(int[] v){
        quickSortUltimoPivo(v, 0, v.length - 1);
        return v;
    }
    public static void quickSortUltimoPivo(int[] v, int inicio, int fim) {

        if (inicio < fim){
            int i = particionaUltimoPivo(v, inicio, fim);
            quickSortUltimoPivo(v, inicio,i - 1);
            quickSortUltimoPivo(v, i + 1, fim);
        }
    }

    public static int particionaUltimoPivo(int[] v, int inicio, int fim){
        int pivo = v[fim];
        int i = inicio - 1;

        for (int j = inicio;j < fim; j++){
            if (v[j] < pivo) {
                i++;
                int t = v[i];
                v[i] = v[j];
                v[j] = t;
            }
        }

        int t = v[i + 1];
        v[i + 1] = v[fim];
        v[fim] = t;

        return i + 1;
    }
}