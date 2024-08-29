package sptechschool.projetobidirecional.dto;

import lombok.Data;

@Data
public class FilmeListagemDTO {
    private Integer id;
    private String title;
    private DiretorDTO diretor;


    // NESTED CLASS
    @Data
    public static class DiretorDTO{
        private Integer id;
        private String name;
    }
}