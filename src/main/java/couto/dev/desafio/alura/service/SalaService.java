package couto.dev.desafio.alura.service;

import couto.dev.desafio.alura.Dto.SalaRequestDto;
import couto.dev.desafio.alura.Dto.SalaResponseDto;
import couto.dev.desafio.alura.Enum.StatusSala;
import couto.dev.desafio.alura.Mapper.SalaMapper;
import couto.dev.desafio.alura.domin.Sala;
import couto.dev.desafio.alura.repository.SalaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SalaService {

    private final SalaRepository salaRepository;
    private  final SalaMapper salaMapper;

    public SalaResponseDto criarSala(SalaRequestDto dto){
        Sala sala = salaMapper.toEntity(dto);
        sala.setNomeSala(dto.nomeSala());
        sala.setStatusSala(StatusSala.ATIVA);
        if (sala.getCapacidade() <= 0){
            throw new IllegalArgumentException("sala não pode possuir capacidade menor ou igual a zero.");
        }
        sala.setCapacidade(dto.capicdade());
            var salvar = salaRepository.save(sala);
        return salaMapper.toDto(salvar);
    }

}
