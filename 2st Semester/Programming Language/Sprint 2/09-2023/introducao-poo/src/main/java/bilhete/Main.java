package bilhete;

public class Main {
    public static void main(String[] args){
        //Instanciar = Criar um objeto
        BilheteUnico bilhete = new BilheteUnico();
        bilhete.nomeTitular = "Michael";
        bilhete.saldo = 0.00;
        bilhete.carregar(10.0);

        BilheteUnico bilhete1 = new BilheteUnico();
        bilhete1.nomeTitular = "Lisandra";
        bilhete1.saldo = 0.0;
        bilhete1.carregar(50.0);
    }
}
