package Main;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.sistema.Sistema;

public class Main {
    public static void main(String[] args) {
        Looca looca = new Looca();
        Processador processador = new Processador();
        Memoria memoria = new Memoria();

        System.out.println(processador.processador());
        System.out.println(memoria.memoria());

        System.out.println(looca.getMemoria());

        Sistema sistema = looca.getSistema();

        System.out.println("Sistema: " + looca.getSistema());
        System.out.println("Disco: " + looca.getGrupoDeDiscos());
        System.out.println("Janela: " + looca.getGrupoDeJanelas());


        // System.out.println("Processos: " + looca.getProcessos());
//        System.out.println("Bateria: " + looca.getBateria());
//        System.out.println("Placa Mãe: " + looca.getPlacaMae());
//        System.out.println("Rede: " + looca.getGrupoDeInterfacesDeRede());
//        System.out.println("Sessão: " + looca.getSessao());
//        System.out.println("Temperatura: " + looca.getTemperatura());
//        System.out.println("Voltagem: " + looca.getVoltagem());

    }


}
