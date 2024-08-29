package org.example;

public class ListaObj <T> {

    private T[] vetor;
    private int nroElem;
    public ListaObj(int tamanho) {
        vetor = (T[]) new Object[tamanho];
        nroElem = 0;
    }
    public void adiciona(T elemento) {
        if(nroElem < vetor.length){
            vetor[nroElem] = elemento;
            nroElem++;
        } else {
            throw new IllegalStateException("A lista está cheia");
        }
    }

    public int busca(T elementoBuscado) {
        return -1;
    }

    public boolean removePeloIndice(int indice) {
        return true;
    }

    public boolean removeElemento(T elementoARemover) {
        return true;
    }

    public int getTamanho() {
        return -1;
    }

    public T getElemento(int indice) {
        return null;
    }

    public void limpa() {

    }

    public void exibe() {

    }

    public T[] getVetor() {
        return null;
    }
}
