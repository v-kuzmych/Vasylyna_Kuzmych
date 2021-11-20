package com.vasilisa.cinema.repository;

import com.vasilisa.cinema.model.Film;

import java.util.List;

public interface FilmRepository {

    List<Film> getAllFilms();

    Film getFilm(int id);

    Film createFilm(Film film);

    Film updateFilm(int id, Film film);

    void deleteFilm(int id);
}
