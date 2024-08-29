package sptechschool.projetobidirecional.dto;

import sptechschool.projetobidirecional.entity.Diretor;
import sptechschool.projetobidirecional.entity.Filme;

import java.util.List;

public class DiretorMapper {
    public static DiretorListagemDTO toDTO(Diretor entity){
        if (entity == null) return null;

        DiretorListagemDTO diretorDTO = new DiretorListagemDTO();

        diretorDTO.setId(entity.getId());
        diretorDTO.setName(entity.getName());

        diretorDTO.setFilmes(toFilmeDTO(entity.getFilmes()));

        return diretorDTO;
    }

    public static List<DiretorListagemDTO.FilmeDto> toFilmeDTO(List<Filme> entities){
        return entities.stream().map(f -> {
            DiretorListagemDTO.FilmeDto dto = new DiretorListagemDTO.FilmeDto();
            dto.setId(f.getId());
            dto.setTitle(f.getTitle());

            return dto;
        }).toList();
    }

    public static List<DiretorListagemDTO> toDTO(List<Diretor> entities) {
        return entities.stream().map(DiretorMapper::toDTO).toList();
    }
}
