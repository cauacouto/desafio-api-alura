package couto.dev.desafio.alura.repository;

import couto.dev.desafio.alura.domin.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva,Integer> {
}
