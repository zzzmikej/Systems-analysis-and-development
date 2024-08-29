public class Zap {
    public static void main(String[] args) {
        Contato contato1 = new Contato("Michael", "11955777482");
        Contato contato2 = new Contato("Lis", "11912345678");
        Contato contato3 = new Contato("Marcos", "11911234567");

        Grupo grupoDoFut = new Grupo("Grupo do Fut");
        grupoDoFut.adicionar(contato1);
        grupoDoFut.adicionar(contato3);

        Grupo grupoDoDota = new Grupo("Dotinha");
        grupoDoDota.adicionar(contato1);
        grupoDoDota.adicionar(contato2);
        grupoDoDota.adicionar(contato3);

        System.out.println(grupoDoDota);
    }
}