public class Pedido {
    
    // atributos
    private Integer numero;
    private String mesa;
    private Double valor;
    private String lanche;
    private String bebida;

    // construtor
    public Pedido(Integer numero, String mesa, Double valor, String lanche, String bebida) {
        this.numero = numero;
        this.mesa = mesa;
        this.valor = valor;
        this.lanche = lanche;
        this.bebida = bebida;
    }
    
    // metodos
    public  void exibirPedido(){
        System.out.printf("*===================================*\n" +
                           "*               Pedido              *\n" +
                           "*===================================*\n"+
                           "* Numero: %d                        \n" +
                           "* Mesa: %s                          \n" +
                           "* Lanche: %s                        \n" +
                           "* Bebida: %s                        \n" +
                           "*===================================*\n" +
                           "* Valor: %.2f                       \n", numero, mesa, lanche, bebida, valor);
    }
    // get set
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getlanche() {
        return lanche;
    }

    public void setlanche(String lanche) {
        this.lanche = lanche;
    }

    public String getBebida() {
        return bebida;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }

    //toString

}
