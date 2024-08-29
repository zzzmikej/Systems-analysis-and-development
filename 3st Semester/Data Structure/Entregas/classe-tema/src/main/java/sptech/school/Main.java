package sptech.school;

import sptech.school.ObjetoClasse;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
    ObjetoClasse[] vetor = new ObjetoClasse[8];
        vetor[0] = new ObjetoClasse(1, "Objeto1", 10.5, 3);
        vetor[1] = new ObjetoClasse(2, "Objeto2", 15.2, 2);
        vetor[2] = new ObjetoClasse(3, "Objeto3", 5.8, 5);
        vetor[3] = new ObjetoClasse(4, "Objeto4", 20.1, 1);
        vetor[4] = new ObjetoClasse(5, "Objeto5", 8.9, 4);
        vetor[5] = new ObjetoClasse(6, "Objeto6", 12.6, 2);
        vetor[6] = new ObjetoClasse(7, "Objeto7", 18.4, 3);
        vetor[7] = new ObjetoClasse(8, "Objeto8", 6.3, 5);

        insertionSort(vetor.clone());
        mergeSort(vetor.clone());
        quickSort(vetor.clone(), 0, vetor.length - 1);
    }

    public static void insertionSort(ObjetoClasse[] vetor) {
        for (int i = 1; i < vetor.length; ++i) {
            ObjetoClasse chave = vetor[i];
            int j = i - 1;

            while (j >= 0 && vetor[j].getValor() > chave.getValor()) {
                vetor[j + 1] = vetor[j];
                j = j - 1;
            }
            vetor[j + 1] = chave;
        }

        System.out.println("Ordenação usando Insertion Sort:");
        for (ObjetoClasse objeto : vetor) {
            System.out.println(objeto);
        }
    }
    public static void mergeSort(ObjetoClasse[] vetor) {
        if (vetor.length > 1) {
            int meio = vetor.length / 2;
            ObjetoClasse[] esquerda = Arrays.copyOfRange(vetor, 0, meio);
            ObjetoClasse[] direita = Arrays.copyOfRange(vetor, meio, vetor.length);

            mergeSort(esquerda);
            mergeSort(direita);

            int i = 0, j = 0, k = 0;

            while (i < esquerda.length && j < direita.length) {
                if (esquerda[i].getValor() < direita[j].getValor()) {
                    vetor[k] = esquerda[i];
                    i++;
                } else {
                    vetor[k] = direita[j];
                    j++;
                }
                k++;
            }

            while (i < esquerda.length) {
                vetor[k] = esquerda[i];
                i++;
                k++;
            }

            while (j < direita.length) {
                vetor[k] = direita[j];
                j++;
                k++;
            }
        }

        System.out.println("\nOrdenação usando Merge Sort:");
        for (ObjetoClasse objeto : vetor) {
            System.out.println(objeto);
        }
    }

    public static void quickSort(ObjetoClasse[] vetor, int inicio, int fim) {
        // Implementação do Quick Sort
        if (inicio < fim) {
            int indicePivo = particionar(vetor, inicio, fim);
            quickSort(vetor, inicio, indicePivo - 1);
            quickSort(vetor, indicePivo + 1, fim);
        }

        // Imprimir vetor ordenado
        System.out.println("\nOrdenação usando Quick Sort:");
        for (ObjetoClasse objeto : vetor) {
            System.out.println(objeto);
        }
    }

    public static int particionar(ObjetoClasse[] vetor, int inicio, int fim) {
        double pivo = vetor[fim].getValor();
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            if (vetor[j].getValor() < pivo) {
                i++;
                ObjetoClasse temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
            }
        }

        ObjetoClasse temp = vetor[i + 1];
        vetor[i + 1] = vetor[fim];
        vetor[fim] = temp;

        return i + 1;
    }
}