package sptech.school.atividadeheroi.controller;

import org.apache.catalina.LifecycleState;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sptech.school.atividadeheroi.Heroi;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/herois")
public class HeroiController {

    private List<Heroi> herois = new ArrayList<>();

    @GetMapping
    public String listaHerois() {
        return """
                %s
                """.formatted(herois);
    }

    @GetMapping("/favorito")
    public Heroi favorito(){
        Heroi heroiFavorito = new Heroi("Naruto", 10000, "Rasengan", 14, true);
        herois.add(heroiFavorito);
        return herois.get(0);
    }

    @GetMapping("/{indice}")
    public Heroi buscarHeroi(@PathVariable int indice){
        if (existeHeroi(indice)){
            return herois.get(indice);
        }
        return null;
    }

    @GetMapping("/cadastrar/{nome}/{forca}/{habilidade}/{idade}/{vivo}")
    public Heroi cadastrar(@PathVariable String nome, @PathVariable int forca, @PathVariable String habilidade, @PathVariable int idade, @PathVariable boolean vivo){
        Heroi cadastrar = new Heroi(nome, forca, habilidade, idade, vivo);
        return cadastrar;
    }

    @GetMapping("/atualizar/{indice}/{nome}/{forca}/{habilidade}/{idade}/{vivo}")
    public String atualizar(@PathVariable int indice, @PathVariable String nome, @PathVariable int forca, @PathVariable String habilidade, @PathVariable int idade, @PathVariable boolean vivo){
        if (existeHeroi(indice)){
            herois.set(indice, new Heroi(nome,forca, habilidade, idade, vivo));
            return "Heroi atualizado";
        }
        return null;
    }

    @GetMapping("/remover/{indice}")
    public String remover(@PathVariable int indice){
        if (existeHeroi(indice)){
            herois.remove(indice);
            return "Heroi removido";
        }
        return "Heroi nao encotrado";
    }

    public boolean existeHeroi(int indice){
        return indice >= 0 && indice < herois.size() ? true : false;
    }
}