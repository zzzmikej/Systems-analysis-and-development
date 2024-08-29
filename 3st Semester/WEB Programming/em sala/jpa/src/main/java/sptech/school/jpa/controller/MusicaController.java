package sptech.school.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.school.jpa.Musica;
import sptech.school.jpa.repository.MusicaRepository;

import java.util.*;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    @Autowired
    private MusicaRepository musicaRepository;

    @PostMapping
    public ResponseEntity<Musica> createMusic(@RequestBody Musica newMusic){
        return ResponseEntity.status(201).body((musicaRepository.save(newMusic)));
    }

    @GetMapping
    public ResponseEntity<List<Musica>> getList() {
        List<Musica> musicas = musicaRepository.findAll();
        if (musicas.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(musicas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Musica>> getById(@PathVariable UUID id){
        List<Musica> musicaOptional = musicaRepository.findAllById(Collections.singleton(id));

        if (musicaOptional.isEmpty()){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(musicaOptional);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id){
        if (musicaRepository.existsById(id)){
            musicaRepository.deleteById(id);
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(404).build();
    }
}
