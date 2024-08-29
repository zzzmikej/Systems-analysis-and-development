public class SuperPoder {

    private String nome;
    private Integer categoria;

    public SuperPoder(String nome, Integer categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public Integer getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return """
                Nome: %s, Categoria: %d""".formatted(this.nome, this.categoria);
    }
}
