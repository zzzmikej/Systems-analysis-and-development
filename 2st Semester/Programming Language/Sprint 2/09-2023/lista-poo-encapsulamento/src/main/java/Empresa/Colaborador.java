package Empresa;

public class Colaborador {
    String nome;
    String cargo;
    Double salario;

    public Colaborador(String nome, String cargo, Double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public void exibirDados(){
        System.out.printf("" +
                "*==============================================*\n" +
                "* Nome:    %s\n" +
                "* Cargo Atual: %s\n" +
                "* Salario Atual: %.2f\n" +
                "*==============================================*\n",nome, cargo, salario);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}