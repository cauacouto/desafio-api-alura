package couto.dev.desafio.alura.Mapper;

import couto.dev.desafio.alura.Dto.ReservaRequestDto;
import couto.dev.desafio.alura.Dto.ReservaResponseDto;
import couto.dev.desafio.alura.domin.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservaMapper {



  @Mapping(target = "salaId",source = "sala.id")
  @Mapping(target = "usuarioId",source = "usuario.id")
  ReservaResponseDto toDto(Reserva entity);


  Reserva toEntity(ReservaRequestDto dto);


}
