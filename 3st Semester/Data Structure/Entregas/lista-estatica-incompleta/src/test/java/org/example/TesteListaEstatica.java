package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TesteListaEstatica {

    @Test
    public void criarListaAlteraTamanhoVetor() {
        ListaEstatica listaEstatica = new ListaEstatica(3);
        assertEquals(3, listaEstatica.getVetor().length);
    }

    @Test
    public void criarListaInicializaNumeroElemento() {
        ListaEstatica listaEstatica = new ListaEstatica(3);
        assertEquals(0, listaEstatica.getNroElem());
    }

    @Test
    public void adicionaAlteraVetor() {
        ListaEstatica listaEstatica = new ListaEstatica(3);

        listaEstatica.addElement(1);
        listaEstatica.addElement(4);

        assertEquals(4, listaEstatica.getVetor()[1]);
    }

    @Test
    public void adicionaAlteraNumeroElementos() {
        ListaEstatica listaEstatica = new ListaEstatica(3);

        assertEquals(0, listaEstatica.getNroElem());

        listaEstatica.addElement(1);
        assertEquals(1, listaEstatica.getNroElem());

        listaEstatica.addElement(4);
        assertEquals(2, listaEstatica.getNroElem());
        assertEquals(4, listaEstatica.getVetor()[1]);
    }

    @Test
    public void adicionaValidaListaCheia() {
        ListaEstatica listaEstatica = new ListaEstatica(3);
        listaEstatica.addElement(1);
        listaEstatica.addElement(2);
        listaEstatica.addElement(3);
        assertThrows(IllegalStateException.class, () -> listaEstatica.addElement(4));
    }

    @Test
    public void buscaQuandoNaoEntrado() {
        ListaEstatica listaEstatica = new ListaEstatica(3);
        listaEstatica.addElement(10);
        listaEstatica.addElement(20);
        listaEstatica.addElement(30);
        assertEquals(-1, listaEstatica.search(35));

    }

    @Test
    public void buscaQuandoNumeroValido() {
        ListaEstatica listaEstatica = new ListaEstatica(3);
        listaEstatica.addElement(10);
        listaEstatica.addElement(20);
        listaEstatica.addElement(30);
        assertEquals(2, listaEstatica.search(30));
    }

    @Test
    public void removePeloIndiceQuandoIndiceInvalido() {
        ListaEstatica listaEstatica = new ListaEstatica(3);
        listaEstatica.addElement(10);
        listaEstatica.addElement(20);
        listaEstatica.addElement(30);
        assertFalse(listaEstatica.removeByID(3));
        assertFalse(listaEstatica.removeByID(-3));
    }

    @Test
    public void removePeloIndiceQuandoIndiceValido() {
        ListaEstatica listaEstatica = new ListaEstatica(3);
        listaEstatica.addElement(10);
        listaEstatica.addElement(20);
        listaEstatica.addElement(30);
        assertTrue(listaEstatica.removeByID(2));
    }

    @Test
    public void removePeloIndiceAlteraNumeroElemento() {
        ListaEstatica listaEstatica = new ListaEstatica(3);
        listaEstatica.addElement(10);
        listaEstatica.addElement(20);
        listaEstatica.addElement(30);
        listaEstatica.removeByID(2);

        assertEquals(2, listaEstatica.getNroElem());
    }

    @Test
    public void removePeloIndiceAlteraVetor() {
        ListaEstatica listaEstatica = new ListaEstatica(3);
        listaEstatica.addElement(10);
        listaEstatica.addElement(20);
        listaEstatica.addElement(30);
        listaEstatica.removeByID(0);

        assertEquals(20, listaEstatica.getVetor()[0]);
    }

    @Test
    public void removeElementoQuandoElementoInvalido() {
        ListaEstatica listaEstatica = new ListaEstatica(3);
        listaEstatica.addElement(10);
        listaEstatica.addElement(20);
        listaEstatica.addElement(30);
        assertFalse(listaEstatica.removeByElement(3));
        assertFalse(listaEstatica.removeByElement(-3));
    }

    @Test
    public void removeElementoQuandoElementoValido() {
        ListaEstatica listaEstatica = new ListaEstatica(3);
        listaEstatica.addElement(10);
        listaEstatica.addElement(20);
        listaEstatica.addElement(30);
        assertTrue(listaEstatica.removeByElement(10));
    }

    @Test
    public void removeElementoAlteraNumeroElemento() {
        ListaEstatica listaEstatica = new ListaEstatica(3);
        listaEstatica.addElement(10);
        listaEstatica.addElement(20);
        listaEstatica.addElement(30);
        listaEstatica.removeByElement(10);

        assertEquals(2, listaEstatica.getNroElem());
    }

    @Test
    public void removeElementoAlteraVetor() {
        ListaEstatica listaEstatica = new ListaEstatica(3);
        listaEstatica.addElement(10);
        listaEstatica.addElement(20);
        listaEstatica.addElement(30);
        listaEstatica.removeByElement(10);

        assertEquals(20, listaEstatica.getVetor()[0]);
    }

}

