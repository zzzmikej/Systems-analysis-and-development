package produto;

public class ProdutoNacional extends Produto{
    private String estadoOrigem;

    public ProdutoNacional(String codigoBarras, String nome, String descricao, Double preco, Integer quantidade, String categoria, String estadoOrigem) {
        super(codigoBarras, nome, descricao, preco, quantidade, categoria);
        this.estadoOrigem = estadoOrigem;
    }

    @Override
    public Double calcularPrecoUnitario() {
        return super.calcularPrecoUnitario();
    }

    @Override
    public Double calcularPrecoTotal() {
        return super.calcularPrecoTotal();
    }

    @Override
    public String toString() {
        return """
                --------------------------------------
                |           Produto Nacional         |
                --------------------------------------
                %s
                | Estado de Origem:             %s
                """.formatted(, estadoOrigem);
    }
}