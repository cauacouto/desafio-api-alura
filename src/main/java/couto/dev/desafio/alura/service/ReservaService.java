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

@Service
@RequiredArgsConstructor
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final UsuarioRepository usuarioRepository;
    private final SalaRepository salaRepository;
    private final ReservaMapper reservaMapper;

    public ReservaResponseDto reservar(ReservaRequestDto dto){

        Usuario usuario = usuarioRepository.findById(dto.UsuarioId())
                .orElseThrow(()-> new RuntimeException("usuario não encontrado"));

        Sala sala = salaRepository.findById(dto.SalaId())
                .orElseThrow(()-> new RuntimeException("sala não encontrado"));

        if (dto.dataInicio().isAfter(dto.dataFim()) || dto.dataInicio().equals(dto.dataFim())){
            throw new IllegalArgumentException("A data/hora de início deve ocorrer antes da data/hora de fim.");
        }
        Reserva reserva = reservaMapper.toEntity(dto);
        reserva.setDataInicio(dto.dataInicio());
        reserva.setDataFim(dto.dataFim());
        reserva.VerificarSala();
        reserva.setSala(sala);
        reserva.setUsuario(usuario);
        reserva.setStatus(statusReserva.ATIVO);
        var salvarReserva = reservaRepository.save(reserva);
        return reservaMapper.toDto(salvarReserva);
    }


}
