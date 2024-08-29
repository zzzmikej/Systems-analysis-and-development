package sptechschool.crudsimples.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptechschool.crudsimples.entity.Livro;
import sptechschool.crudsimples.service.LivroService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService service;

    @GetMapping
    public ResponseEntity<List<Livro>> listar() {
        List<Livro> livros = service.list();

        if (livros.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable int id) {
        Livro livro = service.byId(id);
        return ResponseEntity.ok();
    }

    @GetMapping("/titulo")
    public ResponseEntity<List<Livro>> buscaPorTitulo(@RequestParam String titulo) {
        List<Livro> livros = livroRep.findByTituloContainsIgnoreCase(titulo);

        if (livros.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(livros);
    }

    @GetMapping("/data")
    public ResponseEntity<List<Livro>> buscaPorDataPublicacao(@RequestParam("dataPublicacao") LocalDate dataPublicacao) {
        List<Livro> livros = livroRep.findByDataPublicacaoAfter(dataPublicacao);

        if (livros.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(livros);
    }
    @GetMapping("/data/titulo")
    public ResponseEntity<List<Livro>> buscaPorDataPublicacaoEParcialTitulo(
            @RequestParam("dataInicial") LocalDate dataInicial,
            @RequestParam("dataFinal") LocalDate dataFinal,
            @RequestParam("titulo") String titulo
    ) {
        List<Livro> livros = livroRep.findByDataPublicacaoBetweenAndTituloContainsIgnoreCase(dataInicial, dataFinal, titulo);

        if (livros.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(livros);
    }

    @GetMapping("/livros/soma")
    public ResponseEntity<Double> somaDosPrecos() {
        List<Livro> livros = livroRep.findAll();

        Double somaDosPrecos = livroRep.sumPreco();

        if (livros.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(somaDosPrecos);
    }

    @PostMapping
    public ResponseEntity<Livro> criar(@RequestBody @Valid Livro novoLivro) {
        novoLivro.setId(null);
        Livro filmeSalvo = livroRep.save(novoLivro);
        return ResponseEntity.status(201).body(filmeSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizar(
            @PathVariable int id,
            @RequestBody @Valid Livro livroAtualizado) {

        if (!livroRep.existsById(id)) {
            return ResponseEntity.status(404).build();
        }

        livroAtualizado.setId(id);
        Livro livroSalvo = livroRep.save(livroAtualizado);
        return ResponseEntity.status(200).body(livroSalvo);
    }
}