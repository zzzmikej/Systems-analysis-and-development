public class Aluno {

    private String nome;
    private String ra;
    private Double notaFinal;

    public Aluno(String nome, String ra, Double notaFinal) {
        this.nome = nome;
        this.ra = ra;
        this.notaFinal = notaFinal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public Double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Double notaFinal) {
        this.notaFinal = notaFinal;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", ra='" + ra + '\'' +
                ", notaFinal=" + notaFinal +
                '}';
    }
}
