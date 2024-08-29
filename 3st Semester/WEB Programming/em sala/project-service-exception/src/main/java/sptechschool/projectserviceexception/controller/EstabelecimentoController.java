package sptechschool.projectserviceexception.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sptechschool.projectserviceexception.entity.Estabelecimento;
import sptechschool.projectserviceexception.service.EstabelecimentoService;

import java.util.List;

@RestController
@RequestMapping ("/estabelecimento")
@RequiredArgsConstructor
public class EstabelecimentoController {
    private final EstabelecimentoService service;
    @GetMapping
    public ResponseEntity<List<Estabelecimento> listar(){
        List<Estabelecimento> estabelecimentos = service.listar();

        if (estabelecimentos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(estabelecimentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estabelecimento> getById(@PathVariable Integer id){
        Estabelecimento estabelecimento = service.getById(id);

        return ResponseEntity.ok(estabelecimento);
    }
}
