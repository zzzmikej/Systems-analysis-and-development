package sptech.school;

import java.util.Scanner;

public class Main {
    private static boolean exit = false;

    public static void main(String[] args) {
        boolean add = false;
        int i = -1;
        Scanner scanner = new Scanner(System.in);
        while (!exit){
            System.out.println(menu());
            Integer opcao = scanner.nextInt();
            i++;
            switch (opcao) {
                case 1:
                    if (!add){
                        System.out.println("Defina o tamanho do Vetor");
                        int tamV = scanner.nextInt();
                        ListaEstatica.createVetor(tamV);
                        add = true;
                    }
                    System.out.println("Escolha um valor para inserir no vetor");
                    int num = scanner.nextInt();
                    ListaEstatica.addElement(num, i);
                    break;
                case 2:
                    ListaEstatica.showVetor(i);
                    break;
                case 3:
                    System.out.println("Coloque um número para pesquisar:");
                    int search = scanner.nextInt();
                    ListaEstatica.search(search);
                    break;
                case 4:
                    System.out.println("Indice para a exclusão");
                    int delete = scanner.nextInt();
                    ListaEstatica.removeByID(delete);
                    break;
                case 5:
                    System.out.println("Valor para a exclusão");
                    int element = scanner.nextInt();
                    ListaEstatica.removeByElement(element);
                    break;
                case 0:
                    exit = true;
                    break;
            }
        }
    }

    public static String menu(){
        return """
                ------------------------
                |         Menu         |
                ------------------------
                |1- Adicionar          |
                |2- Exibir             |
                |3- Busca              |
                |4- Remover pelo Indice|
                |5- Remover Elemento   |
                ------------------------
                """;
    }
}