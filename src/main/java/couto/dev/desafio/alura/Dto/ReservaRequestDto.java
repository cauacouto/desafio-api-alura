package couto.dev.desafio.alura.Dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record ReservaRequestDto(
        LocalDateTime dataInicio,
        LocalDateTime dataFim,
        Integer SalaId,
        UUID UsuarioId



) {
}
