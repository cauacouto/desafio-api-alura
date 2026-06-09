package couto.dev.desafio.alura.Dto;

import couto.dev.desafio.alura.Enum.StatusSala;

public record SalaResponseDto(
        Integer salaId,
        String nomeSala,
         int capacidade,
         StatusSala statusSala
) {
}
