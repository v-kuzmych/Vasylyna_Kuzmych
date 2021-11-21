package com.vasilisa.cinema.repository.impl;

import com.vasilisa.cinema.model.Film;
import com.vasilisa.cinema.repository.FilmRepository;
import com.vasilisa.cinema.service.exception.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

@Component
public class FilmRepositoryImpl implements FilmRepository {

    private final List<Film> list = new ArrayList<>();

    @Override
    public List<Film> getAllFilms() {
        return new ArrayList<>(list);
    }

    @Override
    public Film getFilm(int id) {
        return list.stream()
                .filter(film -> film.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Film createFilm(Film film) {
        list.add(film);
        return film;
    }

    @Override
    public Film updateFilm(int id, Film film) {
        boolean isDeleted = list.removeIf(u -> u.getId() == id);
        if (isDeleted){
            list.add(film);
        } else {
            throw new EntityNotFoundException(format("Film with id %s not found", id));
        }
        return film;
    }

    @Override
    public void deleteFilm(int id) {
        list.removeIf(u -> u.getId() == id);
    }
}
