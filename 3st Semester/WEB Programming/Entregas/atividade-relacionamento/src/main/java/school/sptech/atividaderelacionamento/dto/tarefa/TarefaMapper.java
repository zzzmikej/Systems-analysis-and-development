package school.sptech.atividaderelacionamento.dto.tarefa;

import school.sptech.atividaderelacionamento.entity.projeto.Projeto;
import school.sptech.atividaderelacionamento.entity.tarefa.Tarefa;

import java.util.List;

public class TarefaMapper {

    public static TarefaListagemDto toDto(Tarefa entity) {
        if (entity == null) return null;

        TarefaListagemDto tarefaDto = new TarefaListagemDto();

        tarefaDto.setId(entity.getId());
        tarefaDto.setNome(entity.getNome());
        tarefaDto.setDescricao(entity.getDescricao());
        tarefaDto.setConcluida(entity.getConcluida());
        tarefaDto.setPrioridade(entity.getPrioridade());
        tarefaDto.setProjeto(toProjetoDto(entity.getProjeto()));

        return tarefaDto;
    }

    public static TarefaListagemDto.ProjetoListagemDto toProjetoDto(Projeto entity) {
        if (entity == null) return null;

        TarefaListagemDto.ProjetoListagemDto projetoDto = new TarefaListagemDto.ProjetoListagemDto();

        projetoDto.setId(entity.getId());
        projetoDto.setNome(entity.getNome());
        projetoDto.setDescricao(entity.getDescricao());
        projetoDto.setDataInicio(entity.getDataInicio());
        projetoDto.setDataFim(entity.getDataFim());

        return projetoDto;

    }

    public static List<TarefaListagemDto> toDto(List<Tarefa> entities) {
        return entities.stream().map(TarefaMapper::toDto).toList();
    }

    public static Tarefa toEntity(TarefaCriacaoDto dto) {
        if (dto == null) return null;

        Tarefa tarefa = new Tarefa();

        tarefa.setNome(dto.getNome());
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setPrioridade(dto.getPrioridade());

        return tarefa;
    }
}
