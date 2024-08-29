package school.sptech.atividaderelacionamento.dto.projeto;

import school.sptech.atividaderelacionamento.entity.projeto.Projeto;
import school.sptech.atividaderelacionamento.entity.tarefa.Tarefa;

import java.util.List;

public class ProjetoMapper {

    public static ProjetoListagemDto toDto(Projeto entity) {
        if (entity == null) return null;

        ProjetoListagemDto projetoDto = new ProjetoListagemDto();

        projetoDto.setId(entity.getId());
        projetoDto.setNome(entity.getNome());
        projetoDto.setDescricao(entity.getDescricao());
        projetoDto.setDataInicio(entity.getDataInicio());
        projetoDto.setDataFim(entity.getDataFim());
        projetoDto.setTarefas(toTarefaDto(entity.getTarefas()));
        return projetoDto;
    }

    public static List<ProjetoListagemDto.TarefaListagemDto> toTarefaDto(List<Tarefa> entities){
        return entities.stream().map(f -> {
            ProjetoListagemDto.TarefaListagemDto dto = new ProjetoListagemDto.TarefaListagemDto();
            dto.setId(f.getId());
            dto.setNome(f.getNome());
            dto.setDescricao(f.getDescricao());
            dto.setConcluida(f.getConcluida());
            dto.setPrioridade(f.getPrioridade());

            return  dto;
        }).toList();
    }

    public static List<ProjetoListagemDto> toDto(List<Projeto> entityList) {
        return entityList.stream().map(ProjetoMapper::toDto).toList();
    }

    public static Projeto toEntity(ProjetoCriacaoDto dto) {
        if (dto == null) return null;

        Projeto projeto = new Projeto();

        projeto.setNome(dto.getNome());
        projeto.setDescricao(dto.getDescricao());
        projeto.setDataInicio(dto.getDataInicio());
        projeto.setDataFim(dto.getDataFim());

        return projeto;
    }
}
