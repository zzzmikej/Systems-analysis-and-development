package org.example;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PilhaTest {
    @Test
    @DisplayName("isFull - Deve retornar true quando pilha estiver cheia")
    public void isFullTrueQuandoPilhaCheia() {
        school.sptech.Pilha pilhaTest = new school.sptech.Pilha(3);

        pilhaTest.push(10);
        pilhaTest.push(20);
        pilhaTest.push(30);

        assertTrue(pilhaTest.isFull());
    }

    @Test
    @DisplayName("isFull - Deve retornar false quando pilha nÃ£o estiver cheia")
    public void isFullTrueQuandoPilhaNaoCheia() {
        school.sptech.Pilha pilhaTest = new school.sptech.Pilha(5);

        pilhaTest.push(10);
        pilhaTest.push(20);
        pilhaTest.push(30);
        assertFalse(pilhaTest.isFull());
    }

    @Test
    @DisplayName("isFull - Deve retornar false quando pilha estiver vazia")
    public void isFullTrueQuandoPilhaVazia() {
        school.sptech.Pilha pilhaTest = new school.sptech.Pilha(5);

        pilhaTest.push(10);
        pilhaTest.push(20);
        pilhaTest.push(30);
        assertFalse(pilhaTest.isFull());
    }

    @Test
    @DisplayName("isEmpty - Deve retornar true quando pilha estiver vazia")
    public void isEmptyQuandoPilhaVazia() {
        school.sptech.Pilha pilhaTest = new school.sptech.Pilha(8);
        assertTrue(pilhaTest.isEmpty());
    }

    @Test
    @DisplayName("isEmpty - Deve retornar false quando pilha nÃ£o estiver vazia")
    public void isEmptyQuandoPilhaNaoVazia() {
        school.sptech.Pilha pilhaTest = new school.sptech.Pilha(8);
        pilhaTest.push(10);
        pilhaTest.push(20);
        pilhaTest.push(30);
        assertFalse(pilhaTest.isEmpty());
    }

    @Test
    @DisplayName("isEmpty - Deve retornar false quando pilha estiver cheia")
    public void isEmptyQuandoPilhaCheia() {
        school.sptech.Pilha pilhaTest = new school.sptech.Pilha(3);
        pilhaTest.push(10);
        pilhaTest.push(20);
        pilhaTest.push(30);
        assertFalse(pilhaTest.isEmpty());
    }

    @Test
    @DisplayName("peek - Deve retornar elemento do topo")
    public void peekRetornaTopo() {
        school.sptech.Pilha pilhaTest = new school.sptech.Pilha(6);
        pilhaTest.push(10);
        pilhaTest.push(20);
        pilhaTest.push(30);
        assertEquals(30, pilhaTest.peek());
    }

    @Test
    @DisplayName("peek - Deve retornar elemento do topo quando pilha cheia")
    public void peekRetornaTopoPilhaCheia() {
        school.sptech.Pilha pilhaTest = new school.sptech.Pilha(3);
        pilhaTest.push(10);
        pilhaTest.push(20);
        pilhaTest.push(30);
        assertEquals(30, pilhaTest.peek());
    }

    @Test
    @DisplayName("peek - Deve retornar -1 quando pilha vazia")
    public void peekRetornaPilhaVazia() {
        school.sptech.Pilha pilhaTest = new school.sptech.Pilha(3);
        assertEquals(-1, pilhaTest.peek());
    }

    @Test
    @DisplayName("pop - Deve retornar elemento do topo")
    public void popRetornaTopo() {
        school.sptech.Pilha pilhaTest = new school.sptech.Pilha(6);
        pilhaTest.push(10);
        pilhaTest.push(20);
        pilhaTest.push(30);
        assertEquals(30, pilhaTest.pop());
    }

    @Test
    @DisplayName("pop - Deve decrementar topo")
    public void popDecrementaTopo() {
        school.sptech.Pilha pilhaTest = new school.sptech.Pilha(6);
        pilhaTest.push(10);
        pilhaTest.push(20);
        pilhaTest.push(30);
        pilhaTest.pop();
        assertEquals(1, pilhaTest.getTopo());
    }

    @Test
    @DisplayName("push  - Deve lanÃ§ar IllegalStateException quando pilha cheia ")
    public void pushLancaIllegalStateExceptionQuandoPilhaCheia() {
        school.sptech.Pilha pilhaTest = new school.sptech.Pilha(6);
        pilhaTest.push(30);
        pilhaTest.push(40);
        pilhaTest.push(50);
        pilhaTest.push(60);
        pilhaTest.push(70);
        pilhaTest.push(80);
        assertThrows(IllegalStateException.class, () -> pilhaTest.push(90));
    }

    @Test
    @DisplayName("push - Insere elemento no vetor")
    public void pushInsereElemento() {
        school.sptech.Pilha pilhaTest = new school.sptech.Pilha(6);

        pilhaTest.push(10);
        pilhaTest.push(20);
        pilhaTest.push(30);

        assertEquals(30, pilhaTest.peek());
    }

    @Test
    @DisplayName("push - Aumenta topo")
    public void pushAumentaTopo() {
        school.sptech.Pilha pilhaTest = new school.sptech.Pilha(6);

        pilhaTest.push(10);
        pilhaTest.push(20);
        pilhaTest.push(30);

        assertEquals(2, pilhaTest.getTopo());
    }
}
