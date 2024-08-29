package Empresa;

public class RecursosHumanos {

    private Integer totalPromovidos;
    private Integer totalReajutados;

    public RecursosHumanos() {
        this.totalPromovidos = 0;
        this.totalReajutados = 0;
    }

    public void reajustarSalario(Colaborador colaborador, Double reajuste){
        colaborador.setSalario(colaborador.getSalario() + reajuste);
        totalReajutados++;
    }

    public void promoverColaborador(Colaborador colaborador, String cargo, Double salario){

        if (salario <= colaborador.getSalario()){
            System.out.println("Operação inválida!");
        } else {
            colaborador.setCargo(cargo);
            colaborador.setSalario(salario);
            totalPromovidos++;
        }
    }
    public void exibirInfosRH(){
        System.out.printf("" +
                "*==============================================*\n" +
                "* \n" +
                "* Total de promovidos: %d\n" +
                "* Total de salrios reajustados: %d\n" +
                "*==============================================*\n", totalPromovidos, totalReajutados);
    }
}
