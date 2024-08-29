package sptech.school.projeto2verboshttp.controller;

@RestController
@RequestMapping("/musicas")
public class MusicaController {
    private List<Musica> musicas = new ArrayList<>(List.of);
}
