package com.vasilisa.cinema.service;

import com.vasilisa.cinema.dto.FilmDto;

import java.util.List;

public interface FilmService {
    List<FilmDto> getAllFilms();

    FilmDto getFilm(int id);

    FilmDto createFilm(FilmDto filmDTO);

    FilmDto updateFilm(int id, FilmDto filmDTO);

    void deleteFilm(int id);
}
