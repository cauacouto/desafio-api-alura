package couto.dev.desafio.alura.Mapper;

import couto.dev.desafio.alura.Dto.ReservaRequestDto;
import couto.dev.desafio.alura.Dto.ReservaResponseDto;
import couto.dev.desafio.alura.domin.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservaMapper {


  @Mapping(target = "dataInicio",source = "dataInicio")
  @Mapping(target = "dataFim",source = "dataFim")
  @Mapping(target = "usuario",source = "usuario.id")
  @Mapping(target = "sala",source = "sala.id")
  @Mapping(target = "statusReserva",source = "status")

  ReservaResponseDto toDto(Reserva entity);


  Reserva toEntity(ReservaRequestDto dto);


}
