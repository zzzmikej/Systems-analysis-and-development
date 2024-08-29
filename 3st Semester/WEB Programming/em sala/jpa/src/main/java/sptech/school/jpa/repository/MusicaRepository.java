package sptech.school.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.school.jpa.Musica;

import java.util.UUID;

public interface MusicaRepository extends JpaRepository<Musica, UUID> {
}
