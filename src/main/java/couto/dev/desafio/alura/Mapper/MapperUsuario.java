package couto.dev.desafio.alura.Mapper;

import couto.dev.desafio.alura.Dto.UsuarioRequestDto;
import couto.dev.desafio.alura.Dto.UsuarioResponseDto;
import couto.dev.desafio.alura.domin.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MapperUsuario {

     @Mapping(target = "usuarioId",source = "usuario.id")
    UsuarioResponseDto toDto(Usuario usuario);

    Usuario toEntity(UsuarioRequestDto dto);
}
