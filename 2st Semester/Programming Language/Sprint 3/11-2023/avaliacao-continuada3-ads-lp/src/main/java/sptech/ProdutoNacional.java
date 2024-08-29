package sptech;

public class ProdutoNacional extends Produto {
    private String estadoOrigem;

    public ProdutoNacional(String codigoBarras, String nome, String descricao, Double preco, Integer quantidade, String categoria, String estadoOrigem) {
        super(codigoBarras, nome, descricao, preco, quantidade, categoria);
        this.estadoOrigem = estadoOrigem;
    }

    @Override
    public Double calcularPrecoUnitario() {
        return this.preco;
    }

    @Override
    public Double calcularPrecoTotal() {
        return this.preco * this.quantidade;
    }

    public String getEstadoOrigem() {
        return estadoOrigem;
    }

    public void setEstadoOrigem(String estadoOrigem) {
        this.estadoOrigem = estadoOrigem;
    }

    @Override
    public String toString() {
        return """
                Código de Barras: %s
                Nome: %s
                Preço: %.2f
                Quantidade: %d
                Categoria: %s
                Estado Origem: %s
                Descrição: %s""".formatted(codigoBarras, nome, preco, quantidade, categoria, estadoOrigem, descricao);
    }
}
