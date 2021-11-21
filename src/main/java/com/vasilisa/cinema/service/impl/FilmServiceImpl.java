package com.vasilisa.cinema.service.impl;

import com.vasilisa.cinema.controller.dto.FilmDto;
import com.vasilisa.cinema.model.Film;
import com.vasilisa.cinema.service.FilmService;
import com.vasilisa.cinema.repository.FilmRepository;
import com.vasilisa.cinema.service.exception.EntityNotFoundException;
import com.vasilisa.cinema.service.mapper.FilmMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Slf4j
@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;

    @Override
    public List<FilmDto> getAllFilms() {
        log.info("get all films");
        return FilmMapper.INSTANCE.mapFilmDtos(filmRepository.getAllFilms());
    }

    @Override
    public FilmDto getFilm(int id) {
        log.info("get film by id {}", id);
        Film film = filmRepository.getFilm(id);
        if (film == null) {
            throw new EntityNotFoundException(format("Film with id %s not found", id));
        }
        return FilmMapper.INSTANCE.mapFilmDto(film);
    }

    @Override
    public FilmDto createFilm(FilmDto filmDto) {
        log.info("create film with id {}", filmDto.getId());
        Film film = FilmMapper.INSTANCE.mapFilm(filmDto);
        film = filmRepository.createFilm(film);
        return FilmMapper.INSTANCE.mapFilmDto(film);
    }

    @Override
    public FilmDto updateFilm(int id, FilmDto filmDto) {
        log.info("update film with id {}", id);
        Film film = FilmMapper.INSTANCE.mapFilm(filmDto);
        film = filmRepository.updateFilm(id, film);
        return FilmMapper.INSTANCE.mapFilmDto(film);
    }

    @Override
    public void deleteFilm(int id) {
        log.info("delete film with id {}", id);
        filmRepository.deleteFilm(id);
    }
}
