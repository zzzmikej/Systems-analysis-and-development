package produto;

import produto.Produto;

public class produto.Perfume extends Produto {
    private String fragancia;

    public produto.Perfume(int codigo, String descricao, double preco, String fragancia) {
        super(codigo, descricao, preco);
        this.fragancia = fragancia;
    }

    @Override
    public double getValorVenda() {
        return getPreco() * 0.27;
    }

    @Override
    public String toString() {
        return """
                %s
                    Perfume
                Fragrancia: %s
                Tributo: %.2f
                """.formatted(super.toString(), fragancia, getValorVenda());
    }
}
