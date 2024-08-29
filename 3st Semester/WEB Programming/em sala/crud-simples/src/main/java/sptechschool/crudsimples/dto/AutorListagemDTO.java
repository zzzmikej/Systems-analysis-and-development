package sptechschool.crudsimples.dto;

import lombok.Data;

import java.util.List;

@Data
public class AutorListagemDTO {
    private Integer id;
    private String nome;
    private String nacionalidade;
    private List<LivroDto> livro;

    @Data
    public static class LivroDto{
        private Integer id;
        private String titulo;
    }
}
