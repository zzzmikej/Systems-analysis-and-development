package Main;

import com.github.britooo.looca.api.core.Looca;

public class Memoria {
    Looca looca = new Looca();

    public String memoria() {
        return """
                            Memoria
                Em Uso:             %s
                Disponivel:         %s
                Total:              %s
                """.formatted(looca.getMemoria().getEmUso(), looca.getMemoria().getDisponivel(), looca.getMemoria().getTotal());
    }
}
