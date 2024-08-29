public class Vilao extends Personagem{


    public Vilao(String codinome, String nome) {
        super(codinome, nome);
    }

    @Override
    public Double getForcaTotal() {
        Double valorTotal = 0.0;
        for (int i = 0; i < getPoderes().size(); i++) {
            valorTotal += getPoderes().get(i).getCategoria();
        }

        return valorTotal;
    }
}
