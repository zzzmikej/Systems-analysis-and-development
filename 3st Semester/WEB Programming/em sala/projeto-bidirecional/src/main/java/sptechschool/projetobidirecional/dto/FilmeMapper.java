package sptechschool.projetobidirecional.dto;

import sptechschool.projetobidirecional.entity.Diretor;
import sptechschool.projetobidirecional.entity.Filme;

import java.util.List;

public class FilmeMapper {
    public static FilmeListagemDTO toDto(Filme entity) {
        if (entity == null) return null;

        FilmeListagemDTO filmeDTO = new FilmeListagemDTO();

        filmeDTO.setId(entity.getId());
        filmeDTO.setTitle(entity.getTitle());

        filmeDTO.setDiretor(toDiretorDto(entity.getDiretor()));
        return filmeDTO;
    }

    private static FilmeListagemDTO.DiretorDTO toDiretorDto(Diretor entity){
        if (entity == null) return null;

        FilmeListagemDTO.DiretorDTO diretorDTO = new FilmeListagemDTO.DiretorDTO();
        diretorDTO.setId(entity.getId());
        diretorDTO.setName(entity.getName());

        return diretorDTO;
    }

    public static List<FilmeListagemDTO> toDto(List<Filme> entities){
        return entities.stream().map(FilmeMapper::toDto).toList();
    }

    public static FilmeCriaçãoDTO create(Filme entity){

    }
}
