package couto.dev.desafio.alura.service;

import couto.dev.desafio.alura.Dto.ReservaRequestDto;
import couto.dev.desafio.alura.Dto.ReservaResponseDto;
import couto.dev.desafio.alura.Enum.statusReserva;
import couto.dev.desafio.alura.Mapper.ReservaMapper;
import couto.dev.desafio.alura.domin.Reserva;
import couto.dev.desafio.alura.domin.Sala;
import couto.dev.desafio.alura.domin.Usuario;
import couto.dev.desafio.alura.repository.ReservaRepository;
import couto.dev.desafio.alura.repository.SalaRepository;
import couto.dev.desafio.alura.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Duration;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final UsuarioRepository usuarioRepository;
    private final SalaRepository salaRepository;
    private final ReservaMapper reservaMapper;

    private static final Duration INTERVALO_MINIMO = Duration.ofMinutes(60);

    public ReservaResponseDto reservar(ReservaRequestDto dto, UUID usuarioId, Integer salaId) {
        validarDatas(dto);

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        Sala sala = salaRepository.findById(salaId)
                .orElseThrow(() -> new RuntimeException("Sala não encontrada"));

        verificarConflitoComIntervalo(sala, dto.dataInicio(), dto.dataFim());

        if (!sala.isAtiva()) {
            throw new IllegalArgumentException("Sala inativa");
        }

        Reserva reserva = reservaMapper.toEntity(dto);
        reserva.setDataInicio(dto.dataInicio());
        reserva.setDataFim(dto.dataFim());
        reserva.setSala(sala);
        reserva.setUsuario(usuario);
        reserva.setStatus(statusReserva.RESERVADA);

        return reservaMapper.toDto(reservaRepository.save(reserva));
    }

    private void validarDatas(ReservaRequestDto dto) {
        if (dto.dataInicio() == null || dto.dataFim() == null) {
            throw new IllegalArgumentException("Datas não podem ser nulas");
        }

        if (!dto.dataInicio().isBefore(dto.dataFim())) {
            throw new IllegalArgumentException("Data de início deve ser antes da data de fim");
        }
    }

    private void verificarConflitoComIntervalo(Sala sala, LocalDateTime dataInicio, LocalDateTime dataFim) {
        LocalDateTime dataInicioMenosIntervalo = dataInicio.minus(INTERVALO_MINIMO);
        LocalDateTime dataFimComIntervalo = dataFim.plus(INTERVALO_MINIMO);

        if (reservaRepository.temConflito(sala, dataInicioMenosIntervalo, dataFimComIntervalo)) {
            throw new IllegalStateException(
                    "A sala já possui reserva. Mínimo " + INTERVALO_MINIMO.toMinutes() + " minutos entre reservas");
        }
    }

}
