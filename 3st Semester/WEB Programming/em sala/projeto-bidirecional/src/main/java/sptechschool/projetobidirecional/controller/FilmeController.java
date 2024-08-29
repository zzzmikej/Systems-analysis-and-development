package sptechschool.projetobidirecional.controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sptechschool.projetobidirecional.dto.FilmeListagemDTO;
import sptechschool.projetobidirecional.dto.FilmeMapper;
import sptechschool.projetobidirecional.entity.Filme;
import sptechschool.projetobidirecional.service.FilmeService;

import java.util.List;

@RestController
@RequestMapping("/filmes")
@RequiredArgsConstructor
public class FilmeController {
    private final FilmeService filmeService;

    @GetMapping
    public ResponseEntity<List<FilmeListagemDTO>> list(){
        List<Filme> filmes = filmeService.list();

        if (filmes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<FilmeListagemDTO> dtos = FilmeMapper.toDto(filmes);

        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmeListagemDTO> byId(@PathVariable Integer id){
        Filme filme = filmeService.byId(id);

        return ResponseEntity.ok(FilmeMapper.toDto(filme));
    }
}
