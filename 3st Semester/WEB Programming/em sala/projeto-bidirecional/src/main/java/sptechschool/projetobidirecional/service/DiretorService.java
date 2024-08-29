package sptechschool.projetobidirecional.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sptechschool.projetobidirecional.entity.Diretor;
import sptechschool.projetobidirecional.repository.DiretorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiretorService {

    private final DiretorRepository repository;

    public List<Diretor> list(){
        return repository.findAll();
    }

    public Diretor byId(Integer id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
