import java.util.ArrayList;
import java.util.List;

public class ControleAlunos {

    List<Aluno> alunos = new ArrayList<>();
    FilaObj<Aluno> alunosMatricular = new FilaObj<>(10);
    PilhaObj<Integer> pilhaDesfazer = new PilhaObj<>(10);
    PilhaObj<Integer> pilhaRefazer = new PilhaObj<>(10);

    // relat
    private String[] categoriaAlunos = {"Prouni", "Enem"};
    private double[][] matrizRelatorio = {{8.0, 7.5, 9.0}, {6.5, 7.0, 8.0}};
    private double[] mediaColuna = new double[matrizRelatorio[0].length];
    private double[] mediaLinha = new double[matrizRelatorio.length];

    public void exibirAlunos(){
        for (Aluno a: alunos) {
            System.out.println("""
                    Nome: %s
                    Matrícula: %s
                    Nota Final: %.2f
                    """.formatted(a.getNome(), a.getRa(), a.getNotaFinal()));
        }
    }

    public void matricular(Aluno aluno){
        alunos.add(aluno);
        System.out.println("Aluno adicionado");
    }

    public void agendarMatricula(Aluno aluno){
        alunosMatricular.insert(aluno);
        System.out.println("Agendamento realizado");
    }

    public void executarAgendamento(int qtd){

        if(alunosMatricular.getTamanho() >= qtd){
            for(int i = 0; i < qtd; i++){
                matricular(alunosMatricular.poll());
                System.out.println("Matrícula realizada");
            }
        }
    }

    public void somarPontos(int pontosSomar) {
        for (Aluno a : alunos) {
            double novaNota = a.getNotaFinal() + pontosSomar;
            a.setNotaFinal(Math.min(novaNota, 10.0));
            System.out.println("Pontos somados");
        }
        pilhaDesfazer.push(pontosSomar);
    }

    public void tirarPontos(int pontosTirar) {
        for (Aluno a : alunos) {
            double novaNota = a.getNotaFinal() - pontosTirar;
            a.setNotaFinal(Math.max(novaNota, 0.0));
            System.out.println("Pontos subtraídos");
        }
    }

    public void desfazerSomarPontos(){
        if(!pilhaDesfazer.isEmpty()){
            tirarPontos(pilhaDesfazer.getTopo());
            pilhaRefazer.push(pilhaDesfazer.pop());
            System.out.println("Desfazer pontos");
        }
    }

    public void refazerSomarPontos(){
        if(!pilhaRefazer.isEmpty()){
            somarPontos(pilhaRefazer.getTopo());
            pilhaDesfazer.push(pilhaRefazer.pop());
            System.out.println("Refazer pontos");
        }
    }

    public int calculaCapacidadeDaMatriz(){
        return matrizRelatorio.length * matrizRelatorio[0].length;
    }

    public Aluno[] vetorDeItensDaFila(int qtd){
        Aluno[] vetor = new Aluno[qtd];

        if (!alunosMatricular.isEmpty() && alunosMatricular.getTamanho() >= qtd) {
            for (int i = 0; i < qtd; i++) {
                vetor[i] = alunosMatricular.poll();
            }
        }else{
            System.out.println("Não há alunos suficientes para a operação");
        }
        return vetor;
    }

    public double[] obterMediaLinha() {
        for (int i = 0; i < matrizRelatorio.length; i++) {
            mediaLinha[i] = (matrizRelatorio[i][0] + matrizRelatorio[i][1] + matrizRelatorio[i][2]) / 3;
        }
        return mediaLinha;
    }

    public double[] obterMediaColuna() {
        for (int j = 0; j < matrizRelatorio[0].length; j++) {
            double soma = 0;

            for (int i = 0; i < matrizRelatorio.length; i++) {
                soma += matrizRelatorio[i][j];
            }
            mediaColuna[j] = soma / matrizRelatorio.length;
        }
        return mediaColuna;
    }

    public void exibirRelatorio() {
        mediaLinha = obterMediaLinha();
        mediaColuna = obterMediaColuna();

        System.out.printf("%-12s %-10s %-10s %-10s %-10s\n", "CATEGORIA", "JANEIRO", "FEVEREIRO", "MARÇO", "MEDIA");

        for (int i = 0; i < matrizRelatorio.length; i++) {
            System.out.printf("%-12s %-10.2f %-10.2f %-10.2f %-10.2f\n", categoriaAlunos[i], matrizRelatorio[i][0], matrizRelatorio[i][1], matrizRelatorio[i][2], mediaLinha[i]);
        }

        System.out.printf("%-12s %-10.2f %-10.2f %-10.2f\n", "MEDIA", mediaColuna[0], mediaColuna[1], mediaColuna[2]);

    }

    public void exibirAgendamento() {
        alunosMatricular.exibe();
    }
}
