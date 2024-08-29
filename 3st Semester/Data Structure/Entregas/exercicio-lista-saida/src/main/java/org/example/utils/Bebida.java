package org.example.utils;

public class Bebida {
        private int id;
        private String nome;
        private double preco;
        private String tipo;
        private boolean alcoolica;
        private String marca;
        private int quantidadeEstoque;

        public Bebida(int id, String nome, double preco, String tipo, boolean alcoolica, String marca, int quantidadeEstoque) {
            this.id = id;
            this.nome = nome;
            this.preco = preco;
            this.tipo = tipo;
            this.alcoolica = alcoolica;
            this.marca = marca;
            this.quantidadeEstoque = quantidadeEstoque;
        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isAlcoolica() {
        return alcoolica;
    }

    public void setAlcoolica(boolean alcoolica) {
        this.alcoolica = alcoolica;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    @Override
        public String toString() {
            return String.format("%-5d %-20s %-10.2f %-15s %-8s %-15s %-10d", id, nome, preco, tipo, alcoolica, marca, quantidadeEstoque);
        }
    }

