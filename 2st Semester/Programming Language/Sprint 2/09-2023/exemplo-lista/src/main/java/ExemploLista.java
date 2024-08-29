import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExemploLista {
    public static void main(String[] args){
        // Não é uma simples variavel
        // e sim um OBJETO
        // Criamos objetos utilizando o new

        List listaEstranha = new ArrayList();
        listaEstranha.add("Xampson");
        listaEstranha.add(42);
        listaEstranha.add(true);
        listaEstranha.add(42.2);

        System.out.println(listaEstranha);

        //Lista definindo o tipo
        List<String> nomes = new ArrayList();
        nomes.add("Xampson");
        nomes.add("Maria");
        nomes.add("José");
        nomes.add("Bob Marley");

        System.out.println(nomes);

        //Buscar posicoes
        String segundoNome = nomes.get(1);

        System.out.println(segundoNome);

        //adicionando na Lista
        Scanner add;
        add = new Scanner(System.in);

        String nome = add.next();
        nomes.add(nome);

        System.out.println(nomes);

        nomes.set(0, nome);

        System.out.println(nomes);

    }
}
