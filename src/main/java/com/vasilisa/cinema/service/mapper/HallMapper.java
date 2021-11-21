package com.vasilisa.cinema.service.mapper;

import com.vasilisa.cinema.controller.dto.HallDto;
import com.vasilisa.cinema.model.Hall;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface HallMapper {

    HallMapper INSTANCE = Mappers.getMapper(HallMapper.class);

    List<HallDto> mapHallDtos(List<Hall> halls);

    HallDto mapHallDto(Hall hall);

    Hall mapHall(HallDto hallDto);
}
