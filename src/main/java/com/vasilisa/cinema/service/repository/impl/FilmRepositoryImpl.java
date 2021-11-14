package com.vasilisa.cinema.service.repository.impl;

import com.vasilisa.cinema.service.model.Film;
import com.vasilisa.cinema.service.repository.FilmRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
                .orElseThrow(() -> new RuntimeException("film is not find"));
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
            throw new RuntimeException("film is not found");
        }
        return film;
    }

    @Override
    public void deleteFilm(int id) {
        list.removeIf(u -> u.getId() == id);
    }
}
