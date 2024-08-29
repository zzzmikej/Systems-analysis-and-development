package school.sptech.atividaderelacionamento.controller.projeto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.atividaderelacionamento.dto.projeto.ProjetoCriacaoDto;
import school.sptech.atividaderelacionamento.dto.projeto.ProjetoListagemDto;
import school.sptech.atividaderelacionamento.dto.projeto.ProjetoMapper;
import school.sptech.atividaderelacionamento.entity.projeto.Projeto;
import school.sptech.atividaderelacionamento.service.projeto.ProjetoService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projetos")
@RequiredArgsConstructor
public class ProjetoController {

    private final ProjetoService projetoService;


    @GetMapping
    public ResponseEntity<List<ProjetoListagemDto>> listarProjetos() {
        List<Projeto> projetos = projetoService.listarProjetos();

        if (projetos.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(ProjetoMapper.toDto(projetos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoListagemDto> buscarProjeto(@PathVariable Integer id) {
       Projeto projeto = projetoService.buscarProjetoPorId(id);
       return ResponseEntity.ok(ProjetoMapper.toDto(projeto));
    }

    @PostMapping
    public ResponseEntity<ProjetoListagemDto> criarProjeto(@RequestBody @Valid ProjetoCriacaoDto projetoCriacaoDto) {
        Projeto projetoEntity = ProjetoMapper.toEntity(projetoCriacaoDto);

        ProjetoListagemDto dto = ProjetoMapper.toDto(projetoEntity);

        URI uri = URI.create("/pojetos/" + dto.getId());

        return ResponseEntity.created(uri).body(dto);

    }
}
