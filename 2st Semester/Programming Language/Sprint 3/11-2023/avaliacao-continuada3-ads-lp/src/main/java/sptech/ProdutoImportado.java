package sptech;

public class ProdutoImportado extends Produto {
    private String paisOrigem;
    private Double taxaImportacao;

    public ProdutoImportado(String codigoBarras, String nome, String descricao, Double preco, Integer quantidade, String categoria, String paisOrigem, Double taxaImportacao) {
        super(codigoBarras, nome, descricao, preco, quantidade, categoria);
        this.paisOrigem = paisOrigem;
        this.taxaImportacao = taxaImportacao;
    }

    @Override
    public Double calcularPrecoUnitario() {
        return this.preco + this.taxaImportacao;
    }

    @Override
    public Double calcularPrecoTotal() {
        return (this.preco * this.quantidade) + this.taxaImportacao;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public Double getTaxaImportacao() {
        return taxaImportacao;
    }

    public void setTaxaImportacao(Double taxaImportacao) {
        this.taxaImportacao = taxaImportacao;
    }

    @Override
    public String toString() {
        return """
                Código de Barras: %s
                Nome: %s
                Preço: %.2f
                Taxa: %.2f
                Quantidade: %d
                Categoria: %s
                País Origem: %s
                Descrição: %s""".formatted(codigoBarras, nome, preco, taxaImportacao, quantidade, categoria, paisOrigem, descricao);
    }
}
