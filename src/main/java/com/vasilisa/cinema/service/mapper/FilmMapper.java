package com.vasilisa.cinema.service.mapper;

import com.vasilisa.cinema.controller.dto.FilmDto;
import com.vasilisa.cinema.model.Film;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FilmMapper {

    FilmMapper INSTANCE = Mappers.getMapper(FilmMapper.class);

    List<FilmDto> mapFilmDtos(List<Film> films);

    FilmDto mapFilmDto(Film film);

    Film mapFilm(FilmDto filmDto);
}
