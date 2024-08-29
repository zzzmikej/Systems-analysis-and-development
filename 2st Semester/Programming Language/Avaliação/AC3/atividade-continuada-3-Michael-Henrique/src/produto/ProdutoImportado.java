package produto;

public class ProdutoImportado extends Produto{
    private Double taxaImportacao;
    private String paisOrigem;

    public ProdutoImportado(String codigoBarras, String nome, String descricao, Double preco, Integer quantidade, String categoria, Double taxaImportacao, String paisOrigem) {
        super(codigoBarras, nome, descricao, preco, quantidade, categoria);
        this.taxaImportacao = taxaImportacao;
        this.paisOrigem = paisOrigem;
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
                | Taxa de importacao          %.2f
                | Pais de Origem:             %s
                """.formatted(toString(), taxaImportacao, paisOrigem);
    }
}

//        calcularPrecoUnitario() : Double - Preço com taxa de importação.
//        calcularPrecoTotal() : Double - Preço total com taxa de importação.
