package bebida.naoAlcoolica;

public class NaoAlcoolica extends Bebida{
    private String sabor;
    private Double volume;

    public NaoAlcoolica(String nome, String marca, Double preco, String tipo, String sabor, Double volume) {
        super(nome, marca, preco, tipo);
        this.sabor = sabor;
        this.volume = volume;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return """
                %s
                      Nao Alcoolica
                Sabor: %s
                Volume: %s
                """.formatted(super.toString(), sabor, volume);
    }
}
