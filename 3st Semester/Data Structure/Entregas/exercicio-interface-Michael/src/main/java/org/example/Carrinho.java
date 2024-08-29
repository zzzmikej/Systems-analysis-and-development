package org.example;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<Vendavel> cart;

    public Carrinho() {
        this.cart = new ArrayList<>();
    }

    public void adicionarVendavel(Vendavel t){
        cart.add(t);
        System.out.println(t + " adicionado ao carrinho");
    }
    public Double calcularTotalVenda(){
        Double total = 0.0;
        for (Vendavel t: cart){
            total += t.getValorVenda();
        }
        return total;
    }
    public void exibeItensCarrinho(){
        for (Vendavel t: cart){
            System.out.println(t);
        }
    }
}
