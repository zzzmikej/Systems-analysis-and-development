package school.sptech.projetojpadto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.projetojpadto.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
