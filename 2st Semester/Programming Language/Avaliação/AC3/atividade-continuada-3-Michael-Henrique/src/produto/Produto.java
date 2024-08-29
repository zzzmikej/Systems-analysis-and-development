package produto;

public abstract class Produto {
    private String codigoBarras;
    private String nome;
    private String descricao;
    private Double preco;
    private Integer quantidade;
    private String categoria;

    public Produto(String codigoBarras, String nome, String descricao, Double preco, Integer quantidade, String categoria) {
        this.codigoBarras = codigoBarras;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }


    public Double calcularPrecoUnitario(){
        if (preco <= 0){
            System.out.println("A preco nao pode ser zero ou negativo");
        } else {
            System.out.println("O preco por unidade e de R$"+preco);
        }
        return preco;
    }

    public Double calcularPrecoTotal(){
        if( preco <= 0 || quantidade <= 0) {
            System.out.println("Valores incorretos\nNenhum pode ser 0 ou negativo");
        } else {
            System.out.println("A quantidade total foi de R$"+preco*quantidade);
        }
        return preco * quantidade;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return """
                --------------------------------------
                | Codigo de Barras:           %s
                | Nome:                       %s
                | Descricao:                  %s
                | Preco:                      %.2f
                | Quantidade:                 %d
                | Categoria:                  %s
                """.formatted(codigoBarras, nome, descricao, preco, quantidade, categoria);
    }
}