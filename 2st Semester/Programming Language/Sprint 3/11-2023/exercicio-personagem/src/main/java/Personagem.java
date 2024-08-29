import java.util.ArrayList;
import java.util.List;

public abstract clasPersonagem {

    private String codinome;
    private String nome;
    private List<SuperPoder> poderes;

    public Personagem(String codinome, String nome) {
        this.codinome = codinome;
        this.nome = nome;
        this.poderes = new ArrayList<>();
    }

    public void adicionaPoder(String nome, Integer categoria){
        SuperPoder nomePoder = new SuperPoder(nome,categoria);
        poderes.add(nomePoder);
    }

    public abstract Double getForcaTotal();

    public String getCodinome() {
        return codinome;
    }

    public String getNome() {
        return nome;
    }

    public List<SuperPoder> getPoderes() {
        return poderes;
    }

    @Override
    public String toString() {
        return """
                *================================*
                * Nome:            %s
                * Codinome:        %s
                * Poderes:         %s
                *================================*
                """.formatted(this.nome, this.codinome,this.getPoderes());
    }
}
