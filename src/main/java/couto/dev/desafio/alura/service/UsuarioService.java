package couto.dev.desafio.alura.service;

import couto.dev.desafio.alura.Dto.UsuarioRequestDto;
import couto.dev.desafio.alura.Dto.UsuarioResponseDto;
import couto.dev.desafio.alura.Mapper.MapperUsuario;
import couto.dev.desafio.alura.domin.Usuario;
import couto.dev.desafio.alura.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final MapperUsuario mapperUsuario;


    public UsuarioResponseDto salvarUsuario(UsuarioRequestDto dto){
        Usuario usuario = mapperUsuario.toEntity(dto);
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
       var salve = usuarioRepository.save(usuario);
       return mapperUsuario.toDto(salve);
    }


}
