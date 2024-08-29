public class Bolo {

    private String sabor;
    private Double valor;
    private Integer qtdVendida;

    public Bolo(String sabor, Double valor, Integer qtdVendida){
        this.sabor = sabor;
        this.valor = valor;
        this.qtdVendida = qtdVendida;
    }

    void exibirRelatorio(){
        double totalVendas = qtdVendida * valor;
        System.out.printf("O bolo de sabor %s, foi comprado %d vezes hoje, totalizando R$ %.2f",sabor, qtdVendida,
                totalVendas);
    }

    void comprarBolo(Integer qtdDesejada){
        if ((qtdDesejada + qtdVendida) > 100){
            System.out.println("Seu pedido ultrapassou nosso limite de diario de bolo");
        } else {
            System.out.println("Compra realizada!!");
        }
    }

    public Double getValor() {
        return valor;
    }

    public Integer getQtdVendida() {
        return qtdVendida;
    }

    public void setQtdVendida(Integer qtdVendida) {
        this.qtdVendida = qtdVendida;
    }

    //set: mudar valor
    //get: pegar valor
    public void setSabor(String novoSabor){
        sabor = novoSabor;
    }
}
