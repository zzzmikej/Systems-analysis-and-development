import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        ControleAlunos controleAlunos = new ControleAlunos();

        System.out.println("-- Adicionar Aluno --");
        controleAlunos.matricular(new Aluno("João", "123", 8.0));
        controleAlunos.matricular(new Aluno("Maria", "456", 7.5));
        controleAlunos.matricular(new Aluno("José", "789", 6.5));
        controleAlunos.matricular(new Aluno("Ana", "101", 9.0));

        System.out.println();
        System.out.println("-- Alunos Matriculados --");
        controleAlunos.exibirAlunos();

        System.out.println();
        System.out.println("-- Agendar Matrícula --");
        controleAlunos.agendarMatricula(new Aluno("Carlos", "202", 7.0));
        controleAlunos.agendarMatricula(new Aluno("Mariana", "303", 8.5));
        controleAlunos.agendarMatricula(new Aluno("Pedro", "404", 6.0));

        System.out.println();
        System.out.println("-- Visualizar Agendamento --");
        controleAlunos.exibirAgendamento();

        System.out.println();
        System.out.println("-- Executar Agendamento --");
        controleAlunos.executarAgendamento(2);

        System.out.println();
        System.out.println("-- Alunos Matriculados --");
        controleAlunos.exibirAlunos();

        System.out.println();
        System.out.println("-- Visualizar Agendamento --");
        controleAlunos.exibirAgendamento();

        System.out.println();
        System.out.println("-- Somar Pontos --");
        controleAlunos.somarPontos(2);

        System.out.println();
        System.out.println("-- Alunos Matriculados --");
        controleAlunos.exibirAlunos();

        System.out.println();
        System.out.println("-- Desfazer Somar Pontos --");
        controleAlunos.desfazerSomarPontos();

        System.out.println();
        System.out.println("-- Alunos Matriculados --");
        controleAlunos.exibirAlunos();

        System.out.println();
        System.out.println("-- Refazer Somar Pontos --");
        controleAlunos.refazerSomarPontos();

        System.out.println();
        System.out.println("-- Alunos Matriculados --");
        controleAlunos.exibirAlunos();

        System.out.println();
        System.out.println("-- Subtrair Pontos --");
        controleAlunos.tirarPontos(3);

        System.out.println();
        System.out.println("-- Alunos Matriculados --");
        controleAlunos.exibirAlunos();

        System.out.println();
        System.out.println("-- Relatório --");
        controleAlunos.exibirRelatorio();

        System.out.println();
        System.out.println("-- Capacidade Máxima --");
        System.out.println(controleAlunos.calculaCapacidadeDaMatriz());

        System.out.println();
        System.out.println("-- Vetor de Alunos --");
        System.out.println(Arrays.stream(controleAlunos.vetorDeItensDaFila(1)).toList());
    }
}
