package sptechschool.projetobidirecional.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sptechschool.projetobidirecional.entity.Filme;
import sptechschool.projetobidirecional.repository.FilmeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmeService {
    private final FilmeRepository repository;

    public List<Filme> list(){
        return repository.findAll();
    }

    public Filme byId(Integer id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
