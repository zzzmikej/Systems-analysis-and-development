public class Heroi extends Personagem {

    public Heroi(String codinome, String nome) {
        super(codinome, nome);
    }

    @Override
    public Double getForcaTotal() {
        Double valorTotal = 0.0;
        for (int i = 0; i < getPoderes().size(); i++) {
                valorTotal += getPoderes().get(i).getCategoria();
        }
        
        return valorTotal * 1.15;
    }

    @Override
    public String toString() {
        return "Heroi{}";
    }
}
