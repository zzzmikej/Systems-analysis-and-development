public class Main {
    public static void main(String[] args){
        Pedido pedido01 = new Pedido(123, "1", 25.0, "Big Mac", "Coca-Cola Zero");
        Pedido pedido02 = new Pedido(321, "2", 50.0, "Whopper Jr.", "Guaraná Antartica");

        Lanchonete lanchonete01 = new Lanchonete("COBOL FOOD");

        pedido01.exibirPedido();
        pedido02.exibirPedido();

        lanchonete01.prepararPedido(pedido01);

        lanchonete01.exibirRelatorio();
    }
}
