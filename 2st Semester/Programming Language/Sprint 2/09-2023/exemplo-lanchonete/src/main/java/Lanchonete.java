public class Lanchonete {

    private String nome;
    private Integer qtdVendida;
    private Double totalVendido;

    public Lanchonete(String nome) {
        this.nome = nome;
        this.qtdVendida = 0;
        this.totalVendido = 0.0;
    }

    public void exibirRelatorio(){
        System.out.printf(
                "*===================================*\n" +
                "*                                   \n" +
                "*                %s                 \n" +
                "*===================================*\n" +
                "*Quantidade de pedidos  feitos: %d\n" +
                "*-----------------------------------*\n" +
                "*                                   *\n" +
                "*-----------------------------------*\n" +
                "* Total Vendido:              R$%.2f\n" +
                "*===================================*\n",
                nome, qtdVendida, totalVendido);
    }

    public void prepararPedido(Pedido pedido){
        System.out.println("Preparando Pedido...\n");
        pedido.exibirPedido();
        qtdVendida++;
        totalVendido += pedido.getValor();

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtdVendida() {
        return qtdVendida;
    }

    public Double getTotalVendido() {
        return totalVendido;
    }
}

