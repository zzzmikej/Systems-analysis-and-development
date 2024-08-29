package bilhete;

public class BilheteUnico {
    //Atributos = Caracteristicas
    String nomeTitular;
    Double saldo;

    //Métodos = Comportamento
    void carregar(Double valorRecarga){
        System.out.printf("Saldo antes de carregar R$%.2f\n", saldo);
        saldo += valorRecarga;
        System.out.printf("Saldo após de carrega R$%.2f\n", saldo);
    }
}
