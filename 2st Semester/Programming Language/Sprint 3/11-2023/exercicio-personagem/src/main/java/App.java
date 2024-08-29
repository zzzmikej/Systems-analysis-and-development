import java.sql.SQLOutput;

public class App {

    public static void main(String[] args) {
        Heroi h = new Heroi("Papai Lebron","Lebron James.");
        h.adicionaPoder("Reverse-Dunk",10);
        h.adicionaPoder("Block",20);

        Heroi h1 = new Heroi("Pai-Presente","Jayson Tatum");
        h1.adicionaPoder("BotarPraDormir",5);
        h1.adicionaPoder("Dancar",40);

        Vilao v = new Vilao("Westbrick","Russell Westbrook");
        v.adicionaPoder("Tijolada",20);
        v.adicionaPoder("GameLooser",5);

        Vilao v1 = new Vilao("O Barba","James Harden");
        v1.adicionaPoder("StepBack",50);
        v1.adicionaPoder("CrossOver",1);

        Confronto c = new Confronto();

        System.out.println("Papai lebron x WestBrick");
        c.lutar(h,v);
        System.out.println(" ");
        System.out.println("Pai presente x O BARBA");

        System.out.println(v1.toString());
        System.out.println(h1.toString());
        c.lutar(h1,v1);



    }


}
