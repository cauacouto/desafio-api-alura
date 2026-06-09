package couto.dev.desafio.alura.controller;

import couto.dev.desafio.alura.Dto.ReservaRequestDto;
import couto.dev.desafio.alura.Dto.ReservaResponseDto;
import couto.dev.desafio.alura.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/reserva")
@RequiredArgsConstructor
public class ReservaController {

    private final ReservaService reservaService;

    @PostMapping("/{salaId}/{usuarioId}")
    public ResponseEntity<ReservaResponseDto> reservar(@RequestBody ReservaRequestDto dto, @PathVariable Integer salaId,
                                                       @PathVariable UUID usuarioId){

        var request = reservaService.reservar(dto,usuarioId,salaId);
        return ResponseEntity.status(HttpStatus.CREATED).body(request);
    }
}
