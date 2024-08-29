package sptech.school.dynamicfinders.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.school.dynamicfinders.entity.Filme;
import sptech.school.dynamicfinders.repository.FilmeRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository filmeRepository;

    @PostMapping
    public ResponseEntity<Filme> registration(@RequestBody Filme newMovie){
        newMovie.setId(null);
        Filme saveMovie = filmeRepository.save(newMovie);
        return ResponseEntity.status(201).body(saveMovie);
    }

    @GetMapping
    public ResponseEntity<List<Filme>> getFilms(){
        List<Filme> films = filmeRepository.findAll();

        if (films.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(films);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> getByID(@PathVariable UUID id){
        Optional<Filme> filmsOpt = filmeRepository.findById(id);

        if (filmsOpt.isPresent()){
            return ResponseEntity.status(200).body(filmsOpt.get());
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/nome")
    public ResponseEntity<List<Filme>> searchByName(@RequestParam String name){
        List<Filme> films = filmeRepository.findByNameContainingIgnoreCase(name);

        if (films.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(films);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByID(@PathVariable UUID id){
        if (filmeRepository.existsById(id)){
            filmeRepository.deleteById(id);
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filme> putByID(@PathVariable UUID id, @RequestBody @Valid Filme filmUpdated){
        if (!filmeRepository.existsById(id)){
            return ResponseEntity.status(404).build();
        }

        filmUpdated.setId(id);
        Filme filmSave = filmeRepository.save(filmUpdated);
        return ResponseEntity.status(200).body(filmSave);
    }
}
