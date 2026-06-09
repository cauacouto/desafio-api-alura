package couto.dev.desafio.alura.controller;

import couto.dev.desafio.alura.Dto.SalaRequestDto;
import couto.dev.desafio.alura.Dto.SalaResponseDto;
import couto.dev.desafio.alura.service.SalaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sala")
@RequiredArgsConstructor
public class SalaController {

    private final SalaService salaService;


    @PostMapping
    public ResponseEntity<SalaResponseDto> criarSala (@RequestBody SalaRequestDto dto){
        var request = salaService.criarSala(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(request);
    }
}
