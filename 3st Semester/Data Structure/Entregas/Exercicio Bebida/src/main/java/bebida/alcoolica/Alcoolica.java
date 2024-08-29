package bebida.alcoolica;

public class Alcoolica extends Bebida{
    private double teorAlcoolico;
    private int idade;
    private String paisDeOrigem;

    public Alcoolica(String nome, String marca, Double preco, String tipo, int idade, String paisDeOrigem) {
        super(nome, marca, preco, tipo);
        this.idade = idade;
        this.paisDeOrigem = paisDeOrigem;
    }

    public Alcoolica(int idade, String paisDeOrigem) {
        this.idade = idade;
        this.paisDeOrigem = paisDeOrigem;
    }


    public void setTeorAlcoolico(double teorAlcoolico) {
        this.teorAlcoolico = teorAlcoolico;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getPaisDeOrigem() {
        return paisDeOrigem;
    }

    public void setPaisDeOrigem(String paisDeOrigem) {
        this.paisDeOrigem = paisDeOrigem;
    }

    @Override
    public Double calcularPreco() {
        return super.calcularPreco();
    }

    public Double calcularTeorAlcoolico(Double teorAlcoolico, Integer qtdMls){
       return this.teorAlcoolico = (teorAlcoolico * qtdMls) / 1000;
    }

    @Override
    public String toString() {
        return """
                %s
                      Alcoolica
                Teor Alcoolico: %.2f
                Idade:          %d
                Pais de Origem: %s
                """.formatted(teorAlcoolico, idade, paisDeOrigem);
    }
}
