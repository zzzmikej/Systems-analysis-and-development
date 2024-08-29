package bebida.alcoolica;

public class Destilado extends Alcoolica{
    private boolean destilado = false;
    public Destilado(String nome, String marca, Double preco, String tipo, int idade, String paisDeOrigem) {
        super(nome, marca, preco, tipo, idade, paisDeOrigem);
    }

    public void envelhecer(Integer tempo){
        if (tempo > 0){
            return super.idade += tempo;
        } else {
            System.out.println("""
                    Idade nao permitida
                    """);
        }
    }

    public void destilar(){
        if (destilado){
            destilado = true;
            System.out.println("""
                    A bebida foi destilada!
                    """);
        } else {
            System.out.println("""
                    A bebida ja esta destilada!
                    """);
        }
    }
}
