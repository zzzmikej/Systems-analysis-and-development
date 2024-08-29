package school.sptech.atividaderelacionamento.service.tarefa;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.atividaderelacionamento.entity.projeto.Projeto;
import school.sptech.atividaderelacionamento.entity.tarefa.Tarefa;
import school.sptech.atividaderelacionamento.repository.tarefa.TarefaRepository;
import school.sptech.atividaderelacionamento.service.projeto.ProjetoService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TarefaService {
    private final TarefaRepository repository;
    private final ProjetoService projetoService;

    public List<Tarefa> listarTarefas() {
        return repository.findAll();
    }

    public Tarefa buscarTarefaPorId(Integer id) {
       return repository.findById(id).orElseThrow(
               () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
       );
    }

    public Tarefa salvarTarefa(Tarefa tarefa, Integer idProjeto) {
        Projeto projeto = projetoService.buscarProjetoPorId(idProjeto);
        tarefa.setProjeto(projeto);
        return repository.save(tarefa);

    }
}
