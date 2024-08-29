public abstract class Produto implements Tributavel{

    private int codigo;
    private String descricao;
    private double preco;

    public Produto(int codigo, String descricao, double preco) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return """
                    Produto
                Codigo: %d
                Descricao: %s
                Preco: %.2f
                Tributo: %.2f
                """.formatted(codigo, descricao, preco, getValorTributo());
    }
}