public class Confronto {

    public Confronto() {
    }

    public void lutar(Heroi h, Vilao v){
        Double poderHeroi = h.getForcaTotal();
        Double poderVilao = v.getForcaTotal();

        if(poderVilao < poderHeroi){
            System.out.println("O heroi " + h.getCodinome()+ " venceu.");
        } else if (poderVilao > poderHeroi) {
            System.out.println("O vilão " + h.getCodinome()+ " venceu.");
        } else if (poderVilao == poderHeroi) {
            System.out.println("Houve um empate. Os dois cairam no chão.");
        }
    }
}
