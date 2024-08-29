package sptechschool.projetobidirecional.dto;

import lombok.Data;

import java.util.List;

@Data
public class DiretorListagemDTO {
    private Integer id;
    private String name;
    private List<FilmeDto> filmes;

    // NESTED CLASS
    @Data
    public static class FilmeDto{
        private Integer id;
        private String title;
    }
}
