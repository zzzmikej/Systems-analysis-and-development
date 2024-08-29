package sptechschool.projetobidirecional.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sptechschool.projetobidirecional.entity.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Integer> {
}