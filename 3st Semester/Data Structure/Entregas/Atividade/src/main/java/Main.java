import produto.Alimento;

public class Main {
    public static void main(String[] args) {
        Alimento alimento = new Alimento(123, "Curintia", 0.00, 30);
        System.out.println(alimento.toString());
    }
}
