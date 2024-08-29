package sptech.school;

public class ObjetoClasse {
    private int id;
    private String nome;
    private double valor;
    private int quantidade;
    // Outros atributos conforme necessário

    // Construtor
    public ObjetoClasse(int id, String nome, double valor, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Valor: " + valor + ", Quantidade: " + quantidade;
    }
}
