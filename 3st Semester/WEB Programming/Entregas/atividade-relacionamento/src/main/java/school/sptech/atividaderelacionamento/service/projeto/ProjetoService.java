package school.sptech.atividaderelacionamento.service.projeto;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.atividaderelacionamento.entity.projeto.Projeto;
import school.sptech.atividaderelacionamento.entity.tarefa.Tarefa;
import school.sptech.atividaderelacionamento.repository.projeto.ProjetoRepository;
import school.sptech.atividaderelacionamento.service.tarefa.TarefaService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProjetoService {
    private final ProjetoRepository repository;

    public List<Projeto> listarProjetos() {
        return repository.findAll();
    }

    public Projeto buscarProjetoPorId(Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    public Projeto salvarProjeto(Projeto projeto) {
        return repository.save(projeto);
    }
}
