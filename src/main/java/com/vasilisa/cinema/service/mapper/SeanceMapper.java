package com.vasilisa.cinema.service.mapper;

import com.vasilisa.cinema.controller.dto.SeanceDto;
import com.vasilisa.cinema.model.Seance;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SeanceMapper {
    SeanceMapper INSTANCE = Mappers.getMapper(SeanceMapper.class);

    List<SeanceDto> mapSeanceDtos(List<Seance> seances);

    SeanceDto mapSeanceDto(Seance seance);

    Seance mapSeance(SeanceDto seanceDto);

}
