package school.sptech.projetointroducao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/frases")

public class FraseController {
    @GetMapping
    public String helloWorld(){
        return """
                {
                frase:Hello World
                }""";
    }
}
