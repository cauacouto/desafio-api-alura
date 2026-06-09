package couto.dev.desafio.alura.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.UUID;

public record ReservaRequestDto(
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataInicio,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataFim,
        Integer SalaId,
        UUID UsuarioId



) {
}
