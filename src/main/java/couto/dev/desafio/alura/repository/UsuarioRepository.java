package couto.dev.desafio.alura.repository;

import couto.dev.desafio.alura.domin.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
}
