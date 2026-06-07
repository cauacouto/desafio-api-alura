package couto.dev.desafio.alura.Mapper;

import couto.dev.desafio.alura.Dto.SalaRequestDto;
import couto.dev.desafio.alura.Dto.SalaResponseDto;
import couto.dev.desafio.alura.domin.Sala;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SalaMapper {


  @Mapping(target = "nomeSala",source = "nomeSala")
  SalaResponseDto toDto(Sala entity);


  Sala toEntity(SalaRequestDto dto);


}
