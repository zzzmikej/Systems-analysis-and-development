package produto;

import produto;

public class Alimento extends Produto {
    private int quantVitamina;

    public produto.Alimento(int codigo, String descricao, double preco, int quantVitamina) {
        super(codigo, descricao, preco);
        this.quantVitamina = quantVitamina;
    }

    @Override
    public double getValorVenda() {
        return getPreco() * 0.15;
    }

    @Override
    public String toString() {
        return """
                %s
                    Alimento
                QuantidadeVitamina: %d
                Tributo: %.2f
                """.formatted(super.toString(), quantVitamina, getValorVenda());
    }
}
