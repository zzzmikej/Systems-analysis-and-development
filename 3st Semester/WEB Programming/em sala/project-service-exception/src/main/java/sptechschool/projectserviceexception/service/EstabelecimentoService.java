package sptechschool.projectserviceexception.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sptechschool.projectserviceexception.entity.Estabelecimento;
import sptechschool.projectserviceexception.repository.EstabelecimentoRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstabelecimentoService {
    private final EstabelecimentoRepository repository;

    public List<Estabelecimento> listar() {
        return repository.findAll();
    }

    public Estabelecimento getById(Integer id) {
        Optional<Estabelecimento> estOpt = repository.findById(id);

        if(estOpt.isEmpty()){
            return null;
        }

        return estOpt.get();

    }

    public Estabelecimento create(Estabelecimento estabelecimento) {
        if (repository.existsByCnpj(estabelecimento.getCnpj())){
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        return repository.save(estabelecimento);
    }
}
