package school.sptech.atividaderelacionamento.dto.tarefa;

import lombok.Data;
import school.sptech.atividaderelacionamento.entity.projeto.Projeto;

import java.time.LocalDate;
@Data
public class TarefaListagemDto {

    private Integer id;
    private String nome;
    private String descricao;
    private Boolean concluida;
    private String prioridade;
    private ProjetoListagemDto projeto;

    //Nested class
    @Data
    public static class ProjetoListagemDto{
        private Integer id;
        private String nome;
        private String descricao;
        private LocalDate dataInicio;
        private LocalDate dataFim;
    }

}
