package sptech.school;

import java.util.Scanner;

public class Main {
    static String v1[] = new String[10];
    static String v2[] = new String[10];

    public static void main(String[] args) {
        lerAlunos(0);
    }

    public static void lerAlunos(int i){
        Scanner scanner = new Scanner(System.in);

        String nome;
        String turma;

        System.out.println("Insira o nome do aluno:");
        nome = scanner.nextLine();
        System.out.println("Insira a turma do aluno:");
        turma = scanner.nextLine();

        if ((turma.equalsIgnoreCase("T1") || turma.equalsIgnoreCase("turma 1") || turma.equalsIgnoreCase("turma1")) && !nome.isBlank()) {
            v1[i] = nome;
        } else if ((turma.equalsIgnoreCase("T2") || turma.equalsIgnoreCase("turma 2") || turma.equalsIgnoreCase("turma2")) && !nome.isBlank()) {
            v2[i] = nome;
        } else {
            System.out.println("Turma inválida! Insira novamente.");
            lerAlunos(i);
            return;
        }
        i++;
        if(i<10){
            lerAlunos(i);
        } else {
            exibirAlunos(v1, "T1");
            exibirAlunos(v2, "T2");
        }
    }

    public static void exibirAlunos(String[] alunos, String turma) {
        int i = 0;
        for (String aluno : alunos) {
            if (aluno != null) {
                i++;
            }
        }
        System.out.println("\nTurma: " + turma + " - Quantidade de Alunos: " + i);
        System.out.println("Alunos:");
        for (String aluno : alunos) {
            if (aluno != null) {
                System.out.println(aluno);
            }
        }
    }
}

//Crie um projeto chamado exercicio-turma
//Faça um algoritmo que leia os nomes de 10 alunos e de qual turma eles pertencem: "T1" ou "T2".
//O algoritmo deve criar 2 vetores, um contendo os nomes dos alunos da "T1" e o outro contendo os nomes dos alunos da "T2".
//Exiba a quantidade de alunos de cada vetor e os nomes dos alunos de cada turma no final.
//OBS.: Nâo é para utilizar List ou ArrayList. É para usar vetor mesmo!!!
//Não é para deixar "buracos" nos vetores.
//Na hora de exibir os alunos de uma turma, não é para aparecer os "nulls" do final do vetor, e tb não é para usar um "if diferente de null então printa",  dentro do for!