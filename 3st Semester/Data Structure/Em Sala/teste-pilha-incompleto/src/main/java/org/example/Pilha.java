package school.sptech;

import java.util.Arrays;

public class Pilha {
    private int[] vetor;
    private int nroElem;

    public Pilha(int tamanho) {
        this.vetor = new int[tamanho];
        this.nroElem = -1;
    }

    public boolean isEmpty() {
        return nroElem == -1;
    }

    public boolean isFull() {
        return nroElem == vetor.length - 1;
    }

    public void push(int elem) {
        if (isFull()) {
            throw new IllegalStateException("Pilha cheia");
        }

        nroElem++;

        vetor[nroElem] = elem;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }

        int elem = vetor[nroElem];

        nroElem--;
        return elem;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }

        return vetor[nroElem];
    }

    public void exibe() {
        if (isEmpty()) {
            throw new IllegalStateException("Pilha vazia");
        }

        System.out.println(Arrays.toString(vetor));
    }

    @Override
    public String toString() {
        return "Pilha [vetor=" + Arrays.toString(vetor) + ", nroElem=" + nroElem + "]";
    }

    public int getTopo() {
        return nroElem;
    }
}