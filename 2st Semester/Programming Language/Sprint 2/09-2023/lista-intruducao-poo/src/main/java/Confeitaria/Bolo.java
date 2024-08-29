package Confeitaria;

public class Bolo {
    //Atributos = Caracteristicas
    String sabor;
    int valor;
    int QtdVendida;

    void comprarBolo(int qtdDesejada, String saborDesejado, int valorBolo) {
        QtdVendida = qtdDesejada;
        valor = valorBolo;
        sabor = saborDesejado;
    }
    String exibirRelatorio(){
        String frase =
                "o bolo "+ sabor + ", foi comprado " + QtdVendida + " vezes hoje, totalizando R$" + (valor * QtdVendida);
        return frase;
    }
}
