package com.vasilisa.cinema.service;

import com.vasilisa.cinema.controller.dto.FilmDTO;

import java.util.List;

public interface FilmService {
    List<FilmDTO> getAllFilms();

    FilmDTO getFilm(int id);

    FilmDTO createFilm(FilmDTO filmDTO);

    FilmDTO updateFilm(int id, FilmDTO filmDTO);

    void deleteFilm(int id);
}
