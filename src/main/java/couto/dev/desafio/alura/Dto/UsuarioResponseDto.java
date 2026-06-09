package couto.dev.desafio.alura.Dto;

import java.util.UUID;

public record UsuarioResponseDto(
        UUID usuarioId,
        String nome,
        String email
) {
}
