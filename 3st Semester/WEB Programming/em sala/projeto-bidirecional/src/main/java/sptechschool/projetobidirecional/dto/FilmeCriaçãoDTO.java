package sptechschool.projetobidirecional.dto;

import lombok.Data;

@Data
public class FilmeCriaçãoDTO {
    private String title;
    private DiretorDTO diretor;

    @Data
    public static class DiretorDTO{
        private Integer id;
    }
}
