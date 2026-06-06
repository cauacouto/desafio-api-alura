package couto.dev.desafio.alura.repository;

import couto.dev.desafio.alura.domin.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepository extends JpaRepository<Sala,Integer> {
}
