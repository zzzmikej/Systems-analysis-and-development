package org.example;

public class ListaEstatica {
    private int[] vetor;
    private int nroElem;

    public ListaEstatica(int tamanhoMaximo) {
        vetor = new int[tamanhoMaximo];
        nroElem = 0;
    }

    public void addElement(int elemento) {
        if (nroElem == vetor.length) {
            throw new IllegalStateException("Lista cheia");

        }
        vetor[nroElem] = elemento;
        nroElem++;
    }

    public int search(int elemento) {
        for (int i = 0; i < nroElem; i++) {
            if (vetor[i] == elemento) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeByID(int indice) {
        if (indice < 0 || indice >= nroElem) {
            return false;
        }
        for (int i = indice; i < nroElem - 1; i++) {
            vetor[i] = vetor[i + 1];
        }
        nroElem--;
        return true;
    }

    public boolean removeByElement(int elemento) {
        int indice = search(elemento);
        if (indice != -1) {
            return removeByID(indice);
        }
        return false;
    }

    public void exibe() {
        for (int i = 0; i < nroElem; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
    }

    public int getNroElem() {
        return nroElem;
    }

    public int[] getVetor() {
        return vetor;
    }
}
