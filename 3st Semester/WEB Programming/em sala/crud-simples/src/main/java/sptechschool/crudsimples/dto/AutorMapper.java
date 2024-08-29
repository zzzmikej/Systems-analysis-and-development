package sptechschool.crudsimples.dto;

import sptechschool.crudsimples.entity.Autor;
import sptechschool.crudsimples.entity.Livro;

import java.util.List;

public class AutorMapper {
    public static AutorListagemDTO toDTO (Autor entity) {
        if (entity == null)return null;

        AutorListagemDTO autorDTO = new AutorListagemDTO();

        autorDTO.setId(entity.getId());
        autorDTO.setNome(entity.getNome());
        autorDTO.setNacionalidade(entity.getNacionalidade());
        autorDTO.setLivro(toLivroDTO(entity.getLivros()));

        return autorDTO;
    }

    public static List<AutorListagemDTO.LivroDto> toLivroDTO (List<Livro> entities) {
        return entities.stream().map(f -> {
            AutorListagemDTO.LivroDto dto = new AutorListagemDTO.LivroDto();
            dto.setId(f.getId());
            dto.setTitulo(f.getTitulo());
            return dto;
        }).toList();
    }
}
