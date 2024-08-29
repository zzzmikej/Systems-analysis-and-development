package bebida;

public class bebida implements Calculo{
    private String nome;
    private String marca;
    private Double preco;
    private String tipo;

    public bebida(String nome, String marca, Double preco, String tipo) {
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
        this.tipo = tipo;
    }

    public bebida() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public Double calcularPreco() {
        return null;
    }

    @Override
    public String toString() {
        return """
                      Bebida
               Nome:        %s
               Marca:       %s
               Preco:       %.2f
               Tipo:        %s
               """.formatted(nome, marca, preco, tipo);
    }
}
