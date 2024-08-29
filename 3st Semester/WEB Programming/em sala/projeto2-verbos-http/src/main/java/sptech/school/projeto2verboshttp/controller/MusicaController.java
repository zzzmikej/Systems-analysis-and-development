package sptech.school.projeto2verboshttp.controller;

import org.springframework.web.bind.annotation.*;
import sptech.school.projeto2verboshttp.Musica;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/musica")
public class MusicaController {
    private ArrayList<Musica> musicas = new ArrayList<>();

    @GetMapping
    public ArrayList<Musica> listar(){
        return musicas;
    }

    @GetMapping("/buscarIndice/{indice}")
    public Musica buscarIndice(@PathVariable Integer indice){
        if(indice >= 0 && indice < musicas.size()){
            return this.musicas.get(indice);
        }
        return null;
    }

    @PostMapping
    public Musica cadastrar(@RequestBody Musica novaMusica){
        this.musicas.add(novaMusica);
        return novaMusica;
    }

    @DeleteMapping("/{indice}")
    public String remover(@PathVariable int indice){
        if(indice >= 0 && indice < musicas.size()){
            this.musicas.remove(indice);
            return "Musica  foi removida";
        }
        return "Musica nao encontrada";
    }
}
