import produto.ProdutoNacional;

public class Main {
    public static void main(String[] args) {
        ProdutoNacional p = new ProdutoNacional("1234", "iPhone", "Aparelho celular", 5000.0, 50, "Celular","Sao Paulo");
        p.getQuantidade();
        p.getPreco();
        p.calcularPrecoTotal();
        p.calcularPrecoUnitario();
        p.toString();
    }
}