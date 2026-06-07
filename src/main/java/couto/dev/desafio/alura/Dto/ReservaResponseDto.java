package couto.dev.desafio.alura.Dto;

import couto.dev.desafio.alura.Enum.statusReserva;

import java.time.LocalDateTime;
import java.util.UUID;

public record ReservaResponseDto(
        LocalDateTime dataInicio,
        LocalDateTime dataFim,
        Integer SalaId,
        UUID UsuarioId,
        statusReserva status

) {
}
