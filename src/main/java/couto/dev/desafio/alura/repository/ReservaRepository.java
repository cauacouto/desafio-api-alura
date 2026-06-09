package couto.dev.desafio.alura.repository;

import couto.dev.desafio.alura.domin.Reserva;
import couto.dev.desafio.alura.domin.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface ReservaRepository extends JpaRepository<Reserva,Integer> {

    @Query("select count(r) > 0 from Reserva r " +
            "where r.sala = :sala and r.status = 'RESERVADA' " +
            "and r.dataInicio < :dataFimComIntervalo and r.dataFim > :dataInicioMenosIntervalo")
    boolean temConflito(@Param("sala") Sala sala,
                        @Param("dataInicioMenosIntervalo") LocalDateTime dataInicioMenosIntervalo,
                        @Param("dataFimComIntervalo") LocalDateTime dataFimComIntervalo);

}
