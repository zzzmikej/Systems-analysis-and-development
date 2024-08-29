package sptechschool.projetobidirecional.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sptechschool.projetobidirecional.dto.DiretorListagemDTO;
import sptechschool.projetobidirecional.dto.DiretorMapper;
import sptechschool.projetobidirecional.dto.FilmeMapper;
import sptechschool.projetobidirecional.entity.Diretor;
import sptechschool.projetobidirecional.service.DiretorService;

import java.util.List;

@RestController
@RequestMapping("/diretor")
@RequiredArgsConstructor
public class DiretorController {

    private final DiretorService service;

    @GetMapping
    public ResponseEntity<List<DiretorListagemDTO>> list(){
        List<Diretor> diretores = service.list();

        if (diretores.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(DiretorMapper.toDTO(diretores));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiretorListagemDTO> byId(@PathVariable Integer id){
        Diretor diretor = service.byId(id);

        return ResponseEntity.ok(FilmeMapper.toDto(diretor));
    }
}
