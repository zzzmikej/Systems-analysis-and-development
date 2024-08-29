package sptechschool.crudsimples.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sptechschool.crudsimples.entity.Livro;
import sptechschool.crudsimples.repository.LivroRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LivroService {
    private final LivroRepository repository;

    public List<Livro> list() {
        return repository.findAll();
    }

    public Livro byId(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
