package com.vasilisa.cinema.service;

import com.vasilisa.cinema.dto.FilmDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FilmService {

    List<FilmDto> getAllFilms(Pageable pageable);

    FilmDto getFilm(Long id);

    FilmDto createFilm(FilmDto filmDTO);

    FilmDto updateFilm(FilmDto filmDTO);

    void deleteFilm(Long id);
}
