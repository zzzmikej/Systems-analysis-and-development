package sptech.school.dynamicfinders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.school.dynamicfinders.entity.Filme;

import java.util.List;
import java.util.UUID;

public interface FilmeRepository extends JpaRepository<Filme, UUID> {
    List<Filme> findByNameContainingIgnoreCase(String name);
    List<Filme> findByNotaGreaterThan(Double nota);

}
