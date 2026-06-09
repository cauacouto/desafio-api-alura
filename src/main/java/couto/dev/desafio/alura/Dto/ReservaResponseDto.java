package couto.dev.desafio.alura.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import couto.dev.desafio.alura.Enum.statusReserva;

import java.time.LocalDateTime;
import java.util.UUID;

public record ReservaResponseDto(
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataInicio,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataFim,
        Integer salaId,
        UUID usuarioId,
        statusReserva status

) {
}
